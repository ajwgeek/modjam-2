package ironlionchefs.modjam.world.generator.magic;

import ironlionchefs.modjam.src.ModJam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureCastle extends WorldGenerator
{
	final int width = 29;
	final int length = 29;
	final int height = 13;

	public int getRandomLoot(Random r)
	{
		List<Item> l = new ArrayList<Item>();
		l.add(ModJam.diamondPendant);
		l.add(ModJam.ironPendant);
		l.add(ModJam.essenceHigh);
		l.add(ModJam.essenceHighIngot);
		l.add(ModJam.essenceMed);
		l.add(ModJam.essenceMedIngot);
		l.add(ModJam.goldPendant);
		l.add(ModJam.highEssenceAxe);
		l.add(ModJam.highEssenceBoots);
		l.add(ModJam.highEssenceChest);
		l.add(ModJam.highEssenceHelmet);
		l.add(ModJam.highEssenceHoe);
		l.add(ModJam.highEssenceLegs);
		l.add(ModJam.highEssencePickaxe);
		l.add(ModJam.highEssenceSword);
		l.add(ModJam.itemPendantPieceDiamond);
		l.add(ModJam.itemPendantPieceIron);
		
		return l.get(r.nextInt(l.size())).itemID;
	}
	
	public void addLoot(TileEntityChest tec, Random r)
	{
		for (int i = 0; i < 8; i++)
		{
			tec.setInventorySlotContents(r.nextInt(27), new ItemStack(getRandomLoot(r), 1, 0));
		}
	}
	
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		System.out.println("Added castle at " + par3 + ", " + par5);
		while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
		{
			--par4;
		}

		int l = par1World.getBlockId(par3, par4, par5);

		if (l != ModJam.blockNewDimGrass.blockID)
		{
			return false;
		}
		else
		{
			int i1;
			int j1;

			for (i1 = -2; i1 <= 2; ++i1)
			{
				for (j1 = -2; j1 <= 2; ++j1)
				{
					if (par1World.isAirBlock(par3 + i1, par4 - 1, par5 + j1) && par1World.isAirBlock(par3 + i1, par4 - 2, par5 + j1))
					{
						return false;
					}
				}
			}

			int x = par3;
			int y = par4;
			int z = par5;
			
			for (int j = 0; j < length; j++)
			{
				for (int i = 0; i < width; i++)
				{
					par1World.setBlock(x + i, y, z + j, Block.stoneBrick.blockID);
					
					for (int p = 0; p < 64; p++)
					{
						if (par1World.getBlockId(x + i, y + p + 1, z + j) != 0)
						{
							par1World.setBlock(x + i, y + p + 1, z + j, 0);
						}
					}
					
				}
			}
			
			for (int j = 0; j < height; j++)
			{
				for (int i = 0; i < width; i++)
				{
					par1World.setBlock(x + i, y + j, z, Block.stoneBrick.blockID);
					
					for (int p = 0; p < 64; p++)
					{
						if (par1World.getBlockId(x + i, y + j - p, z) == 0)
						{
							par1World.setBlock(x + i, y + j - p, z, Block.stoneBrick.blockID);
						}
					}
					
				}
			}

			for (int j = 0; j < height; j++)
			{
				for (int i = 0; i < width; i++)
				{
					par1World.setBlock(x, y + j, z + i, Block.stoneBrick.blockID);
					
					for (int p = 0; p < 64; p++)
					{
						if (par1World.getBlockId(x, y + j - p, z + i) == 0)
						{
							par1World.setBlock(x, y + j - p, z + i, Block.stoneBrick.blockID);
						}
					}
				}
			}

			for (int j = 0; j < height; j++)
			{
				for (int i = 0; i < width; i++)
				{
					par1World.setBlock(x + width, y + j, z + i, Block.stoneBrick.blockID);
					
					for (int p = 0; p < 64; p++)
					{
						if (par1World.getBlockId(x + width, y + j - p, z + i) == 0)
						{
							par1World.setBlock(x + width, y + j - p, z + i, Block.stoneBrick.blockID);
						}
					}
				}
			}

			for (int i = 0; i < width; i++)
			{
				for (int j = 0; j < height; j++)
				{
					par1World.setBlock(x + i + 1, y + j, z + length, Block.stoneBrick.blockID);

					for (int p = 0; p < 64; p++)
					{
						if (par1World.getBlockId(x + i + 1, y - p + j, z + length) == 0)
						{
							par1World.setBlock(x + i + 1, y - p + j, z + length, Block.stoneBrick.blockID);
						}
					}
				}
			}

			//Door Hole
			par1World.setBlock(x + 13, y + 1, z, Block.fenceIron.blockID);
			par1World.setBlock(x + 13, y + 2, z, Block.fenceIron.blockID);
			par1World.setBlock(x + 13, y + 3, z, Block.fenceIron.blockID);
			
			par1World.setBlock(x + 14, y + 1, z, 0);
			par1World.setBlock(x + 14, y + 2, z, 0);
			par1World.setBlock(x + 14, y + 3, z, Block.fenceIron.blockID);

			par1World.setBlock(x + 15, y + 1, z, 0);
			par1World.setBlock(x + 15, y + 2, z, 0);
			par1World.setBlock(x + 15, y + 3, z, Block.fenceIron.blockID);
			
			par1World.setBlock(x + 16, y + 1, z, Block.fenceIron.blockID);
			par1World.setBlock(x + 16, y + 2, z, Block.fenceIron.blockID);
			par1World.setBlock(x + 16, y + 3, z, Block.fenceIron.blockID);
			
			//Towers
			for (int i = 0; i < height + 6; i ++)
			{
				for (int b = 0; b < 6; b ++)
				{
					par1World.setBlock(x + b, y + 1 + i, z, Block.stoneBrick.blockID);
					par1World.setBlock(x, y + i + 1, z + b + 1, Block.stoneBrick.blockID);
					par1World.setBlock(x + 6, y + i + 1, z + b, Block.stoneBrick.blockID);
					par1World.setBlock(x + b + 1, y + i + 1, z + 6, Block.stoneBrick.blockID);
				}
			}
			
			for (int i = 0; i < height + 6; i ++)
			{
				for (int b = 0; b < 6; b ++)
				{
					par1World.setBlock(x + b, y + 1 + i, z + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x, y + i + 1, z + b + 1 + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x + 6, y + i + 1, z + b + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x + b + 1, y + i + 1, z + 6 + length - 6, Block.stoneBrick.blockID);
				}
			}
			
			for (int i = 0; i < height + 6; i ++)
			{
				for (int b = 0; b < 6; b ++)
				{
					par1World.setBlock(x + b + width - 5, y + 1 + i, z, Block.stoneBrick.blockID);
					par1World.setBlock(x + width, y + i + 1, z + b + 1, Block.stoneBrick.blockID);
					par1World.setBlock(x + width - 6, y + i + 1, z + b, Block.stoneBrick.blockID);
					par1World.setBlock(x + width - b - 1, y + i + 1, z + 6, Block.stoneBrick.blockID);
				}
			}
			
			for (int i = 0; i < height + 6; i ++)
			{
				for (int b = 0; b < 6; b ++)
				{
					par1World.setBlock(x + b + width - 5, y + 1 + i, z + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x + width, y + i + 1, z + b + 1 + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x + width - 6, y + i + 1, z + b + length - 6, Block.stoneBrick.blockID);
					par1World.setBlock(x + width - b - 1, y + i + 1, z + 6 + length - 6, Block.stoneBrick.blockID);
				}
			}
			
			//TODO Learn to use for loops for the next part... As it took over 5 horus to make!
			par1World.setBlock(x + 6, y + 1, z + 3, 0);
			par1World.setBlock(x + 6, y + 2, z + 3, 0);
			par1World.setBlock(x + 3, y + 1, z + 6, 0);
			par1World.setBlock(x + 3, y + 2, z + 6, 0);
			par1World.setBlock(x + 6, y + 1, z - 3 + length, 0);
			par1World.setBlock(x + 6, y + 2, z - 3 + length, 0);
			par1World.setBlock(x + 3, y + 1, z - 6 + length, 0);
			par1World.setBlock(x + 3, y + 2, z - 6 + length, 0);
			par1World.setBlock(x - 6 + length, y + 1, z + 3, 0);
			par1World.setBlock(x - 6 + length, y + 2, z + 3, 0);
			par1World.setBlock(x - 3 + length, y + 1, z + 6, 0);
			par1World.setBlock(x - 3 + length, y + 2, z + 6, 0);
			par1World.setBlock(x - 6 + length, y + 1, z - 3 + length, 0);
			par1World.setBlock(x - 6 + length, y + 2, z - 3 + length, 0);
			par1World.setBlock(x - 3 + length, y + 1, z - 6 + length, 0);
			par1World.setBlock(x - 3 + length, y + 2, z - 6 + length, 0);
			par1World.setBlock(x + 8, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 9, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 12, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 13, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 16, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 17, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 20, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 21, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 8, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 9, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 12, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 13, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 16, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 17, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 20, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 21, y + 13, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 8, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 9, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 12, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 13, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 16, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 17, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 20, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 21, y + 13, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 8, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 9, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 12, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 13, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 16, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 17, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 20, Block.stoneBrick.blockID);
			par1World.setBlock(x, y + 13, z + 21, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 8, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 9, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 12, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 13, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 16, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 17, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 20, Block.stoneBrick.blockID);
			par1World.setBlock(x + width, y + 13, z + 21, Block.stoneBrick.blockID);
			par1World.setBlock(x - 0, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 2, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 4, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 6, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 2, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 4, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 6, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 6, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 4, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 2, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 0, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 6, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 4, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 2, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 0, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 0, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 1, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 2, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 3, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 4, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 5, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 6, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 0, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 1 , Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 2, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 4, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 6, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 6, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 5, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 4, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 3, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 2, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 1, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 0, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 6, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 4, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 2, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 0, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1 + width, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 3 + width, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 5 + width, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z - 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 3 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x - 5 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 7, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 5, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 3, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 1, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 0, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 1, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 2, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 3, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 4, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 5, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 6, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 0 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 2 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 4 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 6 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 7, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 6, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 5, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 4, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 3, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 2, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 1, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width - 0, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 6 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 4 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 2 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z - 0 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + width + 1, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1 + width, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 3 + width, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 5 + width, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 7 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 3 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 5 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1 + width, y + 20, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 0, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 2, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 4, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 6, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 2 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 4 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 6 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 6, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 4, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 2, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 0, y + 19, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 6 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 4 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 2 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z - 0 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 19, z + 0 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z + 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 7, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 1, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 3, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 5, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 5 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 3 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 1 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x - 1, y + 20, z - 7 + length, Block.stoneBrick.blockID);
			par1World.setBlock(x + 11, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 12, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 13, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 14, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 15, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 16, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 17, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 18, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 1, z + 9, 2, 0);
			par1World.setBlock(x + 19, y + 1, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 10, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 11, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 12, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 13, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 14, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 15, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 16, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 17, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 18, 1, 0);
			par1World.setBlock(x + 19, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 19, 11, 0);
			par1World.setBlock(x + 19, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 19, y + 1, z + 9, 9, 0);
			par1World.setBlock(x + 10, y + 1, z + 9, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 10, y + 1, z + 9, 8, 0);
			par1World.setBlock(x + 10, y + 1, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 10, y + 1, z + 10, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 10, y + 1, z + 10, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 1, z + 12, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 1, z + 13, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 1, z + 14, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 1, z + 15, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 1, z + 16, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 1, z + 17, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 1, z + 18, 0, 0);
			par1World.setBlock(x + 10, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 10, y + 1, z + 19, 11, 0);
			par1World.setBlock(x + 11, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 12, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 13, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 14, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 15, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 16, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 17, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 18, y + 1, z + 19, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 1, z + 19, 3, 0);
			par1World.setBlock(x + 12, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 13, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 14, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 15, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 16, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 17, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 2, z + 10, 2, 0);
			par1World.setBlock(x + 18, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 10, 9, 0);
			par1World.setBlock(x + 11, y + 2, z + 10, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 10, 8, 0);
			par1World.setBlock(x + 11, y + 2, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 11, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 12, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 13, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 14, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 15, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 16, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 17, 0, 0);
			par1World.setBlock(x + 11, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 11, y + 2, z + 18, 11, 0);
			par1World.setBlock(x + 12, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 13, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 14, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 15, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 16, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 17, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 2, z + 18, 3, 0);
			par1World.setBlock(x + 18, y + 2, z + 18, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 18, 9, 0);
			par1World.setBlock(x + 18, y + 2, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 17, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 16, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 15, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 14, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 13, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 12, 1, 0);
			par1World.setBlock(x + 18, y + 2, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 18, y + 2, z + 11, 1, 0);
			par1World.setBlock(x + 12, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 11, 8, 0);
			par1World.setBlock(x + 13, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 3, z + 11, 2, 0);
			par1World.setBlock(x + 14, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 3, z + 11, 2, 0);
			par1World.setBlock(x + 15, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 3, z + 11, 2, 0);
			par1World.setBlock(x + 16, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 3, z + 11, 2, 0);
			par1World.setBlock(x + 17, y + 3, z + 11, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 11, 9, 0);
			par1World.setBlock(x + 17, y + 3, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 12, 1, 0);
			par1World.setBlock(x + 17, y + 3, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 13, 1, 0);
			par1World.setBlock(x + 17, y + 3, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 14, 1, 0);
			par1World.setBlock(x + 17, y + 3, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 15, 1, 0);
			par1World.setBlock(x + 17, y + 3, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 16, 1, 0);
			par1World.setBlock(x + 17, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 17, y + 3, z + 17, 1, 0);
			par1World.setBlock(x + 16, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 16, y + 3, z + 17, 11, 0);
			par1World.setBlock(x + 15, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 15, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 14, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 14, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 13, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 13, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 3, z + 17, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 8, 0);
			par1World.setBlock(x + 12, y + 3, z + 16, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 3, z + 15, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 3, z + 14, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 3, z + 13, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 3, z + 12, Block.stairsStoneBrick.blockID);
			par1World.setBlockMetadataWithNotify(x + 12, y + 3, z + 17, 3, 0);
			par1World.setBlock(x + 12, y + 4, z + 12, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 13, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 14, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 15, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 16, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 11, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 12, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 13, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 14, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 15, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 16, Block.fenceIron.blockID);
			par1World.setBlock(x + 17, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 16, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 15, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 14, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 13, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 17, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 16, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 15, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 14, Block.fenceIron.blockID);
			par1World.setBlock(x + 12, y + 4, z + 13, Block.fenceIron.blockID);
			par1World.setBlock(x + 14, y + 1, z + 10, Block.chest.blockID);
			par1World.setBlock(x + 15, y + 1, z + 10, Block.chest.blockID);
			
			TileEntityChest tec = (TileEntityChest) par1World.getBlockTileEntity(x + 14, y + 1, z + 10);
			
			if (tec != null)
			{
				addLoot(tec, par2Random);
			}
			
			return true;
		}
	}
}