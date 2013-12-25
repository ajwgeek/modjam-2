package ironlionchefs.modjam.items.essence.tools.high;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HighEssencePickaxe extends ItemPickaxe
{

	public HighEssencePickaxe(int par1)
	{
		super(par1, EnumToolMaterial.EMERALD);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		is.addEnchantment(Enchantment.efficiency, 3);
		is.addEnchantment(Enchantment.fortune, 3);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:HighEssencePickaxe");
		this.setUnlocalizedName("Potent Essence Pickaxe");
	}
}