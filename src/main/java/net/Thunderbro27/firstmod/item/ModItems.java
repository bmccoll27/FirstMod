package net.Thunderbro27.firstmod.item;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyFirstMod.MOD_ID);

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties()));


    //Ruby Items------------------------------------------------------------------------------
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICK = ITEMS.register("ruby_pick",
            () -> new PickaxeItem(ModToolTier.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.RUBY,1f,-2.8f))));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTier.RUBY, new Item.Properties()Y
                    //Adding item property to the sword: The lower your Y level, the more dmg it does.
                    .attributes(SwordItem.createAttributes(ModToolTier.RUBY,3,-2.4f))));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTier.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.RUBY,6f,-3.2f))));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTier.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.RUBY,1.5f,-3f))));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTier.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.RUBY,0f,-3f))));
    public static final RegistryObject<Item> RUBY_CHISEL = ITEMS.register("ruby_chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(ModToolTier.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.RUBY,7,-3.5f))));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));
    public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow",
            () -> new RubyBowItem(new Item.Properties().durability(400)) );
    //End of Ruby Items------------------------------------------------------------------------
    // Ruby Items Notes
    // 1. p_328988_ is pAttackDamage
    //      1A. p_329067_ is pAttackSpeed
    //      1B. m_320415_ is createToolAttributes()
    // 2. m_321370_ is the getDurability method, its parameter(p_333841_) is pDurabilityFactor


    //Goobrite Items---------------------------------------------------------------------------
    public static final RegistryObject<Item> GOOBRITE = ITEMS.register("goobrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOOBRITE_PICKAXE = ITEMS.register("goobrite_pickaxe",
            () -> new PickaxeItem(ModToolTier.GOOBRITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTier.GOOBRITE, 1F,-3.8f))));
    /*public static final RegistryObject<Item> GOOBRITE_SWORD = ITEMS.register("goobrite_sword",
            ()-> new SwordItem(ModToolTier.GOOBRITE, new Item.Properties()
                    .attributes(SwordItem.m_322253_(ModToolTier.RUBY,1,-2.4f))));
    public static final RegistryObject<Item> GOOBRITE_SHOVEL = ITEMS.register("goobrite_shovel",
            ()-> new ShovelItem(ModToolTier.GOOBRITE, new Item.Properties()
                    .attributes(PickaxeItem.m_320415_(ModToolTier.RUBY,1.5f,-3f))));*/

    //End of Goobriteite Items--------------------------------------------------------------------

    //Food And Drink Items---------------------------------------------------------------------
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COCONUT)));
    public static final RegistryObject<Item> STEAK_AND_FRIES = ITEMS.register("steak_and_fries",
            () -> new Item(new Item.Properties().food(ModFoodProperties.STEAK_AND_FRIES)));
    public static final RegistryObject<Item> COCONUT_WATER = ITEMS.register("coconut_water",
            () -> new CoconutWaterItem(new Item.Properties().food(ModFoodProperties.COCONUT_WATER)));
    //End of Food And Drink Items--------------------------------------------------------------

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
