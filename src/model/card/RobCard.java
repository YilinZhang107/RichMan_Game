package model.card;


import javax.swing.JOptionPane;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * 
 * 抢夺卡,从对方选手处可以抢夺卡片，但只能根据运气，看不到对方卡片。
 * 
 * 
 */
public class RobCard extends Card {

	public RobCard(PlayerModel owner) {
		super(owner);
		this.name = "RobCard";
		this.cName = "抢夺卡";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_ROB;
	}

}
