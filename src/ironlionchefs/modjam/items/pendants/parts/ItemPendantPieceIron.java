package ironlionchefs.modjam.items.pendants.parts;

import ironlionchefs.modjam.items.pendants.general.PendantLevel;

public class ItemPendantPieceIron extends ItemPendantPiece
{
	public PendantLevel level;
	
	public ItemPendantPieceIron(int id)
	{
		super(id, PendantLevel.iron);
	}
}