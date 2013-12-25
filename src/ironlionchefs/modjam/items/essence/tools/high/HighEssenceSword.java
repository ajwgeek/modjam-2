package ironlionchefs.modjam.items.essence.tools.high;

import ironlionchefs.modjam.world.generator.magic.StructureCastle;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HighEssenceSword extends ItemSword
{

	public HighEssenceSword(int par1)
	{
		super(par1, EnumToolMaterial.EMERALD);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		new StructureCastle().generate(par3World, itemRand, par4, par5, par6);
		
		return true;
	}
	
	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		is.addEnchantment(Enchantment.smite, 3);
		is.addEnchantment(Enchantment.baneOfArthropods, 3);
		is.addEnchantment(Enchantment.sharpness, 3);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:HighEssenceSword");
		this.setUnlocalizedName("Potent Essence Sword");
	}
}