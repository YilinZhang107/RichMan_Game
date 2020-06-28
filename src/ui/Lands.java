package ui;

import java.awt.Graphics;
import java.awt.Image;

import model.LandModel;

/**
 * 土地刷新层
 * 在空白地图上画出各个建筑的图片
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Lands extends Layer{

	/**
	 * 土地模型
	 * Model包内的LandModel自定义类
	 */
	private LandModel land = null;
	
	/**
	 * 土地图片
	 */
	private Image landsIMG = null;

	/**
	 * 构造函数
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param land
	 */
	protected Lands(int x, int y, int w, int h, LandModel land) {
		super(x, y, w, h);
		this.land = land;
		this.landsIMG = this.land.getLandsIMG();
	}
	
	/**
	 * 必须实现的继承方法
	 * 土地绘制
	 */
	@Override
	public void paint(Graphics g) {
		this.paintLands(g);
		
	}
	
	/**
	 * 所有图标都被集中在一个660*60的长方形图片中，单个地点图片为60*60
	 * 载入的图片在LandModel中修改
	 * 
	 */
	private void paintLands(Graphics g) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < land.getLand().length; i++) {
			for(int j = 0; j < land.getLand()[i].length; j++) {
				if(land.getLand()[i][j] != 0) {
					//图片部分显示
					g.drawImage(landsIMG, x + j*60, y + i*60, x +(j+1)*60,
							y +(i+1)*60, (land.getLand()[i][j]-1)*60, 0 ,
							land.getLand()[i][j]*60, 60, null);
				}
			}
		}
	}
		
	@Override
	public void stratPanel() {
		// TODO 自动生成的方法存根	
	}
	
	//去感叹号自动加的
	private static final long serialVersionUID = 1L;	
}
