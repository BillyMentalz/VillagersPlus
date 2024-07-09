package com.bettervillagers;

import com.bettervillagers.util.DataHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "bettervillagers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void loadEvents(){
		ServerEntityEvents.ENTITY_LOAD.register( (entity , serverworld) -> {
			if (entity instanceof VillagerEntity villagerentity) {
				DataHandler.AddAttachment(villagerentity);
			}
		});
		ServerLivingEntityEvents.MOB_CONVERSION.register( (previous , following , equipment) -> {
			if (previous instanceof VillagerEntity villagerentity  && following instanceof ZombieVillagerEntity zombievillagerentity ) {
				DataHandler.ConvertAttachment(villagerentity , zombievillagerentity );
			}
			if (previous instanceof ZombieVillagerEntity zombievillagerentity && following instanceof VillagerEntity villagerentity) {
				DataHandler.ConvertAttachment(zombievillagerentity, villagerentity);
			}
		});
		ServerLivingEntityEvents.AFTER_DEATH.register ( (entity, damagesource) -> {
			if ( entity instanceof VillagerEntity villagerentity && !(damagesource.getAttacker() instanceof ZombieEntity )) {
				DataHandler.RemoveAttachment(villagerentity );
			}
		});
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		loadEvents();
		LOGGER.info("This code runs because it does.");
	}
}