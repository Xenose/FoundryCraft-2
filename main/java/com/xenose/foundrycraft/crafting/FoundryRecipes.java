package com.xenose.foundrycraft.crafting;

import com.xenose.foundrycraft.AddObjects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FoundryRecipes 
{
	public static void Init() 
	{	
		Smelting.Init();
		
		AddBasicMetalRecipes(AddObjects.aluminium.GetBlock(), AddObjects.aluminium.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.cobalt.GetBlock(), AddObjects.cobalt.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.copper.GetBlock(), AddObjects.copper.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.lead.GetBlock(), AddObjects.lead.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.lithium.GetBlock(), AddObjects.lithium.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.magnesium.GetBlock(), AddObjects.magnesium.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.nickel.GetBlock(), AddObjects.nickel.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.platinum.GetBlock(), AddObjects.platinum.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.silver.GetBlock(), AddObjects.silver.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.tin.GetBlock(), AddObjects.tin.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.titanium.GetBlock(), AddObjects.titanium.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.tungsten.GetBlock(), AddObjects.tungsten.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.uranium.GetBlock(), AddObjects.uranium.GetIngot(), 9);
		AddBasicMetalRecipes(AddObjects.zinc.GetBlock(), AddObjects.zinc.GetIngot(), 9);
		
		//AddBlockRecipe(AddObjects.lowgradesteelblock, AddObjects.lowgradesteelingot, 9);
	}
	
	private static void AddBasicMetalRecipes(Block output, Item input, int size) 
	{
		AddBlockRecipe(output, input, size);
		AddIngotRecipe(output, input, size);
	}
	
	private static void AddBlockRecipe(Block output, Item input, int size) 
	{
		ResourceLocation name = output.getRegistryName();
		
		if (size == 4)
			GameRegistry.addShapedRecipe(name, null, new ItemStack(Item.getItemFromBlock(output), 1), new Object[] { "ii","ii", 'i', new ItemStack(input, 1)});
		if (size == 9)
			GameRegistry.addShapedRecipe(name, null, new ItemStack(Item.getItemFromBlock(output), 1), new Object[] { "iii","iii","iii", 'i', new ItemStack(input, 1) });
	}
	
	private static void AddIngotRecipe(Block input, Item output, int size) 
	{
		ResourceLocation name = output.getRegistryName();
		System.out.println("adding ingot recipe" + output.getUnlocalizedName());
		
		Ingredient[] ingredient = { Ingredient.fromItem(Item.getItemFromBlock(input)) };
		
		if (size == 4)
			GameRegistry.addShapelessRecipe(name, null, new ItemStack(output, 4), ingredient);
		if (size == 9)
			GameRegistry.addShapelessRecipe(name, null, new ItemStack(output, 9), ingredient);
	}
}
