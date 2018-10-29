package com.xenose.foundrycraft.FoundryApi.Proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ServerProxy implements CommonProxy
{

	@Override
	public void Init(){}
	@Override
	public void SetItemTexture(Item item, int meta, String id){}
	@Override
	public void SetBlockTexture(Block block, int meta, String id){}

}
