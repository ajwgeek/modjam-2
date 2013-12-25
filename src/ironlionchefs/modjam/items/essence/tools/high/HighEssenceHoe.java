package ironlionchefs.modjam.items.essence.tools.high;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HighEssenceHoe extends ItemHoe
{

	public HighEssenceHoe(int par1)
	{
		super(par1, EnumToolMaterial.EMERALD);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
		System.out.println(par4 + ", " + par5 + ", " + par6 + ", " + par7);
		
		for (int i = 0; i < 5; i ++)
		{
			for (int j = 0; j < 5; j ++)
			{
				if (par3World.getBlockId(par4 + i, par5, par6 + j) == Block.grass.blockID || par3World.getBlockId(par4 + i, par5, par6 + j) == Block.dirt.blockID)
				{
					par3World.setBlock(par4 + i, par5, par6 + j, Block.tilledField.blockID);
				}
			}
		}
		
		if (par3World.getBlockId(par4 + 2, par5, par6 + 2) == Block.grass.blockID || par3World.getBlockId(par4 + 2, par5, par6 + 2) == Block.dirt.blockID ||  par3World.getBlockId(par4 + 2, par5, par6 + 2) == Block.tilledField.blockID)
		{
			par3World.setBlock(par4 + 2, par5, par6 + 2, Block.waterStill.blockID);
		}
		
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:HighEssenceHoe");
		this.setUnlocalizedName("Potent Essence Hoe");
	}
}