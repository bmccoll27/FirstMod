package net.Thunderbro27.firstmod.item;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyFirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUBY_ITEMS_TAB = CREATIVE_MODE_TABS.register("ruby_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.firstmod.ruby_items"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.ROCK.get());
                        output.accept(ModItems.RUBY_PICK.get());
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());
                        output.accept(ModItems.RUBY_CHISEL.get());
                        output.accept(ModItems.RUBY_HAMMER.get());
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        output.accept(ModItems.COCONUT.get());
                        output.accept(ModItems.STEAK_AND_FRIES.get());
                        output.accept(ModItems.COCONUT_WATER.get());
                        output.accept(ModItems.GOOBRITE.get());
                        output.accept(ModItems.RUBY_BOW.get());
                        output.accept(ModItems.GOOBRITE_PICKAXE.get());
                    })
            .build());

    public static final RegistryObject<CreativeModeTab> RUBY_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ruby_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK.get()))
                    .withTabsBefore(RUBY_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.firstmod.ruby_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.RUBY_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.RUBY_STAIRS.get());
                        output.accept(ModBlocks.RUBY_DOOR.get());
                        output.accept(ModBlocks.RUBY_BUTTON.get());
                        output.accept(ModBlocks.RUBY_FENCE.get());
                        output.accept(ModBlocks.RUBY_FENCE_GATE.get());
                        output.accept(ModBlocks.RUBY_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RUBY_SLABS.get());
                        output.accept(ModBlocks.RUBY_WALLS.get());
                        output.accept(ModBlocks.RUBY_TRAPDOOR.get());
                        output.accept(ModBlocks.GOOBRITE_BLOCK.get());
                        output.accept(ModBlocks.GOOBRITE_ORE.get());
                        output.accept(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.CONVERTER.get());
                        output.accept(ModBlocks.RUBY_LAMP.get());
                    })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
