package me.hyperboid.testmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "hyperstest";

	public static final Item TEST_ITEM = new Item(
		new Item.Settings()
		.group(ItemGroup.MISC)
	);
	
	public static final Block OBAMIUM_BLOCK = new Block(
		FabricBlockSettings
		.of(Material.STONE)
		.strength(0.9f, 3000f)
		.sounds(BlockSoundGroup.STONE)
		.breakByTool(FabricToolTags.PICKAXES)
	);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		Registry.register(
			Registry.ITEM,
			new Identifier(
				MOD_ID,"test_item"
			), TEST_ITEM
		);
		Registry.register(
			Registry.BLOCK,
			new Identifier(
				MOD_ID,"obamium_block"
			), OBAMIUM_BLOCK
		);
		Registry.register(
			Registry.ITEM,
			new Identifier(
				MOD_ID,"obamium_block"
			),
			new BlockItem(
				OBAMIUM_BLOCK,
				new Item.Settings()
				.group(ItemGroup.BUILDING_BLOCKS)
			)
		);
	}
}