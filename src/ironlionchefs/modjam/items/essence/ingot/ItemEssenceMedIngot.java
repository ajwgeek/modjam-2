package ironlionchefs.modjam.items.essence.ingot;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceMedIngot extends Item
{

	public ItemEssenceMedIngot(int par1)
	{
		super(par1);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:MedEssenceIngot");
		this.setUnlocalizedName("Tier 2 Essence Ingot");
	}
}