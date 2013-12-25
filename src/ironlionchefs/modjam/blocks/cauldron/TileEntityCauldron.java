package ironlionchefs.modjam.blocks.cauldron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.MinecraftException;

public class TileEntityCauldron extends TileEntity
{	
	public void update(int x, int y, int z, int color, int height, int[] potions)
	{
		this.storeNBTIntegers(x,y,z,"color", color, "height", height, "potions", potions);
	}
	
	public void stripNBTData(int x, int y, int z)
	{
		storeNBTIntegers(x,y,z,"color", 0xFFF, "height", 0, "potions", new int[0]);
	}
	
	public void storeNBTIntegers(int x, int y, int z, String key, int i, String k2, int j, String k3, int[] potions)
	{
		try
		{
			File file = new File(ModLoader.getMinecraftInstance().mcDataDir + "/saves/brewingdata/", "cauldron." + x + "." + y + "." + z + ".data.dat");
			
			if (!file.exists())
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			
			FileOutputStream fileoutputstream = new FileOutputStream(file.getCanonicalFile());
			NBTTagCompound nbt = new NBTTagCompound();
			
			nbt.setInteger(key, i); 
			nbt.setInteger(k2, j);
			nbt.setIntArray(k3, potions);
			
			CompressedStreamTools.writeCompressed(nbt, fileoutputstream);
			fileoutputstream.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	

	public List<Integer> readNBTDataArray(int x, int y, int z, String key)
	{
		try
		{
			ModLoader.getMinecraftInstance().theWorld.checkSessionLock();
		}
		catch (MinecraftException e)
		{
			e.printStackTrace();
		}
		try
		{
			File file = new File(ModLoader.getMinecraftInstance().mcDataDir + "/saves/brewingdata/", "cauldron." + x + "." + y + "." + z + ".data.dat");

			if (!file.exists())
			{
				return new ArrayList<Integer>();
			}
			
			FileInputStream fileinputstream = new FileInputStream(file.getCanonicalFile());
			NBTTagCompound nbt = CompressedStreamTools.readCompressed(fileinputstream);
			
			if (nbt.hasKey(key))
			{
				List<Integer> l = new ArrayList<Integer>();
				for (int i : nbt.getIntArray(key))
				{
					l.add(i);
				}
				return l;
			}
			
			fileinputstream.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return new ArrayList<Integer>();
	}
	
	public int readNBTData(int x, int y, int z, String key)
	{
		try
		{
			ModLoader.getMinecraftInstance().theWorld.checkSessionLock();
		}
		catch (MinecraftException e)
		{
			e.printStackTrace();
		}
		try
		{
			File file = new File(ModLoader.getMinecraftInstance().mcDataDir + "/saves/brewingdata/", "cauldron." + x + "." + y + "." + z + ".data.dat");

			if (!file.exists())
			{
				return 0;
			}
			
			FileInputStream fileinputstream = new FileInputStream(file.getCanonicalFile());
			NBTTagCompound nbt = CompressedStreamTools.readCompressed(fileinputstream);
			
			if (nbt.hasKey(key))
			{
				return nbt.getInteger(key);
			}
			
			fileinputstream.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return 0;
	}
}