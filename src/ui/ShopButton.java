package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import control.Control;

/**
 * 商店的各种按钮
 * 确认，购买， 取消
 * 
 * @author 喝燕麦粥的107
 *
 */
public class ShopButton extends JPanel implements MouseListener{

	private Shop shopUI;
	
	private Image[] img;
	
	//鼠标不同状态下的图片
	private Image normalImage;
	private Image rolloverImage;
	private Image pressedImage;
	private Image disabledImage;
	
	private Image currentImage;
	
	private boolean enabled = true;
	
	private String name = null;

	private Control control;
	
	public ShopButton(Shop shopUI, String name, int x, int y, Control control) {
		this.shopUI = shopUI;
		this.name = name;
		this.control = control;
		this.img = this.shopUI.createCardImg(name);
		this.normalImage = this.img[0];
		this.rolloverImage = this.img[1];
		this.pressedImage = this.img[2];
		this.disabledImage = this.img[3];
		this.currentImage = normalImage;
		this.setBounds(x, y, this.img[0].getWidth(null),this.img[0].getHeight(null));
		this.addMouseListener(this);
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void paint(Graphics g) {
		this.setOpaque(false);//背景透明
		if(enabled) {
			g.drawImage(currentImage, this.getX(), this.getY(), this.getWidth(),
					this.getHeight(), this);
		}
		else if(!(name.equals("buy") || name.equals("cancel"))) {
			g.drawImage(disabledImage, this.getX(), this.getY(), this.getWidth(),
					this.getHeight(), this);
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
			if(this.name.contentEquals("close")) {
				//退出商店
				this.shopUI.moveToBack();
				this.control.exitShop();
			} else if(this.name.equals("cancel")) {
				//取消当前选择
				this.shopUI.setChooseCard(null);
			} else if (this.name.equals("buy")) {
				this.control.buyCard(this.shopUI.getShop());
			} else {
				this.shopUI.setChooseCard(this);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		currentImage = rolloverImage;
	}
	
	//去感叹号自动添加
	private static final long serialVersionUID = 1L;
}
