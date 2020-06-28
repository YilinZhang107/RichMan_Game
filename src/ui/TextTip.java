package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.TextTipModel;

/**
 * 信息提示框
 * 成功购买房屋、因某事无法行动、获得点卷的提示框，短暂出现一段时间
 * 
 * @author 喝燕麦粥的1007
 * 
 */
public class TextTip extends Layer{

	//提示框模型
	private TextTipModel textTip = null;
	
	//载入提示框图片
	private Image bg = new ImageIcon("image/window/tip_01.png").getImage();
	
	/**
	 * Point:点类
	 * 成员变量有:x,y
	 */
	private Point pointWindow = null;
	
	protected TextTip(int x, int y, int w, int h, TextTipModel textTip) {
		super(x, y, w, h);
		
		//用来确定位置的
		this.pointWindow = new Point((x + w) /2, (y + h) / 2);
		this.textTip = textTip;
	}

	@Override
	public void paint(Graphics g) {
		//绘制信息面板
		paintTextTip(g, this);
		
	}
	
	/**
	 * 绘制信息面板
	 */
	private void paintTextTip(Graphics g, TextTip textTip2) {
		/**
		 * 以下用到的tick值定义在model包Tick类中
		 */
		if(textTip.getStartTick() < textTip.getNowTick()
			&& textTip.getNextTick() >= textTip.getNowTick()) {
			
			//根据当前角色所在位置来定义窗口位置
			this.pointWindow.x = textTip.getPlayer().getX() + 45;
			this.pointWindow.y = textTip.getPlayer().getY() + 10;
			
			g.drawImage(bg, pointWindow.x, pointWindow.y, pointWindow.x + bg.getWidth(null),
					pointWindow.y + bg.getHeight(null), 0, 0, bg.getWidth(null),
					bg.getHeight(null), null);
			
			//绘制文字，实现在下面
			drawString(g);
		}
	}
	
	/**
	 * 绘制文字方法
	 */
	private void drawString(Graphics g) {
		String str = this.textTip.getTipString();
		int maxSize = 13; //此图片中每行最多容纳13个字符
		int posY = 32;
		int front = 0;
		int rear = maxSize;
		while (front < str.length() -1) {
			if(rear >= str.length()) {
				rear = str.length() -1;
			}
			char[] temp = new char[maxSize];
			
			/** 
			 * getChars() 方法将字符从字符串复制到目标字符数组。
			 * getChars(int srcBegin, int srcEnd, char[] dst,  int dstBegin)
			 * srcBegin —— 字符串中要复制的第一个字符的索引。
			 * srcEnd —— 字符串中要复制的最后一个字符之后的索引。
			 * dst —— 目标数组。
			 * dstBegin —— 目标数组中的起始偏移量。
			 */
			str.getChars(front, rear, temp, 0);//接收要输出的字符
			//char[] 转换成String
			String s = new String(temp);
			g.drawString(s, pointWindow.x + 20, pointWindow.y + posY);
			front = rear;
			rear += maxSize;
			posY += 20;//控制每行输出的间距
		}
	}

	@Override
	public void stratPanel() {
		// TODO 自动生成的方法存根
	}
	
	//去感叹号自动添加的
	private static final long serialVersionUID = 1L;
}
	

