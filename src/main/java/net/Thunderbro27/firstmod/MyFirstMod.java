package net.Thunderbro27.firstmod;

import com.mojang.logging.LogUtils;
import net.Thunderbro27.firstmod.block.ModBlocks;
import net.Thunderbro27.firstmod.component.ModDataComponent;
import net.Thunderbro27.firstmod.enchantments.ModEnchantmentEffects;
import net.Thunderbro27.firstmod.item.ModCreativeModeTabs;
import net.Thunderbro27.firstmod.util.ModItemProperties;
import net.Thunderbro27.firstmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MyFirstMod.MOD_ID)
public class MyFirstMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "first_mod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public MyFirstMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        //Custom mod tab. Mod contents below
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponent.register(modEventBus);
        // Register enchantment effect codecs so datagen and runtime know about them
        ModEnchantmentEffects.register(modEventBus);



        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ROCK);
            event.accept(ModItems.RUBY);

        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.RUBY_DEEPSLATE_ORE);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.CONVERTER.get());
            event.accept(ModBlocks.RUBY_LAMP);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.RUBY_PICK);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.RUBY_SHOVEL);
            event.accept(ModItems.RUBY_HOE);
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_CHISEL);
            event.accept(ModItems.RUBY_HAMMER);
            event.accept(ModItems.RUBY_BOW);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.COCONUT);
            event.accept(ModItems.STEAK_AND_FRIES);
            event.accept(ModItems.COCONUT_WATER);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
