package model.card;

import context.GameState;
import model.PlayerModel;

/**
 * 
 * 换屋卡,停留在有房屋的土地上時，可以使用換屋卡，交換視野內房屋。
 * 
 * 
 */
public class ChangeCard extends Card {

	public ChangeCard(PlayerModel owner) {
		super(owner);
		this.name = "ChangeCard";
		this.cName = "换屋卡";
		this.price = 70;
	}

	@Override
	public int useCard() {
		return GameState.CARD_CHANGE;
	}
}