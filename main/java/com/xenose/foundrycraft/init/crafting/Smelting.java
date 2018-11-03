package com.xenose.foundrycraft.init.crafting;

import com.xenose.foundrycraft.init.AddObjects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Smelting {
	
	public static void Init() 
	{
		AddSmeltingRecipe(AddObjects.metalList.get("aluminium").GetOre(), 	new ItemStack(AddObjects.metalList.get("aluminium").GetIngot(), 1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("cobalt").GetOre(), 		new ItemStack(AddObjects.metalList.get("cobalt").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("copper").GetOre(), 		new ItemStack(AddObjects.metalList.get("copper").GetIngot(), 	1), 	0.2f);
		AddSmeltingRecipe(AddObjects.metalList.get("lead").GetOre(), 		new ItemStack(AddObjects.metalList.get("lead").GetIngot(), 		1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("lithium").GetOre(), 	new ItemStack(AddObjects.metalList.get("lithium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("magnesium").GetOre(), 	new ItemStack(AddObjects.metalList.get("magnesium").GetIngot(), 1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("nickel").GetOre(), 		new ItemStack(AddObjects.metalList.get("nickel").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("platinum").GetOre(), 	new ItemStack(AddObjects.metalList.get("platinum").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("silver").GetOre(), 		new ItemStack(AddObjects.metalList.get("silver").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("tin").GetOre(), 		new ItemStack(AddObjects.metalList.get("tin").GetIngot(), 		1), 	0.1f);
		AddSmeltingRecipe(AddObjects.metalList.get("titanium").GetOre(), 	new ItemStack(AddObjects.metalList.get("titanium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("tungsten").GetOre(), 	new ItemStack(AddObjects.metalList.get("tungsten").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("uranium").GetOre(), 	new ItemStack(AddObjects.metalList.get("uranium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("zinc").GetOre(), 		new ItemStack(AddObjects.metalList.get("zinc").GetIngot(), 		1), 	10);
		
		AddSmeltingRecipe(AddObjects.metalList.get("aluminium").GetDust(), 	new ItemStack(AddObjects.metalList.get("aluminium").GetIngot(), 1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("cobalt").GetDust(), 	new ItemStack(AddObjects.metalList.get("cobalt").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("copper").GetDust(), 	new ItemStack(AddObjects.metalList.get("copper").GetIngot(), 	1), 	0.2f);
		AddSmeltingRecipe(AddObjects.metalList.get("lead").GetDust(), 		new ItemStack(AddObjects.metalList.get("lead").GetIngot(), 		1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("lithium").GetDust(), 	new ItemStack(AddObjects.metalList.get("lithium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("magnesium").GetDust(), 	new ItemStack(AddObjects.metalList.get("magnesium").GetIngot(), 1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("nickel").GetDust(), 	new ItemStack(AddObjects.metalList.get("nickel").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("platinum").GetDust(), 	new ItemStack(AddObjects.metalList.get("platinum").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("silver").GetDust(), 	new ItemStack(AddObjects.metalList.get("silver").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("tin").GetDust(), 		new ItemStack(AddObjects.metalList.get("tin").GetIngot(), 		1), 	0.1f);
		AddSmeltingRecipe(AddObjects.metalList.get("titanium").GetDust(), 	new ItemStack(AddObjects.metalList.get("titanium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("tungsten").GetDust(), 	new ItemStack(AddObjects.metalList.get("tungsten").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("uranium").GetDust(), 	new ItemStack(AddObjects.metalList.get("uranium").GetIngot(), 	1), 	10);
		AddSmeltingRecipe(AddObjects.metalList.get("zinc").GetDust(), 		new ItemStack(AddObjects.metalList.get("zinc").GetIngot(), 		1), 	10);
		
		AddSmeltingRecipe(AddObjects.metalList.get("lowgradesteel").GetDust(), new ItemStack(AddObjects.metalList.get("lowgradesteel").GetIngot(), 1),  2);
		
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
