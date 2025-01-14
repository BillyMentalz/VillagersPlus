package com.bettervillagers.util;

import com.bettervillagers.ExampleMod;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.logging.Logger;
/**
public class VillagerBrain {
    protected static void initialize() {
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }

    public static final ComponentType<Integer> VILLAGER_BRAIN = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(ExampleMod.MOD_ID, "villager_brain"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );

**/



    /**
    private final String PERSONALITY;
    private Map<String,Integer> SWING ;

    public VillagerBrain(String PERSONALITY, Map<String,Integer> SWING) {}

    public String getPERSONALITY() {return this.PERSONALITY; };
    public Map<String,Integer> getSWING() {return this.SWING;};
    public static final Codec<VillagerBrain> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(Codec.STRING.fieldOf("PERSONALITY").
            forGetter(VillagerBrain::getPERSONALITY),
            Codec.unboundedMap(Codec.STRING,Codec.INT).fieldOf("SWING")
            .forGetter(VillagerBrain::getSWING))
            ).apply(instance, VillagerBrain::new);
    public static void componentRegister() {

    }
}
     **/