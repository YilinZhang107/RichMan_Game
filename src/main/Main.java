package main;

import javax.swing.UIManager;

import ui.JFrameGame;
import ui.WaitFrame;
import ui.config.FrameConfig;

public class Main {
	// 窗体外观显示设置样式，必须在窗体使用之前进行设置
	static {//确保先进行Look&Feel设置
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e1) {}//捕获异常
	}

	public static void main(String[] args) {
		// 调用ui包内欢迎界面创建创建起始欢迎界面
		WaitFrame wFrame = new WaitFrame();
		// 调用ui包中主界面类，建立游戏主窗口
		JFrameGame frame = new JFrameGame();
		// 实例化建立游戏配置窗口
		new FrameConfig(wFrame,frame);
	}
}
