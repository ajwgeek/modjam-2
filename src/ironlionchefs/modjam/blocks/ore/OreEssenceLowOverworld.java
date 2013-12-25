package ironlionchefs.modjam.blocks.ore;

import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreEssenceLowOverworld extends BlockOre
{
	public OreEssenceLowOverworld(int id)
	{
		super(id);
		this.setResistance(3.0F);
		this.setHardness(5.0F);
		this.setUnlocalizedName("Weak Essence Ore");
	}

	@Override
	public int idDropped(int i, Random r, int j)
	{
		return ModJam.essenceLow.itemID;
	}

	@Override
	public int quantityDropped(Random r)
	{
		return r.nextInt(6);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.blockIcon = register.registerIcon("ModJam:OverOreEssenceLow");
	}
}