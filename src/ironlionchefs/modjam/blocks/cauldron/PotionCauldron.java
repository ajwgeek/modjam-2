package ironlionchefs.modjam.blocks.cauldron;

import ironlionchefs.modjam.items.potion.ItemPotionMixed;
import ironlionchefs.modjam.src.ModJam;
import ironlionchefs.modjam.world.provider.magic.MagicWorldTeleporter;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionCauldron extends BlockCauldron
{
	@SideOnly(Side.CLIENT)
	private static Icon field_94378_a;
	@SideOnly(Side.CLIENT)
	private Icon cauldronTopIcon;
	@SideOnly(Side.CLIENT)
	private static Icon cauldronBottomIcon;
	public Icon water;

	public PotionCauldron(int par1)
	{
		super(par1);
		this.setHardness(5f);
		this.setResistance(40f);
		this.setTickRandomly(true);
	}

	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
			if (thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if (thePlayer.dimension != ModJam.magicDimID)
			{
				thePlayer.timeUntilPortal = 2000;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ModJam.magicDimID, new MagicWorldTeleporter(thePlayer.mcServer.worldServerForDimension(ModJam.magicDimID)));
			}
			else
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new MagicWorldTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
		
		super.onFallenUpon(par1World, par2, par3, par4, par5Entity, par6);
	}

	@Override
	public TileEntity createTileEntity(World w, int metadata)
	{
		return new TileEntityCauldron();
	}

	public void randomDisplayTick(World w, int x, int y, int z, Random r)
	{
	}

	public boolean hasTileEntity()
	{
		return true;
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.cauldronTopIcon : (par1 == 0 ? PotionCauldron.cauldronBottomIcon : this.blockIcon);
	}

	public int getRenderType()
	{
		return ModJam.potionCauldronRenderID;
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		return super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
	}

	public void onBlockHarvested(World w, int par2, int par3, int par4, int par5, EntityPlayer ep)
	{
		TileEntityCauldron r1 = (TileEntityCauldron) w.getBlockTileEntity(par2, par3, par4);
		r1.stripNBTData(par2, par3, par4);

		w.setBlockToAir(par2, par3, par4);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		PotionCauldron.field_94378_a = par1IconRegister.registerIcon("ModJam:potionCauldronInner");
		this.cauldronTopIcon = par1IconRegister.registerIcon("ModJam:potionCauldronTop");
		PotionCauldron.cauldronBottomIcon = par1IconRegister.registerIcon("ModJam:potionCauldronBottom");
		this.blockIcon = par1IconRegister.registerIcon("ModJam:potionCauldronSide");
		this.water = par1IconRegister.registerIcon("ModJam:tintableWater");
		this.setUnlocalizedName("Potion Cauldron");
	}

	public static Icon func_94375_b(String par0Str)
	{
		return par0Str.equals("inner") ? PotionCauldron.field_94378_a : (par0Str.equals("bottom") ? PotionCauldron.cauldronBottomIcon : null);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();

		if (par1World.isRemote || itemstack == null || itemstack.getItem() == null)
		{
			return true;
		}
		else
		{
			if (itemstack.getItem() == Item.glassBottle)
			{

				TileEntityCauldron r1 = (TileEntityCauldron) par1World.getBlockTileEntity(par2, par3, par4);

				List<Integer> pots = r1.readNBTDataArray(par2, par3, par4, "potions");
				ItemPotionMixed a = (ItemPotionMixed) ModJam.mixedPotionItem;
				ItemStack is = new ItemStack(a, 1);

				if (is.getTagCompound() == null)
				{
					is.setTagCompound(new NBTTagCompound());
				}

				int pos = 1;
				if (pots.size() > 0)
				{
					for (int i : pots)
					{
						is.getTagCompound().setInteger("pot" + pos, i);
						pos++;
					}
				}

				par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, is);

				r1.update(par2, par3, par4, Item.potion.getColorFromDamage(itemstack.getItemDamage()), 0, new int[0]);
				
				
			}
			else if (itemstack.getItem() == Item.potion)
			{
				if (itemstack.getItemDamage() == 0 || itemstack.getItemDamage() == 16 || itemstack.getItemDamage() == 32 || itemstack.getItemDamage() == 64 || itemstack.getItemDamage() == 128)
				{
					return true;
				}

				TileEntityCauldron r1 = (TileEntityCauldron) par1World.getBlockTileEntity(par2, par3, par4);

				int curHeight = r1.readNBTData(par2, par3, par4, "height");
				List<Integer> pots = r1.readNBTDataArray(par2, par3, par4, "potions");

				if (curHeight < 3)
				{
					if (Item.potion.getEffects(itemstack).size() > 0 && !pots.contains(itemstack.getItemDamage()))
					{
						pots.add(itemstack.getItemDamage());
						
						int[] finList = new int[pots.size()];

						for (int i = 0; i < pots.size(); i++)
						{
							finList[i] = pots.get(i);
						}

						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle, 1));
						r1.update(par2, par3, par4, Item.potion.getColorFromDamage(itemstack.getItemDamage()), curHeight + 1, finList);
					}
					else
					{
						ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Your cauldron already contains this potion!");
					}


				}
				else
				{
					return true;
				}
			}

			Minecraft.getMinecraft().renderGlobal.markBlockForUpdate(par2, par3, par4);

			return true;
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return this.blockID;
	}

	public static int func_111045_h_(int par0)
	{
		return par0;
	}
}