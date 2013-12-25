package ironlionchefs.modjam.blocks.essence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMedEssence extends Block
{
    public BlockMedEssence(int par1)
    {
        super(par1, Material.iron);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return blockID;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("ModJam:BlockMedEssence");
		this.setUnlocalizedName("Normal Essence Block");
    }
}