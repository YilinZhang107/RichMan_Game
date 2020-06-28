package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import control.Control;
import model.DiceModel;

/**
 * 骰子按钮，监听鼠标活动
 *
 * @author 喝燕麦粥的107
 *
 */
public class DiceButton extends JPanel implements MouseListener{

	private Control control;
	private DiceModel dice;
	
	private Image normalImage;
	private Image rolloverImage;
	private Image pressedImage;
	
	private Image currentImage;
	
	private boolean enabled = true;
	
	public DiceButton(Control control, int x, int y) {
		this.control = control;
		this.dice = control.getDice();
		this.normalImage = dice.getDiceIMG()[0].getImage();
		this.rolloverImage = dice.getDiceIMG()[1].getImage();
		this.pressedImage = dice.getDiceIMG()[2].getImage();
	
		this.currentImage = normalImage;
		this.setBounds(x, y, 50, 50);
		this.addMouseListener(this);
		/*
		 * 真正的重绘，在图形线程后追加一段重绘操作，是安全的
		 */
		repaint();
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void paint(Graphics g) {
		this.setOpaque(false); //背景透明
		if(enabled) {
			g.drawImage(currentImage, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		currentImage = rolloverImage;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		currentImage = normalImage;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		currentImage = pressedImage;
		if(enabled) {
			//按下
			control.pressButton();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		currentImage = rolloverImage;
	}
	
	private static final long serialVersionUID = 1L;
}
