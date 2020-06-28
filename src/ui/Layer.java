package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 绘制层类 ： 背景刷新类，土地、房屋、玩家刷新类，信息提示框  的抽象类
 * 
 * 继承Panel容器类
 * 
 * @author 喝燕麦粥的107
 */

public abstract class Layer extends JPanel{

	/**
	 * 窗口左上角x坐标
	 */
	protected int x;
	
	/**
	 * 窗口左上角y坐标
	 */
	protected int y;
	
	/**
	 * 窗口宽度
	 */
	protected int width;
	
	/**
	 * 窗口高度
	 */
	protected int height;
	
	protected static final int PADDING = 5;  //？？？
	protected static final int SIZE = 2;//控制间距的？
	protected static Image WINDOW_IMG = new ImageIcon("images/window/window.png").getImage();
	protected static int WINDOW_W = WINDOW_IMG.getWidth(null);
	protected static int WINDOW_H = WINDOW_IMG.getHeight(null);
	
	/**
	 * Layer类构造函数 传入x，y坐标和窗口宽度长度
	 * @param x 左上角x坐标
	 * @param y	左上角y坐标 
	 * @param width 窗口宽度
	 * @param height 窗口长度
	 */
	protected Layer(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//获取左上角x坐标
	public int getX() {
		return x;
	}
	
	//获取左上角y坐标
	public int getY() {
		return y;
	}
	
	//获取窗口宽度
	public int getW() {
		return width;
	}
	
	//获取窗口高度
	public int getH() {
		return height;
	}
	
	/**
	 * 边框绘制
	 * drawImage:
	 * IMG - 要绘制的指定图像。如果 IMG 为 null，则此方法不执行任何操作。
	 * dx1 - 目标矩形第一个角的 x 坐标。
	 * dy1 - 目标矩形第一个角的 y 坐标。
	 * dx2 - 目标矩形第二个角的 x 坐标。
	 * dy2 - 目标矩形第二个角的 y 坐标。
	 * sx1 - 源矩形第一个角的 x 坐标。
	 * sy1 - 源矩形第一个角的 y 坐标。
	 * sx2 - 源矩形第二个角的 x 坐标。
	 * sy2 - 源矩形第二个角的 y 坐标。
	 * observer - 当缩放并转换了更多图像时要通知的对象。
	 * 返回：
	 * 如果图像像素仍在改变，则返回 false；否则返回 true。
	 */
	public void createWindow(Graphics g) {
		g.drawImage(WINDOW_IMG, 0, 0, 0 + SIZE, 0 + SIZE,
				0, 0, SIZE, SIZE, null);//左上固定
		
		g.drawImage(WINDOW_IMG, 0 + SIZE, 0, 0 + width - SIZE, 0 + SIZE,
				SIZE, 0, WINDOW_W - SIZE, SIZE, null);//中间
		
		g.drawImage(WINDOW_IMG, 0 + width - SIZE, 0, 0 + width, 0 + SIZE,
				WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);// 右上固定
		
		g.drawImage(WINDOW_IMG, 0, 0+SIZE, 0+SIZE, 0+height-SIZE,
				0, SIZE, SIZE, WINDOW_H-SIZE, null);// 中右
		
		g.drawImage(WINDOW_IMG, 0+SIZE, 0+SIZE, 0+width-SIZE, 0+height-SIZE,
				SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);// 中中
		
		g.drawImage(WINDOW_IMG, 0+width-SIZE, 0+SIZE, 0+width, 0+height-SIZE,
				WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);// 中右
		
		g.drawImage(WINDOW_IMG, 0, 0+height-SIZE, 0+SIZE, 0+height,
				0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);// 下左
		
		g.drawImage(WINDOW_IMG, 0+SIZE, 0+height-SIZE, 0+width-SIZE, 0+height,
				SIZE, 50-SIZE, WINDOW_W-SIZE, WINDOW_H, null);// 下中
		
		g.drawImage(WINDOW_IMG, 0+width-SIZE, 0+height-SIZE, 0+width, 0+height,
				WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W, WINDOW_H, null);// 下右
	}
	
	/**
	 * 定义的抽象方法
	 * 绘制图片
	 */
	abstract public void paint(Graphics g);
	
	/**
	 * 开始游戏panel设置
	 */
	abstract public void stratPanel();
	
	//为了去感叹号自动加的
	private static final long serialVersionUID = 1L;
}
