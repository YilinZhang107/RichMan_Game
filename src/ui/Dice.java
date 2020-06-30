package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import control.Control;
import model.DiceModel;

/**
 * 
 * 骰子掷点层
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Dice extends Layer{
	
	private DiceModel dice;
	private DiceButton diceButton;
	
	
	protected Dice(int x, int y, int width, int height, Control control) {
		super(x, y, width, height);
		setLayout(null);
		this.dice = control.getDice();
		this.diceButton = new DiceButton(control, 105, 32);
		add(diceButton);
	}

	@Override
	public void paint(Graphics g) {
		//窗口绘制
		this.createWindow(g);
		//骰子绘制
		this.paintDice(g, -12, -15);
		//骰子按钮显示
		this.showDice();
		//骰子按钮刷新
		diceButton.update(g);
	}
	
	/**
	 * 骰子绘制
	 */
	private void paintDice(Graphics g, int i, int j) {
		//设置骰子运动
		if(dice.getStartTick() < dice.getNowTick()
				&& dice.getNextTick() >= dice.getNowTick()) {
			//设置为滚动状态
			dice.setDiceState(DiceModel.DICE_RUNNING);
		}
		else {
			//设置为产生点数状态
			dice.setDiceState(DiceModel.DICE_POINT);
		}
		
		if(dice.getDiceState() == DiceModel.DICE_POINT) {
			this.paintPoint(g, i, j);
		}
		else if(dice.getDiceState() == DiceModel.DICE_RUNNING) {
			this.paintRunning(g, i, j, dice.getNowTick() % 4== 0);
		}
		
		g.setColor(Color.black);
		g.drawString(dice.getRunning().getNowPlayer().getName() + ":", i+120, j+45);
	}
	
	/*
	 * 骰子运动状态绘制
	 */
	public void paintRunning(Graphics g, int x, int y, boolean change) {
		if(change) {
			//图片滚动次数记载（用于图片的滚动显示）
			dice.addImgCount(1);
		}
		Image temp = dice.getNowImg();
		g.drawImage(temp, x, y, x+temp.getWidth(null),
				y+temp.getHeight(null), 0, 0, temp.getWidth(null),
				temp.getHeight(null), null);
	}
	
	/**
	 * 骰子产生点数绘制
	 */
	public void paintPoint(Graphics g, int x, int y) {
		Image temp = dice.getDicePoints()[dice.getPoint()];
		g.drawImage(temp, x, y, x+temp.getWidth(null),
				y+temp.getHeight(null), 0, 0, temp.getWidth(null),
				temp.getHeight(null), null);
	}
	
	/**
	 * 骰子按钮显示
	 */
	private void showDice() {
		diceButton.setEnabled(dice.isShowDiceLabel());
	}

	/**
	 * 应该用不到
	 */
	public DiceButton getDiceButton() {
		return diceButton;
	}
	
	@Override
	public void startPanel() {
		// TODO 自动生成的方法存根	
	}
	
	//去感叹号自动生成的
	private static final long serialVersionUID = 1L;
}
