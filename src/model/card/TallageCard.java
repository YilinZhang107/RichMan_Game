package model.card;


import javax.swing.JOptionPane;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * 查税卡,收取对手中的10%税款
 *
 */
public class TallageCard extends Card{

	public TallageCard(PlayerModel owner) {
		super(owner);
		this.name = "TallageCard";
		this.cName = "查税卡";
		this.price = 100;
	}

	@Override
	public int useCard() {
		return GameState.CARD_TALLAGE;
	}

}
