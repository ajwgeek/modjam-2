package ironlionchefs.modjam.world.provider.magic;

import net.minecraft.util.ChunkCoordinates;

public class MagicPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final MagicWorldTeleporter field_85088_e;

	public MagicPortalPosition(MagicWorldTeleporter magicWorldTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = magicWorldTeleporter;
		this.field_85087_d = par5;
	}
}