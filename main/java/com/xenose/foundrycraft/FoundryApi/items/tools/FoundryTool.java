package com.xenose.foundrycraft.FoundryApi.items.tools;

import java.util.Set;

import com.google.common.collect.Multimap;
import com.xenose.foundrycraft.FoundryCraftData;
import com.xenose.foundrycraft.FoundryApi.items.FoundryItem;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoundryTool extends FoundryItem
{
	private final Set<Block> _effectiveBlocks;
	protected float _efficiency = 3;
	protected float _attackDamage = 3;
	protected float _attackSpeed = 3;
	protected Item.ToolMaterial _toolMaterial;
	
	public FoundryTool(String name, Set<Block> effectiveBlocksIn)
	{
		super(name);
		_effectiveBlocks = effectiveBlocksIn;
		
	}
	
	public void SetAttackDmg(float dmg) { _attackDamage = dmg; }
	public void SetAttackSpeed(float speed) { _attackDamage = speed; }
	
	public float GetAttackDmg() { return _attackDamage; }
	public float GetAttackSpeed() { return _attackSpeed; }
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) 
	{
		for (String type : getToolClasses(stack)) 
		{
			if (state.getBlock().isToolEffective(type, state))
				return _efficiency;
		}
		
		return _effectiveBlocks.contains(state.getBlock()) ? _efficiency : 1.0F;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		stack.damageItem(2, attacker);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) 
	{
		if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D) 
		{
			stack.damageItem(1, entityLiving);
		}
		
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() { return true; }
	
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this._toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this._toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     *  
     * @param toRepair the {@code ItemStack} being repaired
     * @param repair the {@code ItemStack} being used to perform the repair
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this._toolMaterial.getRepairItemStack();
        
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) 
        	return true;
        
        return super.getIsRepairable(toRepair, repair);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)this._attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)this._attackSpeed, 0));
        }

        return multimap;
    }
	
    /*===================================== FORGE START =================================*/
    @javax.annotation.Nullable
    private String toolClass;
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @javax.annotation.Nullable net.minecraft.entity.player.EntityPlayer player, @javax.annotation.Nullable IBlockState blockState)
    {
        int level = super.getHarvestLevel(stack, toolClass,  player, blockState);
        if (level == -1 && toolClass.equals(this.toolClass))
        {
            return this._toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? com.google.common.collect.ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }
    /*===================================== FORGE END =================================*/
}
