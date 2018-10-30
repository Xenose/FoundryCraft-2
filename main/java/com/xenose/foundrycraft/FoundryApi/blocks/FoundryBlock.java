package com.xenose.foundrycraft.FoundryApi.blocks;

import java.util.Random;

import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryCraftData;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.xml.transform.RewriteRule;;

public class FoundryBlock extends Block
{
	public FoundryBlock(String name) 
	{
		super(Material.ROCK);
		InitBlock(name);
	}
	
	public FoundryBlock(Material material,String name) 
	{
		super(material);
		InitBlock(name);
	}
	
	private void InitBlock(String name) 
	{
		this.setRegistryName(FoundryCraftData.id, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(getCreativeTabToDisplayOn().MISC);
	}
	
	public void SetHardness(float hardness) 
	{
		this.setHardness(hardness);
	}
	
	public void SetTexture() 
	{
		FoundryCraft.commonProxy.SetBlockTexture(this, 0, "inventory");
	}
	
	public void SetLightLevel(float value) 
	{
		this.setLightLevel(value);
	}
	
	public void SetLightOpacity(int opacity)
    {
        this.setLightOpacity(opacity);
    }
	
	public void SetSoundType(SoundType sound) 
	{
		this.setSoundType(sound);
	}
	
	public void SetBlockLayer() 
	{
	}
	
	
	public void QuantityDropped(Random random)
    {
		this.quantityDropped(random);
    }

    public void IsFullBlock(IBlockState state)
    {
    }
}
