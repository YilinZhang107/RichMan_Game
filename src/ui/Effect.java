package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


import model.EffectModel;

/**
 * 各种结果提示信息的动画效果
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Effect extends Layer{
	
	private EffectModel effect = null;
	
	/**
	 * panel中点
	 */
	private Point middle = new Point((x+width)/2,(y+height)/2);
	private JPanelGame panel;
	
	protected Effect(int x, int y, int width, int height, EffectModel effect, JPanelGame panel) {
		super(x, y, width, height);
		this.effect = effect;
		this.panel = panel;
	}
	
	/**
	 * 将窗体隐藏
	 */
	public void moveToBack() {
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * 将窗体显现
	 */
	public void moveToFront() {
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	@Override
	public void paint(Graphics g) {
		if(effect.getStartTick()<effect.getNowTick()
				&& effect.getNextTick() >= effect.getNowTick()) {
			int pos = (int) ((effect.getNowTick()- effect.getStartTick())
					/ effect.getImageShowGap());
			if(pos<effect.getImg().length) {
				Image tempIMG = effect.getImg()[pos];
				//图片中点
				Point imgGiddle = new Point(tempIMG.getWidth(null)/2, 
						tempIMG.getHeight(null)/2);
				Point position = new Point(middle.x - imgGiddle.x, 
						middle.y - imgGiddle.y);
				
				//居中显示图片
				g.drawImage(tempIMG, position.x, position.y, 
						position.x+tempIMG.getWidth(null),
						position.y+tempIMG.getHeight(null),0,0,
						tempIMG.getWidth(null),tempIMG.getHeight(null),null);
			}
		}
	}

	@Override
	public void startPanel() {
		// TODO 自动生成的方法存根
	}
	
	private static final long serialVersionUID = 1L;
}
