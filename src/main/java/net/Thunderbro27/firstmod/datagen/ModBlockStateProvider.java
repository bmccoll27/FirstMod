package net.Thunderbro27.firstmod.datagen;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.block.ModBlocks;
import net.Thunderbro27.firstmod.block.custom.RubyLamp;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MyFirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RUBY_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.GOOBRITE_BLOCK);
        blockWithItem(ModBlocks.GOOBRITE_ORE);
        blockWithItem(ModBlocks.GOOBRITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.CONVERTER);
        slabBlock(ModBlocks.RUBY_SLABS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        buttonBlock(ModBlocks.RUBY_BUTTON.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock(ModBlocks.RUBY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceBlock(ModBlocks.RUBY_FENCE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock(ModBlocks.RUBY_FENCE_GATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock(ModBlocks.RUBY_WALLS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.RUBY_DOOR.get(), modLoc("block/ruby_door_bottom"), modLoc("block/ruby_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.RUBY_TRAPDOOR.get(), modLoc("block/ruby_trapdoor"), true,"cutout");

        stairsBlock(ModBlocks.RUBY_STAIRS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));





        blockItem(ModBlocks.RUBY_SLABS);
        blockItem(ModBlocks.RUBY_STAIRS);
        blockItem(ModBlocks.RUBY_FENCE);
        blockItem(ModBlocks.RUBY_FENCE_GATE);
        blockItem(ModBlocks.RUBY_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.RUBY_WALLS);
        customLamp();
    }





    private void customLamp() {
        getVariantBuilder(ModBlocks.RUBY_LAMP.get()).forAllStates(state -> {
            if(state.getValue(RubyLamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(MyFirstMod.MOD_ID, "block/" + "ruby_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(MyFirstMod.MOD_ID, "block/" + "ruby_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.RUBY_LAMP.get(), models().cubeAll("ruby_lamp_on",
                ResourceLocation.fromNamespaceAndPath(MyFirstMod.MOD_ID, "block/" + "ruby_lamp_on")));
    }


    private void blockWithItem(RegistryObject<? extends Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {

        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("first_mod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));


    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {

        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("first_mod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));


    }
}
