package ironlionchefs.modjam.items.essence.tools.high;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HighEssenceAxe extends ItemAxe
{
	public HighEssenceAxe(int par1)
	{
		super(par1, EnumToolMaterial.EMERALD);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack is, World w, int id, int x, int y, int z, EntityLivingBase elb)
	{
		System.out.println("Destroyed block at " + x + ", " + y + ", " + z);
		for (int i = 0; i < 64; i++)
		{
			if (w.getBlockId(x, y + i, z) == Block.wood.blockID)
			{
				w.destroyBlock(x, y + i, z, true);
			}
			
			if (w.getBlockId(x, y - i, z) == Block.wood.blockID)
			{
				w.destroyBlock(x, y - i, z, true);
			}
		}
		
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:HighEssenceAxe");
		this.setUnlocalizedName("Potent Essence Axe");
	}
}