package net.Thunderbro27.firstmod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class TickingEffect extends MobEffect {
    private static int exploistionRadius = 3;
    protected TickingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if(!pLivingEntity.isAlive()){
            pLivingEntity.level().explode(pLivingEntity, pLivingEntity.getX(),
                    pLivingEntity.getY(), pLivingEntity.getZ(),
                    (float) exploistionRadius * pAmplifier, Level.ExplosionInteraction.MOB);
        }

        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
