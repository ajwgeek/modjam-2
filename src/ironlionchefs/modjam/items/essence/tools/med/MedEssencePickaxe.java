package ironlionchefs.modjam.items.essence.tools.med;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MedEssencePickaxe extends ItemPickaxe
{

	public MedEssencePickaxe(int par1)
	{
		super(par1, EnumToolMaterial.IRON);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		is.addEnchantment(Enchantment.efficiency, 2);
		is.addEnchantment(Enchantment.fortune, 2);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:MedEssencePickaxe");
		this.setUnlocalizedName("Normal Essence Pickaxe");
	}
}