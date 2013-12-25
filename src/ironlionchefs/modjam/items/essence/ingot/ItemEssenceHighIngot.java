package ironlionchefs.modjam.items.essence.ingot;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceHighIngot extends Item
{

	public ItemEssenceHighIngot(int par1)
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
		this.itemIcon = register.registerIcon("ModJam:HighEssenceIngot");
		this.setUnlocalizedName("Tier 3 Essence Ingot");
	}
}