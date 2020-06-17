package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import control.GameRunning;
import model.PlayerModel;

/**
 * 玩家位置数据更新层
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Players extends Layer{
	
	private GameRunning run = null;
	
	//玩家链表
	private List<PlayerModel> players = null;
	
	//两个构造方法
	protected Players(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	protected Players(int x, int y, int w, int h, GameRunning run, List<PlayerModel> players) {
		super(x, y, w, h);
		this.run = run;
		this.players = players;
	}
	
	/**
	 * 绘制玩家在地图中的情况
	 * 此处若多玩家也许可以直接添加
	 */
	public void paint(Graphics g) {
		//使用循环一个一个绘制
		for(PlayerModel temp : players) {
			paintPlayer(temp, g);
		}
	}
	
	/**
	 * 绘制单个玩家方法
	 */
	private void paintPlayer(PlayerModel player, Graphics g) {
		//判断是否为当前玩家
		boolean show = true;
		
		//调用PlayerModel类中的方法调用图片
		Image temp = player.getIMG("mini");
		
		//如果此时轮到该名玩家，使用身上出现蓝光的图片(mini_on)
		if(player.equals(this.run.getNowPlayer())) {
			temp = player.getIMG("mini_on");
		}
		else { 
			//此处的判断在多玩家时可能需要更改，不能简单的getOtherPlayer
			if(this.x == player.getOtherPlayer().getX()
					&& this.y == player.getOtherPlayer().getY()) {
				//重合不显示
				show = false;
			}
		}
		if (show) {
			g.drawImage(temp, player.getX()+28, player.getY()+28, player.getX()+60,
					player.getY()+60, 0, 0, 32, 32, null);
		}
	}

	@Override
	public void stratPanel() {
		// TODO 自动生成的方法存根
	}
	
	//去感叹号自动生成的
	private static final long serialVersionUID = 1L;
}
