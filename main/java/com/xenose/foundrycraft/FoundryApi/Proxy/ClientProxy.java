package com.xenose.foundrycraft.FoundryApi.Proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements CommonProxy
{

	@Override
	public void Init() 
	{	
		//Minecraft.getMinecraft().toggleFullscreen();
	}

	@Override
	public void SetItemTexture(Item item, int meta, String id) 
	{
		System.out.println(new ModelResourceLocation(item.getUnlocalizedName()));
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void SetBlockTexture(Block block, int meta, String id) 
	{
		System.out.println(new ModelResourceLocation(block.getUnlocalizedName()));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), id));
	}

}
