package ironlionchefs.modjam.items.potion;

import ironlionchefs.modjam.src.ColorCode;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPotionMixed extends ItemFood
{
	public ItemPotionMixed(int par1, int par2, boolean par3)
	{
		super(par1, 0, false);
		this.setAlwaysEdible();
	}

	@Override
	public void addInformation(ItemStack is, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (is.getTagCompound() == null)
		{
			is.setTagCompound(new NBTTagCompound());
		}
		
		int pot1 = is.getTagCompound().getInteger("pot1");
		int pot2 = is.getTagCompound().getInteger("pot2");
		int pot3 = is.getTagCompound().getInteger("pot3");
		
		if (is.getTagCompound().hasKey("pot1"))
		{
			for (Object pe : Item.potion.getEffects(pot1))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				
				if (pe1 != null && pe1.getEffectName() != null)
				{
					if (pe1.getEffectName().contains("heal") || pe1.getEffectName().contains("harm"))
					{
						Integer amp = pe1.getAmplifier();
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " " + amp.toString().replace("1", "I").replace("2", "II"));
					}
					else
					{
						Integer dur = pe1.getDuration() / 20;
						Integer minutes = dur / 60;
						Integer seconds = dur % 60;
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " (" + minutes.toString() + ":" + String.format("%02d", seconds) + ")");
					}
				}
			}
		}

		if (is.getTagCompound().hasKey("pot2"))
		{
			for (Object pe : Item.potion.getEffects(pot2))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				
				if (pe1 != null && pe1.getEffectName() != null)
				{
					if (pe1.getEffectName().contains("heal") || pe1.getEffectName().contains("harm"))
					{
						Integer amp = pe1.getAmplifier();
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " " + amp.toString().replace("1", "I").replace("2", "II"));
					}
					else
					{
						Integer dur = pe1.getDuration() / 20;
						Integer minutes = dur / 60;
						Integer seconds = dur % 60;
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " (" + minutes.toString() + ":" + String.format("%02d", seconds) + ")");
					}
				}
			}
		}

		if (is.getTagCompound().hasKey("pot3"))
		{
			for (Object pe : Item.potion.getEffects(pot3))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				
				if (pe1 != null && pe1.getEffectName() != null)
				{
					if (pe1.getEffectName().contains("heal") || pe1.getEffectName().contains("harm"))
					{
						Integer amp = pe1.getAmplifier();
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " " + amp.toString().replace("1", "I").replace("2", "II"));
					}
					else
					{
						Integer dur = pe1.getDuration() / 20;
						Integer minutes = dur / 60;
						Integer seconds = dur % 60;
						par3List.add(ColorCode.GOLD + (I18n.func_135053_a(pe1.getEffectName())) + ColorCode.WHITE + " (" + minutes.toString() + ":" + String.format("%02d", seconds) + ")");
						System.out.println(pe1.getAmplifier());
					}
				}
			}
		}
	}

	@Override
	public ItemStack onEaten(ItemStack is, World w, EntityPlayer ep)
	{
		super.onEaten(is, w, ep);
		
		int pot1 = is.getTagCompound().getInteger("pot1");
		int pot2 = is.getTagCompound().getInteger("pot2");
		int pot3 = is.getTagCompound().getInteger("pot3");
		
		if (is.getTagCompound().hasKey("pot1"))
		{
			for (Object pe : Item.potion.getEffects(pot1))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				ep.addPotionEffect(pe1);
			}
		}

		if (is.getTagCompound().hasKey("pot2"))
		{
			for (Object pe : Item.potion.getEffects(pot2))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				ep.addPotionEffect(pe1);
			}
		}

		if (is.getTagCompound().hasKey("pot3"))
		{
			for (Object pe : Item.potion.getEffects(pot3))
			{
				PotionEffect pe1 = (PotionEffect) pe;
				ep.addPotionEffect(pe1);
			}
		}

		return new ItemStack(Item.glassBottle.itemID, 1, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:MixedPotion");
		this.setUnlocalizedName("Tier 2 Essence Ingot");
	}
}