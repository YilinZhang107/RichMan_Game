package Model.cards;


import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;

/**
 * 
 * 
 * 停留卡,使对方在目标原地停留一回合。
 * 
 * 
 * 
 * 
 *
 */
public class StopCard extends Card{

	public StopCard(PlayerModel owner) {
		super(owner);
		this.name = "StopCard";
		this.cName ="停留卡";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_STOP;
	}
	/**
	 * 
	 *  卡片持续效果
	 * 
	 */
	@Override
	public int cardBuff(){
		return GameState.CARD_BUFF_STOP;
	}
}
