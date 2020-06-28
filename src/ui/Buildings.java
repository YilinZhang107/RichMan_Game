package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.BuildingsModel;
import model.buildings.Building;


/**
 * 房屋刷新层
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Buildings extends Layer{

	/**
	 * 加载房屋信息
	 */
	private BuildingsModel informationBuilding;
	
	/**
	 * 房屋链表
	 */
	private List<Building> building;
	
	/**
	 * house 图片1-5级别
	 * 玩家1的房子
	 */
	private Image HOUSE_01 = new ImageIcon("images/buliding/house01.png").getImage();
	
	/**
	 * house 图片1-5级别
	 * 玩家2的房子
	 */
	private Image HOUSE_02 = new ImageIcon("images/buliding/house02.png").getImage();
	
	/**
	 * 伪透明图片
	 */
	public Image TRANSPARENT = new ImageIcon("images/window/transparent.png").getImage();
	
	//构造函数
	protected Buildings(int x, int y, int w, int h, BuildingsModel infor) {
		super(x, y, w, h);
		this.informationBuilding = infor;
	}
	
	public void paint(Graphics g) {
		//绘制建筑物
		paintBuildings(g);
	}
	
	//绘制建筑物实现方法
	private void paintBuildings(Graphics g) {
		for(Building temp: this.building) {
			//房屋绘制 (注意这个方法名字没有s)
			paintBuilding(temp, g);
		}
	}
	
	/**
	 * 真正的绘制建筑物实现方法
	 */
	private void paintBuilding(Building building, Graphics g) {
		int x = 0;
		int y = 0;
		//getOwner 看名字就知道是获取房屋所有者
		if(building.getOwner() != null) {
			int level = building.getLevel(); //获取当前房屋等级
			int i = building.getPosX(); //获取房屋位置
			int j = building.getPosY();
			//若增加玩家数量，此处也需要改
			Image temp = building.getOwner().getNumber() == 1? this.HOUSE_01:HOUSE_02;
			//房子的图片也是60*60的
			if(level > 0) {
				//drawIamge的参数详见ui.layer类
				g.drawImage(temp, x+j*60, y+i*60-(temp.getHeight(null)-60),
						x+(j+1)*60, y+(i+1)*60, 60*(level-1), 0,
						60*level, temp.getHeight(null), null);
			}
			//覆盖透明白条
			g.drawImage(this.TRANSPARENT, x+j*60, y+i*60, x+(j+1)*60,
					y+(i+1)*60, 0, 0, 60, 60, null);
			
			// 房屋拥有者的名字显示
			g.drawString(""+building.getOwner().getName(), x+j*60+4, y+i*60+14);//为什么要加个14？
		}
	}

	@Override
	public void stratPanel() {
		this.building = this.informationBuilding.getBuilding();
	}
	
	//去感叹号自动添加的
	private static final long serialVersionUID = 1L;
}
