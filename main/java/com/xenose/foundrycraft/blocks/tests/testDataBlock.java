package com.xenose.foundrycraft.blocks.tests;


import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryCraftData;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlockAdvanceBlock;
import com.xenose.foundrycraft.TileEntitys.tests.testTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class testDataBlock extends FoundryBlockAdvanceBlock implements ITileEntityProvider
{

	public testDataBlock(String name) 
	{
		super(Material.IRON, name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		for (int x = 0; x <= 8; x++) 
		{
			for (int y = 0; y <= 8; y++) 
			{
				for (int z = 0; z <= 8; z++) 
				{
					if (y == 0 || y == 8 || z == 0 || z == 8 || x == 0 || x == 8)
						worldIn.setBlockState(new BlockPos(pos.getX() + x - 4, pos.getY() - 1 + y, pos.getZ() + z - 4), Blocks.STONE.getDefaultState(), 1);
					else
						worldIn.setBlockToAir(new BlockPos(pos.getX() + x - 4, pos.getY() - 1 + y, pos.getZ() + z - 4));
				}
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
