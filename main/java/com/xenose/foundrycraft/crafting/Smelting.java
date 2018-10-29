package com.xenose.foundrycraft.crafting;

import com.xenose.foundrycraft.AddObjects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Smelting {
	
	public static void Init() 
	{
		AddSmeltingRecipe(AddObjects.aluminium.GetOre(), new ItemStack(AddObjects.aluminium.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.cobalt.GetOre(), new ItemStack(AddObjects.cobalt.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.copper.GetOre(), new ItemStack(AddObjects.copper.GetIngot(), 1), 0.2f);
		AddSmeltingRecipe(AddObjects.lead.GetOre(), new ItemStack(AddObjects.lead.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.lithium.GetOre(), new ItemStack(AddObjects.lithium.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.magnesium.GetOre(), new ItemStack(AddObjects.magnesium.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.nickel.GetOre(), new ItemStack(AddObjects.nickel.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.platinum.GetOre(), new ItemStack(AddObjects.platinum.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.silver.GetOre(), new ItemStack(AddObjects.silver.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.tin.GetOre(), new ItemStack(AddObjects.tin.GetIngot(), 1), 0.1f);
		AddSmeltingRecipe(AddObjects.titanium.GetOre(), new ItemStack(AddObjects.titanium.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.tungsten.GetOre(), new ItemStack(AddObjects.tungsten.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.uranium.GetOre(), new ItemStack(AddObjects.uranium.GetIngot(), 1), 10);
		AddSmeltingRecipe(AddObjects.zinc.GetOre(), new ItemStack(AddObjects.zinc.GetIngot(), 1), 10);
		
		AddSmeltingRecipe(AddObjects.lowgradesteeldust, new ItemStack(AddObjects.lowgradesteelingot, 1),  2);
		
		AddSmeltingRecipe(Blocks.GLASS, new ItemStack(AddObjects.clearglass), 0);
	}
	
	private static void AddSmeltingRecipe(Block input, ItemStack output, float xp) 
	{
		GameRegistry.addSmelting(input, output, xp);
	}
	
	private static void AddSmeltingRecipe(Item input, ItemStack output, float xp) 
	{
		GameRegistry.addSmelting(input, output, xp);
	}
}
