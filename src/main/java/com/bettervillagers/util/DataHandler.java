package com.bettervillagers.util;


import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;

import java.util.List;


import static com.bettervillagers.ExampleMod.LOGGER;
import static com.bettervillagers.ExampleMod.MOD_ID;

public class DataHandler {
    public static final AttachmentType<List<Integer>> VILLAGER_MOOD = AttachmentRegistry.createPersistent(Identifier.of(MOD_ID,"villager_mood"), Codec.INT.listOf());

    public static final void AddAttachment (VillagerEntity entity) {
        if (entity.hasAttached(VILLAGER_MOOD)) {
            return;
        }
        entity.setAttached(VILLAGER_MOOD,MoodMixer.GenerateMood());
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
}
