package com.xenose.foundrycraft.FoundryApi.client.tabs;

import com.xenose.foundrycraft.init.AddObjects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FoundryTab extends CreativeTabs
{
	private int iconIndex;

	public FoundryTab(String tabName, int iconIndex) 
	{
		super(tabName);
		this.iconIndex = iconIndex;
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		switch (iconIndex) {
		case 0:
			return new ItemStack(AddObjects.lamp);
			
		case 1:
			return new ItemStack(AddObjects.metalList.get("platinum").GetOre());
			
		default:
			return new ItemStack(AddObjects.clearglass);
		}
	}
}
