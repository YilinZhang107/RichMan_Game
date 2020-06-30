package ui.massage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MassageButton extends JPanel implements MouseListener{
	
	/**
	 * 去感叹号自动生成的
	 */
	private static final long serialVersionUID = 9118697608635979542L;

	private Image[] img;  //接收返回的按钮4个状态的图片
	
	private Image normalImage;  //正常状态
	private Image rolloverImage;  //离开
	private Image pressedImage;  //按下
	
	private Image currentImage;  //当前
	
	private boolean enabled = true;  //???
	
	private String name = null;  //接收OK或cancel
	
	private Massage massage = null;
	
	/**
	 * MassageButton类构造方法
	 */
	public MassageButton(String name, Massage massage, int x, int y) {
		this.name = name;  //名称
		this.massage = massage;
		this.img = this.getImg(name);
		this.normalImage = this.img[0];
		this.rolloverImage = this.img[1];
		this.pressedImage = this.img[2];
		this.currentImage = normalImage;
		this.setBounds(x, y, this.img[0].getWidth(null), this.img[0].getHeight(null));
		this.addMouseListener(this);
	}
	
	/**
	 * (之所以先用Icon再getImage可能是image类一般尺寸过大，不适合做图标)
	 * @param name(OK或cancel)
	 * @return 返回OK或cancel的按钮的4个状态的图片
	 */
	private Image[] getImg(String name) {
		return new Image[] {
			new ImageIcon("images/massage/"+name+"/normal.png").getImage(),
			new ImageIcon("images/massage/"+name+"/mouseOver.png").getImage(),
			new ImageIcon("images/massage/"+name+"/pressed.png").getImage(),
			new ImageIcon("images/massage/"+name+"/disabled.png").getImage()
		};
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Graphics绘图类
	 */
	public void paint(Graphics g) {
		this.setOpaque(false);  //背景透明
		if(enabled) {
			//绘制指定图像中已缩放到适合指定矩形内部的图像。
			g.drawImage(currentImage, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		}
	}
	
	/**
	 * 类型 MassageButton 必须实现继承的抽象方法 MouseListener.mouseExited（MouseEvent）
	 * 以下均为继承后必须实现的方法 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		//发生单击事件时触发
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//鼠标按下时触发
		currentImage = pressedImage;
		if(enabled) {
			if(name.equals("ok")) {
				massage.ok();
			}
			else if(name.equals("cancel")) {
				massage.cancel();
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//鼠标按键被释放时触发
		currentImage = rolloverImage;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//鼠标移入组件
		currentImage = rolloverImage;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//鼠标移出组件
		currentImage = normalImage;
	}
}
