package ironlionchefs.modjam.blocks.ore;

import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreEssenceHighOverworld extends BlockOre
{
	public OreEssenceHighOverworld(int id)
	{
		super(id);
		this.setResistance(3.0F);
		this.setHardness(5.0F);
		this.setUnlocalizedName("Potent Essence Ore");
	}

	@Override
	public int idDropped(int i, Random r, int j)
	{
		return ModJam.essenceHigh.itemID;
	}

	@Override
	public int quantityDropped(Random r)
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.blockIcon = register.registerIcon("ModJam:OverOreEssenceHigh");
	}
}