package net.Thunderbro27.firstmod.effects;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MyFirstMod.MOD_ID);


    public static final RegistryObject<MobEffect> TICKING = MOB_EFFECTS.register("ticking",
            () -> new TickingEffect(MobEffectCategory.HARMFUL, 0xfc0303));


    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);

    }
}
