package com.xenose.foundrycraft.items;

import com.xenose.foundrycraft.FoundryCraftData;
import com.xenose.foundrycraft.FoundryApi.FoundryItem;

import net.minecraft.item.ItemStack;

public class CoalDust extends FoundryItem 
{
	public CoalDust(String name)
	{
		super(name);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 800;
	}
}
