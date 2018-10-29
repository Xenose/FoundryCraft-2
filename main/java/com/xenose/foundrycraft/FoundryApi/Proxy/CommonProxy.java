package com.xenose.foundrycraft.FoundryApi.Proxy;


import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface CommonProxy 
{
	void Init();
	
	void SetItemTexture(Item item, int meta, String id);
	void SetBlockTexture(Block block, int meta, String id);
}
