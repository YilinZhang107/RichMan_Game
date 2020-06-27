
package Model;

import java.awt.Color;
import java.awt.Graphics;

import ui.JPanelGame;
import ui.TextTip;
import control.Control;

/**
 * 
 * 文字提示更新
 * 
 * @author Ruining
 * 
 */
public class TextTipModel extends Tick implements Port{
	
	private PlayerModel player = null;
	
	private String tipString = "游戏开始！谁才是最后的大富翁呢？";
	
	public TextTipModel (){
	}

	public  String getTipString() {
		return tipString;
	}
	/**
	 * 
	 * 重新设置 tipString
	 */

	public void setTipString(String tipString) {
		this.tipString = tipString;
	}
	
	
	/**
	 * 
	 * 开始游戏设置
	 * 
	 */
	public void startGameInit (){}

	@Override
	public void updata(long tick) {
		this.nowTick = tick;
	}

	
	public PlayerModel getPlayer() {
		return player;
	}

	/**
	 * 显示文字提示
	 * 
	 * 
	 * */
	public void showTextTip(PlayerModel player,String str, int time) {
		this.player = player;
		this.setTipString(str);
		this.setStartTick(this.nowTick);   //从当前开始
		this.setNextTick(this.nowTick + time * Control.rate);//下一个tick
	}
}
