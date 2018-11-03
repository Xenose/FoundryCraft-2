package com.xenose.foundrycraft.FoundryApi.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FoundryTabs extends CreativeTabs
{
	public FoundryTabs(int id, String name) 
	{
		super(id,name);
	}
	
	public static final FoundryTabs MISC = new FoundryTabs(0, "misc");

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
