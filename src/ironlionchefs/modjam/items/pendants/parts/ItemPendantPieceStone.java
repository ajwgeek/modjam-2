package ironlionchefs.modjam.items.pendants.parts;

import ironlionchefs.modjam.items.pendants.general.PendantLevel;

public class ItemPendantPieceStone extends ItemPendantPiece
{
	public PendantLevel level;
	
	public ItemPendantPieceStone(int id)
	{
		super(id, PendantLevel.stone);
	}
}