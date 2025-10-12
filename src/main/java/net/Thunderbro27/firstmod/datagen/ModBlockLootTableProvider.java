package net.Thunderbro27.firstmod.datagen;

import net.Thunderbro27.firstmod.block.ModBlocks;
import net.Thunderbro27.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }



    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.CONVERTER.get());
        dropSelf(ModBlocks.GOOBRITE_BLOCK.get());

        this.add(ModBlocks.RUBY_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_DEEPSLATE_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.GOOBRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.GOOBRITE_ORE.get(), ModItems.GOOBRITE.get()));
        this.add(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.GOOBRITE_DEEPSLATE_ORE.get(), ModItems.GOOBRITE.get()));
        this.add(ModBlocks.RUBY_SLABS.get(),
                block -> createSlabItemTable(ModBlocks.RUBY_SLABS.get()));

        dropSelf(ModBlocks.RUBY_TRAPDOOR.get());
        dropSelf(ModBlocks.RUBY_WALLS.get());
        dropSelf(ModBlocks.RUBY_FENCE.get());
        dropSelf(ModBlocks.RUBY_BUTTON.get());
        dropSelf(ModBlocks.RUBY_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.RUBY_STAIRS.get());
        dropSelf(ModBlocks.RUBY_FENCE_GATE.get());
        dropSelf(ModBlocks.RUBY_LAMP.get());

        this.add(ModBlocks.RUBY_DOOR.get(),
                block -> createDoorTable(ModBlocks.RUBY_DOOR.get()));

    }
    protected LootTable.Builder createMultiOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get):: iterator;
    }
}
