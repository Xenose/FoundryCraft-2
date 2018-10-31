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
		
		AddBasicMetalRecipes(AddObjects.metalList.get("aluminium").GetBlock(), 	AddObjects.metalList.get("aluminium").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("cobalt").GetBlock(), 	AddObjects.metalList.get("cobalt").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("copper").GetBlock(), 	AddObjects.metalList.get("copper").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("lead").GetBlock(), 		AddObjects.metalList.get("lead").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("lithium").GetBlock(), 	AddObjects.metalList.get("lithium").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("magnesium").GetBlock(), 	AddObjects.metalList.get("magnesium").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("nickel").GetBlock(), 	AddObjects.metalList.get("nickel").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("platinum").GetBlock(), 	AddObjects.metalList.get("platinum").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("silver").GetBlock(), 	AddObjects.metalList.get("silver").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("tin").GetBlock(), 		AddObjects.metalList.get("tin").GetIngot(), 		9);
		AddBasicMetalRecipes(AddObjects.metalList.get("titanium").GetBlock(), 	AddObjects.metalList.get("titanium").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("tungsten").GetBlock(), 	AddObjects.metalList.get("tungsten").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("uranium").GetBlock(), 	AddObjects.metalList.get("uranium").GetIngot(), 	9);
		AddBasicMetalRecipes(AddObjects.metalList.get("zinc").GetBlock(), 		AddObjects.metalList.get("zinc").GetIngot(), 		9);
		
		AddBlockRecipe(AddObjects.metalList.get("lowgradesteel").GetBlock(), AddObjects.metalList.get("lowgradesteel").GetIngot(), 9);
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
