package ironlionchefs.modjam.items.essence.armor.med;

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

public class MedEssenceBoots extends ItemArmor
{

	public MedEssenceBoots(int par1)
	{
		super(par1, EnumArmorMaterial.IRON, 3, 3);
	}

	@Override
	public String getArmorTexture(ItemStack is, Entity e, int s, int i)
	{
		if (i == 1)
		{
			return "ModJam:textures/items/Med_Layer_1.png";
		}
		else
		{
			return "ModJam:textures/items/Med_Layer_2.png";
		}
	}
	
	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		is.addEnchantment(Enchantment.projectileProtection, 2);
		is.addEnchantment(Enchantment.protection, 2);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:MedEssenceBoots");
		this.setUnlocalizedName("Normal Essence Boots");
	}
}