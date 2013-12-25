package ironlionchefs.modjam.items.pendants.parts;

import ironlionchefs.modjam.items.pendants.general.PendantLevel;

public class ItemPendantPieceDiamond extends ItemPendantPiece
{
	public PendantLevel level;
	
	public ItemPendantPieceDiamond(int id)
	{
		super(id, PendantLevel.diamond);
	}
}