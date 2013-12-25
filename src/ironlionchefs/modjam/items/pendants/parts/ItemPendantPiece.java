package ironlionchefs.modjam.items.pendants.parts;

import ironlionchefs.modjam.items.pendants.general.PendantLevel;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPendantPiece extends Item
{
	private PendantLevel level;
	
	public ItemPendantPiece(int id, PendantLevel level)
	{
		super(id);
		setLevel(level);
	}
	
	protected void setLevel(PendantLevel level2)
	{
		this.level = level2;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		if (getLevel() == PendantLevel.stone)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantStonePart");
			this.setUnlocalizedName("Stone Pendant Part");
		}
		else if (getLevel() == PendantLevel.iron)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantIronPart");
			this.setUnlocalizedName("Iron Pendant Part");
		}
		else if (getLevel() == PendantLevel.gold)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantGoldPart");
			this.setUnlocalizedName("Gold Pendant Part");
		}
		else if (getLevel() == PendantLevel.diamond)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantDiamondPart");
			this.setUnlocalizedName("Diamond Pendant Part");
		}
	}

	protected PendantLevel getLevel()
	{
		return level;
	}
}