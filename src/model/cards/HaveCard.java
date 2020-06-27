package Model.cards;

import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;
import Model.buildings.Building;

/**
 * 
 * 购地卡,当此地目前不属于自己时，购地连同建筑强行收购。
 * 
 * 
 */
public class HaveCard extends Card {

	public HaveCard(PlayerModel owner) {
		super(owner);
		this.name = "HaveCard";
		this.cName = "购地卡";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_HAVE;
	}

}
