package com.bettervillagers.util;


import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.Map;


import static com.bettervillagers.ExampleMod.MOD_ID;

public class VillagerBrainHandler {
    public static final AttachmentType<Integer> VILLAGER_MOOD = AttachmentRegistry.createPersistent(Identifier.of(MOD_ID,"villager_mood"), Codec.INT);
    private static int DEFAULT_VALUE = 50;
    public static final void AddAttachment (VillagerEntity entity) {
        if (entity.hasAttached(VILLAGER_MOOD)) {
            return;
        }
        entity.setAttached(VILLAGER_MOOD,DEFAULT_VALUE);
    }
    public static final void AddAttachment (ZombieVillagerEntity entity) {
        if (entity.hasAttached(VILLAGER_MOOD)) {
            return;
        }
        entity.setAttached(VILLAGER_MOOD,DEFAULT_VALUE);
    }
    public static final void ConvertAttachment (VillagerEntity entity , ZombieVillagerEntity convert) {
        if(!entity.hasAttached((VILLAGER_MOOD))){
            return;
        }
        convert.setAttached(VILLAGER_MOOD,entity.getAttached(VILLAGER_MOOD));
    };
    public static final void ConvertAttachment(ZombieVillagerEntity entity , VillagerEntity convert ) {
        if(!entity.hasAttached((VILLAGER_MOOD))){
            return;
        }
        convert.setAttached(VILLAGER_MOOD,entity.getAttached(VILLAGER_MOOD));
    };

    public static final void RemoveAttachment (VillagerEntity entity) {
        if (!entity.hasAttached(VILLAGER_MOOD)) {
            return;
        }
        entity.removeAttached(VILLAGER_MOOD);
    };
    public static final String ReadAttachment (VillagerEntity entity) {
        if (entity.hasAttached(VILLAGER_MOOD)) {
            return entity.getAttached(VILLAGER_MOOD).toString();
        }
        else {
            return ("ERROR: Attachment not attached.");
        }
    }

    public static void ChangeAttachment (VillagerEntity entity, Integer num) {
        if (entity.hasAttached(VILLAGER_MOOD)) {

            entity.setAttached(VILLAGER_MOOD,entity.getAttached(VILLAGER_MOOD) + num);
        }
    }
    /**public static Map<String, Integer> GenerateMood() {
        Map<String, Integer> CURRENT_MOOD = Map.of(
                "MOTIVATION", 50,
                "DISCONTENT", 50,
                "ENERGY", 60,
                "AMBITION", 0
        ) ;
        return CURRENT_MOOD;
    }; **/

}
