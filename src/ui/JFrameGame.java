package ui;

import javax.swing.JFrame;

import util.FrameUtil;

public class JFrameGame extends JFrame{
	
	/**
	 * 游戏进行过程中的界面
	 * 默认主panel(面板)
	 */
	private JPanelGame panelGame = null;
	
	public JFrameGame() {
		/**
		 * 设置名字
		 * 是游戏运行过程中窗口上的名字 
		 */
		this.setTitle("RichMan_Game——by：Java");
		
		//设置默认窗口的功能（最小化，全屏，关闭）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * 设置窗口大小
		 * 此大小为游戏运行时的大小,根据背景大小来调整
		 */
		this.setSize(750+200, 650);
		
		//不允许用户改变窗口大小
		this.setResizable(false);
		
		/**
		 * 居中
		 * 自定义的util包中FrameUtil类的方法
		 */
		FrameUtil.setFrameCenter(this);
		
		//设置默认Panel
		this.panelGame = new JPanelGame();
		add(this.panelGame);
		
		/**
		 * 设置边框显示
		 * 为true时类似全屏状态，没有顶部的边框和EXIT_ON_CLOSE按键
		 */
		this.setUndecorated(false);		
	}
	
	public JPanelGame getPanelGame() {
		return panelGame;
	}
}
