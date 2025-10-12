package net.Thunderbro27.firstmod.block;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.block.custom.ConverterBlock;
import net.Thunderbro27.firstmod.block.custom.RubyLamp;
import net.Thunderbro27.firstmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyFirstMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RUBY_DEEPSLATE_ORE = registerBlock("ruby_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));


    public static final RegistryObject<Block> GOOBRITE_ORE = registerBlock("goobrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.FROGLIGHT)));

    public static final RegistryObject<Block> GOOBRITE_DEEPSLATE_ORE = registerBlock("goobrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.FROGLIGHT)));

    public static final RegistryObject<Block> GOOBRITE_BLOCK = registerBlock("goobrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<ConverterBlock> CONVERTER = registerBlock("converter",
            () -> new ConverterBlock(BlockBehaviour.Properties.of().strength(3f)));

    public static final RegistryObject<Block> RUBY_LAMP = registerBlock("ruby_lamp",
            () -> new RubyLamp(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(RubyLamp.CLICKED) ? 15 : 0)));

    public static final RegistryObject<StairBlock> RUBY_STAIRS = registerBlock("ruby_stairs",
            () -> new StairBlock(ModBlocks.RUBY_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
public static final RegistryObject<SlabBlock> RUBY_SLABS = registerBlock("ruby_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

public static final RegistryObject<PressurePlateBlock> RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<ButtonBlock> RUBY_BUTTON = registerBlock("ruby_button",
            () -> new ButtonBlock(BlockSetType.IRON,5,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> RUBY_FENCE = registerBlock("ruby_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> RUBY_WALLS = registerBlock("ruby_walls",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> RUBY_DOOR = registerBlock("ruby_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));


        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){

            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }
        private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

        }


    public static void  register(IEventBus eventBus){
        BLOCKS.register(eventBus);

    }
}
