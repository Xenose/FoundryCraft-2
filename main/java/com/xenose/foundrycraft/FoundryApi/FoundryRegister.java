package com.xenose.foundrycraft.FoundryApi;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class FoundryRegister 
{
	public static int itemCount = 0;
	public static int blockCount = 0;
	
	protected static IForgeRegistry<Item> itemReg;
	protected static IForgeRegistry<Block> blockReg;
	
	public static void Init() 
	{
		itemReg = GameRegistry.findRegistry(Item.class);
		blockReg = GameRegistry.findRegistry(Block.class);
	}
	
	public static void AddItemToRegistry(FoundryItem item) 
	{
		itemReg.register(item);
		item.SetTexture();
		
		System.out.println("added " + item.getRegistryName() + " to registry");
		itemCount++;
	}
	
	public static void AddBlockToRegistry(FoundryBlock block) 
	{
		blockReg.register(block);
		
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		itemReg.register(item);

		block.SetTexture();
		
		System.out.println("added " + item.getRegistryName() + " to registry");
		blockCount++;
	}
	
	public static void RegisterItemTexture()
	{
		
	}
}
