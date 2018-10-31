package com.xenose.foundrycraft.FoundryApi.items;

import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryCraftData;

import net.minecraft.item.Item;

public class FoundryItem extends Item
{
	public FoundryItem() {}
	
	public FoundryItem(String name)
	{
		this.setRegistryName(FoundryCraftData.id, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(getCreativeTab().MISC);
		
		System.out.println(this.getRegistryName());
		System.out.println(this.getUnlocalizedName());
	}
	

	public void SetTexture() 
	{
		FoundryCraft.commonProxy.SetItemTexture(this, 0, "inventory");
	}
}
