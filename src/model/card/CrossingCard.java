package model.card;


import context.GameState;
import model.PlayerModel;

/**
 * 
 * 
 *�޻���,����Σ��ʱ��Ч���޻����˴������
 * 
 *
 */
public class CrossingCard extends Card{

	public CrossingCard(PlayerModel owner) {
		super(owner);
		this.name = "CrossingCard";
		this.cName = "�޻���";
		this.price = 120;
	}

	@Override
	public int useCard() {
		return GameState.CARD_CROSSING;
	}

}
