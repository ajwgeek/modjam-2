package ironlionchefs.modjam.items.essence.dust;

import ironlionchefs.modjam.items.essence.general.EssenceLevel;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssence extends Item
{
	private EssenceLevel level;

	public ItemEssence(int par1, EssenceLevel l)
	{
		super(par1);
		setLevel(l);
	}

	public EssenceLevel getLevel()
	{
		return this.level;
	}

	private void setLevel(EssenceLevel l)
	{
		this.level = l;
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		if (getLevel() == EssenceLevel.low)
		{
			this.itemIcon = register.registerIcon("ModJam:LowEssence");
			this.setUnlocalizedName("Weak Essence Dust");
		}
		else if (getLevel() == EssenceLevel.med)
		{
			this.itemIcon = register.registerIcon("ModJam:MedEssence");
			this.setUnlocalizedName("Normal Essence Dust");
		}
		else if (getLevel() == EssenceLevel.high)
		{
			this.itemIcon = register.registerIcon("ModJam:HighEssence");
			this.setUnlocalizedName("Potent Essence Dust");
		}
	}
}