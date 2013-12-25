package ironlionchefs.modjam.items.pendants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ironlionchefs.modjam.items.pendants.enchants.PendantEnchantRegistry;
import ironlionchefs.modjam.items.pendants.general.PendantLevel;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPendant extends ItemArmor
{
	private PendantLevel level;

	// TODO finish these items
	static EnumArmorMaterial armorPendant = EnumArmorMaterial.CHAIN;
	private PotionEffect pe;
	private int curTicks = 0;
	private int ticks = 2880;

	public ItemPendant(int id, PendantLevel level)
	{
		super(id, armorPendant, 0, 1);
		setLevel(level);
		this.setMaxDamage(100000);
		this.setMaxStackSize(1);
		this.setFull3D();
	}
   
	public PendantLevel getLevel()
	{
		return level;
	}

	public void setLevel(PendantLevel l)
	{
		this.level = l;
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}

	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer ep)
	{
		Random r = new Random();
		
		if( is.stackTagCompound == null )
            is.setTagCompound( new NBTTagCompound() );
		
		if (getLevel() == PendantLevel.stone)
		{
			pe = PendantEnchantRegistry.stonePendantEnchants.get(r.nextInt(2));
		}
		else if (getLevel() == PendantLevel.iron)
		{
			pe = PendantEnchantRegistry.ironPendantEnchants.get(r.nextInt(3));
		}
		else if (getLevel() == PendantLevel.gold)
		{
			pe = PendantEnchantRegistry.goldPendantEnchants.get(r.nextInt(4));
		}
		else if (getLevel() == PendantLevel.diamond)
		{
			pe = PendantEnchantRegistry.diamondPendantEnchants.get(r.nextInt(9));
		}

		is.setItemDamage(pe.getPotionID());
		List<String> l = new ArrayList<String>();
		
		l.add(pe.getEffectName());
		this.addInformation(is, ep,l , true);
	}


	@Override
	public String getArmorTexture(ItemStack is, Entity e, int s, int i)
	{
		if (getLevel() == PendantLevel.stone)
		{
			return "ModJam:textures/items/StonePendant_layer_1.png";
		}
		else if (getLevel() == PendantLevel.iron)
		{
			return "ModJam:textures/items/IronPendant_layer_1.png";
		}
		else if (getLevel() == PendantLevel.gold)
		{
			return "ModJam:textures/items/GoldPendant_layer_1.png";
		}
		else
		{
			return "ModJam:textures/items/DiamondPendant_layer_1.png";
		}
	}
	
	@Override
	public void onArmorTickUpdate(World w, EntityPlayer p, ItemStack is)
	{
		
		if (p.inventory.armorInventory[2] != null && !(p.inventory.armorInventory[2].getItemDamage() == 0))
		{
			if (p.inventory.armorInventory[2].getItem() instanceof ItemPendant)
			{
				if(p.inventory.armorInventory[2].stackTagCompound == null )
				{
					this.curTicks = 0;
				}
				else
				{
					this.curTicks = p.inventory.armorInventory[2].stackTagCompound.getInteger("expiration");
					curTicks ++;
					p.inventory.armorInventory[2].stackTagCompound.setInteger("expiration", curTicks);
				}

				if (curTicks >= ticks)
				{
					p.inventory.armorInventory[2] = new ItemStack(0, 0, 0);
				}

				int gatheredID = p.inventory.armorInventory[2].getItemDamage();

				PotionEffect pe1 = new PotionEffect(gatheredID, 1, 1);
				pe1.duration = 40;
				p.addPotionEffect(pe1);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		if (getLevel() == PendantLevel.stone)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantStone");
			this.setUnlocalizedName("Stone Pendant");
		}
		else if (getLevel() == PendantLevel.iron)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantIron");
			this.setUnlocalizedName("Iron Pendant");
		}
		else if (getLevel() == PendantLevel.gold)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantGold");
			this.setUnlocalizedName("Gold Pendant");
		}
		else if (getLevel() == PendantLevel.diamond)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantDiamond");
			this.setUnlocalizedName("Diamond Pendant");
		}
	}
}