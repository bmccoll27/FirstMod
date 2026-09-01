package net.Thunderbro27.firstmod.enchantments;

import com.mojang.serialization.MapCodec;
import net.Thunderbro27.firstmod.MyFirstMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MyFirstMod.MOD_ID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> THUNDERING =
            ENTITY_ENCHANTMENT_EFFECTS.register("thundering", ()-> ThunderingEnchantment.CODEC);
    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> EXPLODING =
            ENTITY_ENCHANTMENT_EFFECTS.register("exploding", ()-> ExplodingEnchantment.CODEC);

    public static void register(IEventBus eventBus){
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);

    }
}
