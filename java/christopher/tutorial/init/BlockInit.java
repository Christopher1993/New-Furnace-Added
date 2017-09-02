package christopher.tutorial.init;

import christopher.tutorial.init.blocks.CustomBlockFurnace;
import christopher.tutorial.init.blocks.DiamondBrick;
import christopher.tutorial.init.blocks.DiamondBrickStairs;
import christopher.tutorial.init.blocks.fence.DiamondBrickFence;
import christopher.tutorial.init.blocks.fence.DiamondBrickFenceGate;
import christopher.tutorial.init.blocks.slab.DiamondBrickDoubleSlab;
import christopher.tutorial.init.blocks.slab.DiamondBrickHalfSlab;
import christopher.tutorial.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit 
{
	public static DiamondBrick diamond_brick;
	public static DiamondBrickStairs diamond_brick_stairs;
	public static DiamondBrickHalfSlab diamond_brick_slab_half;
	public static DiamondBrickDoubleSlab diamond_brick_slab_double;
	public static DiamondBrickFence diamond_brick_fence;
	public static DiamondBrickFenceGate diamond_brick_fence_gate;
	
	public static CustomBlockFurnace custom_furnace_idle, custom_furnace_active;
	
	public static void init()
	{
		diamond_brick = new DiamondBrick("diamond_brick", 45.0F, 25000000.0F, 3);
		diamond_brick_stairs = new DiamondBrickStairs("diamond_brick_stairs", diamond_brick.getDefaultState());
		diamond_brick_slab_half = new DiamondBrickHalfSlab("diamond_brick_slab_half");
		diamond_brick_slab_double = new DiamondBrickDoubleSlab("diamond_brick_slab_double");
		diamond_brick_fence = new DiamondBrickFence("diamond_brick_fence", 45.0F, 25000000.0F);
		diamond_brick_fence_gate = new DiamondBrickFenceGate("diamond_brick_fence_gate", 45.0F, 25000000.0F);
		custom_furnace_active = new CustomBlockFurnace("custom_furnace_active", 45.0F, 25000000.0F, true);
		custom_furnace_idle = new CustomBlockFurnace("custom_furnace_idle", 45.0F, 25000000.0F, false);
	}
	
	public static void register()
	{
		registerBlock(diamond_brick);
		registerBlock(diamond_brick_stairs);
		registerBlock(diamond_brick_slab_half, new ItemSlab(diamond_brick_slab_half, diamond_brick_slab_half, diamond_brick_slab_double));
		ForgeRegistries.BLOCKS.register(diamond_brick_slab_double);
		registerBlock(diamond_brick_fence);
		registerBlock(diamond_brick_fence_gate);
		
		registerBlock(custom_furnace_idle);
		ForgeRegistries.BLOCKS.register(custom_furnace_active);
	}
	
	public static void registerBlock(Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void registerBlock(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
