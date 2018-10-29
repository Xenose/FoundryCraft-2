package com.xenose.foundrycraft.crafting;

import com.xenose.foundrycraft.AddObjects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FoundryRecipes 
{
	public static void Init() 
	{	
		Smelting.Init();
		
		AddBlockRecipe(AddObjects.aluminium.GetBlock(), AddObjects.aluminium.GetIngot(), 9);
		AddBlockRecipe(AddObjects.cobalt.GetBlock(), AddObjects.cobalt.GetIngot(), 9);
		AddBlockRecipe(AddObjects.copper.GetBlock(), AddObjects.copper.GetIngot(), 9);
		AddBlockRecipe(AddObjects.lead.GetBlock(), AddObjects.lead.GetIngot(), 9);
		AddBlockRecipe(AddObjects.lithium.GetBlock(), AddObjects.lithium.GetIngot(), 9);
		AddBlockRecipe(AddObjects.magnesium.GetBlock(), AddObjects.magnesium.GetIngot(), 9);
		AddBlockRecipe(AddObjects.nickel.GetBlock(), AddObjects.nickel.GetIngot(), 9);
		AddBlockRecipe(AddObjects.platinum.GetBlock(), AddObjects.platinum.GetIngot(), 9);
		AddBlockRecipe(AddObjects.silver.GetBlock(), AddObjects.silver.GetIngot(), 9);
		AddBlockRecipe(AddObjects.tin.GetBlock(), AddObjects.tin.GetIngot(), 9);
		AddBlockRecipe(AddObjects.titanium.GetBlock(), AddObjects.titanium.GetIngot(), 9);
		AddBlockRecipe(AddObjects.tungsten.GetBlock(), AddObjects.tungsten.GetIngot(), 9);
		AddBlockRecipe(AddObjects.uranium.GetBlock(), AddObjects.uranium.GetIngot(), 9);
		AddBlockRecipe(AddObjects.zinc.GetBlock(), AddObjects.zinc.GetIngot(), 9);
		
		//AddBlockRecipe(AddObjects.lowgradesteelblock, AddObjects.lowgradesteelingot, 9);
	}
	
	private static void AddBlockRecipe(Block output, Item input, int size) 
	{
		ResourceLocation name = output.getRegistryName();
		
		if (size == 4)
			GameRegistry.addShapedRecipe(name, null, new ItemStack(output, 1), new Object[] { "ii","ii", 'i', new ItemStack(input, 1)});
		if (size == 9)
			GameRegistry.addShapedRecipe(name, null, new ItemStack(output, 1), new Object[] { "iii","iii","iii", 'i', new ItemStack(input, 1) });
	}
}
