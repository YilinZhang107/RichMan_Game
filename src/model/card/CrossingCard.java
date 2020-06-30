package model.card;


import context.GameState;
import model.PlayerModel;

/**
 * 
 * 
 *嫁祸卡,遇到危险时生效，嫁祸他人大量租金
 * 
 *
 */
public class CrossingCard extends Card{

	public CrossingCard(PlayerModel owner) {
		super(owner);
		this.name = "CrossingCard";
		this.cName = "嫁祸卡";
		this.price = 120;
	}

	@Override
	public int useCard() {
		return GameState.CARD_CROSSING;
	}

}
