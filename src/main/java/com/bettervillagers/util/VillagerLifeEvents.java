package com.bettervillagers.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class VillagerLifeEvents {
    public static void eventRegister(){
        ServerEntityEvents.ENTITY_LOAD.register( (entity , serverworld) -> {
            if (entity instanceof VillagerEntity villagerentity) {
                VillagerBrainHandler.AddAttachment(villagerentity);

            }
        });
        ServerLivingEntityEvents.MOB_CONVERSION.register( (previous , following , equipment) -> {
            if (previous instanceof VillagerEntity villagerentity  && following instanceof ZombieVillagerEntity zombievillagerentity ) {
                VillagerBrainHandler.ConvertAttachment(villagerentity , zombievillagerentity );
            }
            if (previous instanceof ZombieVillagerEntity zombievillagerentity && following instanceof VillagerEntity villagerentity) {
                VillagerBrainHandler.ConvertAttachment(zombievillagerentity, villagerentity);
            }
        });
        ServerLivingEntityEvents.AFTER_DEATH.register ( (entity, damagesource) -> {
            if ( entity instanceof VillagerEntity villagerentity && !(damagesource.getAttacker() instanceof ZombieEntity)) {
                VillagerBrainHandler.RemoveAttachment(villagerentity );
            }
        });
        UseEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
            if (entity instanceof VillagerEntity villager && !player.isSpectator()) {
                if (player.getStackInHand(hand).isOf(Items.BOOK)) {
                    VillagerBrainHandler.ChangeAttachment(villager,-1);
                    player.sendMessage(Text.literal(VillagerBrainHandler.ReadAttachment(villager)),true);
                    return ActionResult.CONSUME_PARTIAL;
                }
                if (player.isSneaking() ) {
                    player.sendMessage(Text.literal(VillagerBrainHandler.ReadAttachment(villager)),true);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        }));
    }
}
