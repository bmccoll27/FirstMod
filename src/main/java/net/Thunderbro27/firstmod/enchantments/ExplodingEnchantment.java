package net.Thunderbro27.firstmod.enchantments;

import com.mojang.serialization.MapCodec;
import net.Thunderbro27.firstmod.MyFirstMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MyFirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public record ExplodingEnchantment() implements EnchantmentEntityEffect {
    public static final MapCodec<ExplodingEnchantment> CODEC = MapCodec.unit(ExplodingEnchantment::new);
    public static boolean hasEnchant = false;
    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if (!pEntity.isAlive()) {
            int raidis = 0;
            if (pEnchantmentLevel == 1) {

                raidis = 3;
                pEntity.level().explode(pEntity, pEntity.getX(), pEntity.getY(), pEntity.getZ(), raidis, Level.ExplosionInteraction.MOB);
            }

            if (pEnchantmentLevel == 2) {
                raidis = 5;
                pEntity.level().explode(pEntity, pEntity.getX(), pEntity.getY(), pEntity.getZ(), raidis, Level.ExplosionInteraction.MOB);
            }

            if (pEnchantmentLevel == 3) {
                raidis = 10;
                pEntity.level().explode(pEntity, pEntity.getX(), pEntity.getY(), pEntity.getZ(), raidis, Level.ExplosionInteraction.MOB);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }


}
