package ironlionchefs.modjam.blocks.magic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockNewGrass extends Block
{
	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity instanceof EntityClientPlayerMP && par5Entity.dimension == ModJam.magicDimID)
		{
			((EntityClientPlayerMP) par5Entity).addPotionEffect(new PotionEffect(8, 1, 1));
			((EntityClientPlayerMP) par5Entity).addPotionEffect(new PotionEffect(1, 1, 1));
			((EntityClientPlayerMP) par5Entity).addPotionEffect(new PotionEffect(5, 1, 1));
			((EntityClientPlayerMP) par5Entity).addPotionEffect(new PotionEffect(23, 1, 1));
		}
		
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
	}

	@SideOnly(Side.CLIENT)
	private Icon field_94422_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94421_b;

	public BlockNewGrass(int par1)
	{
		super(par1, Material.grass);
		this.setTickRandomly(true);
		this.setResistance(2.0F);
		this.setHardness(2.0F);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.field_94422_a : (par1 == 0 ? Block.dirt.getBlockTextureFromSide(par1) : this.blockIcon);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		if (par2Random.nextInt(27) == 0)
		{
			return ModJam.essenceLow.itemID;
		}
		else
		{
			return Block.dirt.blockID;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("ModJam:BlockNewGrass_side");
		this.field_94422_a = par1IconRegister.registerIcon("ModJam:BlockNewGrass_top");
		this.field_94421_b = par1IconRegister.registerIcon("grass_side_snowed");
		this.setUnlocalizedName("Magic Grass");
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

		if (par5Random.nextInt(10) == 0)
		{
			par1World.spawnParticle("portal", (double) ((float) par2 + par5Random.nextFloat()), (double) ((float) par3 + 1.1F), (double) ((float) par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
		}
	}
}