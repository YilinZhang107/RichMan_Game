package ui;

import java.awt.Graphics;
import java.awt.Image;

import model.BackgroundModel;

/**
 * 背景更新层
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Background extends Layer{
	
	/**
	 * 背景图片
	 */
	private Image bg = null;
	
	/**
	 * 背景模型
	 * BackgroundModel自定义类位于model包中
	 */
	private BackgroundModel background = null;
	
	//为什么JPaneGame中会构建Background，BackGround中又能先构建JPaneGame？
	private JPanelGame panel;
	
	protected Background(int x, int y, int w, int h, BackgroundModel background, JPanelGame panel) {
		super(x, y, w, h);
		
		this.background = background;
		this.panel = panel;
	}
	
	//绘制背景
	public void paint(Graphics g) {
		this.paintBg(g);
	}
	
	/**
	 * 背景绘制方法
	 */
	public void paintBg(Graphics g) {
		g.drawImage(this.bg, 0, 0, this.bg.getWidth(null),
				this.bg.getHeight(null), 0, 0, this.bg.getWidth(null),
			    this.bg.getHeight(null), null);
	}

	@Override
	public void stratPanel() {
		//自动生成的必须实现的方法
		//getBg是model包BackgroundModel类的方法
		this.bg = background.getBg();
	}
	
	/**
	 * 将窗体隐藏
	 * 
	 * JLayeredPane同一层内的组件可以通过以下两个方法调整在层内的位置
	 * 移动组件到其所在层的最底部位置
	 */
	public void moveToBack() {
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * 将窗体显现
	 * 
	 * 同上
	 * 移动组件到其所在层的最顶部位置
	 */
	public void moveToFront() {
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	// 为了去感叹号自动添加的
	private static final long serialVersionUID = 1L;
}
