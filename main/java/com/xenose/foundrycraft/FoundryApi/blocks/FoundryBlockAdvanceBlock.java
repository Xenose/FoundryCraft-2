package com.xenose.foundrycraft.FoundryApi.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class FoundryBlockAdvanceBlock extends FoundryBlock
{
	public static final PropertyDirection _facing = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public FoundryBlockAdvanceBlock(Material materialIn, String name) 
	{ 
		super(materialIn, name); 
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		worldIn.setBlockState(pos, state.withProperty(_facing, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return getDefaultState().withProperty(_facing, EnumFacing.getFront((meta & 3) + 2));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(_facing).getIndex() -2;
	}

	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, _facing);
	}
}
