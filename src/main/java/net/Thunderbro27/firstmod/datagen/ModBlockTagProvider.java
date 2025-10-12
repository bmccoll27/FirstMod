package net.Thunderbro27.firstmod.datagen;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.block.ModBlocks;
import net.Thunderbro27.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MyFirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.RUBY_DEEPSLATE_ORE.get())
                .add(ModBlocks.CONVERTER.get())
                .add(ModBlocks.GOOBRITE_ORE.get())
                .add(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.GOOBRITE_BLOCK.get());

    tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.RUBY_ORE.get())
            .add(ModBlocks.RUBY_DEEPSLATE_ORE.get())
            .add(ModBlocks.GOOBRITE_ORE.get())
            .add(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get())
            .add(ModBlocks.GOOBRITE_ORE.get())
            .add(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get())
            .add(ModBlocks.GOOBRITE_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE.get());
    tag(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE.get());
    tag(BlockTags.WALLS).add(ModBlocks.RUBY_WALLS.get());
    tag(BlockTags.PRESSURE_PLATES).add(ModBlocks.RUBY_PRESSURE_PLATE.get());

    tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
            .add(ModBlocks.RUBY_ORE.get())
            .add(ModBlocks.RUBY_DEEPSLATE_ORE.get())
            .add(ModBlocks.GOOBRITE_ORE.get())
            .add(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get())
            .add(ModBlocks.GOOBRITE_BLOCK.get())
            .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    tag(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
            .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
            .remove(ModTags.Blocks.NEEDS_RUBY_TOOL);
    }
}
