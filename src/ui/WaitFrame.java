package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import util.FrameUtil;

/**
 * 开始选人前的等待界面
 * @author 喝燕麦粥的107
 *
 */
public class WaitFrame extends JFrame{

	public WaitFrame() {
		//设置名字
		this.setTitle("RichMan_Game——by：Java");
		
		//设置默认顶部栏属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * 设置窗口大小
		 * 和选人界面一样大
		 */
		this.setSize(380, 370);
		
		//不允许用户改变窗口大小
		this.setResizable(false);
		
		/**
		 * 居中
		 * UTIL包中的自定义类方法
		 */
		FrameUtil.setFrameCenter(this);
		
		add(new JLabel("加载中，请稍后...", JLabel.CENTER));
		
		//使之显现
		setVisible(true);
	}
	
	//为了去感叹号自动加的
	private static final long serialVersionUID = 1L;
}
