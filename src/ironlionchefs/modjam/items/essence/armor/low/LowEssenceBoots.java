package ironlionchefs.modjam.items.essence.armor.low;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LowEssenceBoots extends ItemArmor
{

	public LowEssenceBoots(int par1)
	{
		super(par1, EnumArmorMaterial.CHAIN, 3, 3);
	}

	@Override
	public String getArmorTexture(ItemStack is, Entity e, int s, int i)
	{
		if (i == 1)
		{
			return "ModJam:textures/items/Low_Layer_1.png";
		}
		else
		{
			return "ModJam:textures/items/Low_Layer_2.png";
		}
	}
	

	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		is.addEnchantment(Enchantment.projectileProtection, 1);
		is.addEnchantment(Enchantment.protection, 1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:LowEssenceBoots");
		this.setUnlocalizedName("Weak Essence Boots");
	}
}