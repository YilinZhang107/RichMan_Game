package Model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.buildings.Building;
import model.card.Card;
import control.Control;
import control.GameRunning;

/**
 * 玩家信息
 * 
 * @author Ruining
 * 
 */
public class PlayerModel extends Tick implements Port {

	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 使用人物
	 */
	private int part=0;
	/**
	 * 现金
	 */
	private int cash;
	/**
	 * 当前坐标x 人物右下角
	 */
	private int x;
	/**
	 * 当前坐标y 人物右下角
	 */
	private int y;
	/**
	 * 剩余住院天数
	 */
	private int inHospital;
	/**
	 * 剩余监狱天数
	 */
	 private int inPrison;

		/**
		 * 
		 * 玩家编号,显示房屋图片使用
		 * 
		 */
		private int number = 0;

		/**
		 * 
		 * 玩家拥有房屋链表
		 * 
		 */
		private List<Building> buildings = new ArrayList<Building>();

		/**
		 * 
		 * 拥有卡片
		 * 
		 */
		private List<Card> cards = new ArrayList<Card>();

		/**
		 * 
		 * 最大可持有卡片
		 * 
		 */
		public static int MAX_CAN_HOLD_CARDS = 8;

		/**
		 * 
		 * 附加身上的EFFECT 卡片
		 * 
		 */
		private List<Card> effectCards = new ArrayList<Card>();

		private Image[] playerIMG = new Image[100];

		/**
		 * 
		 * 对方玩家
		 * 
		 */
		private PlayerModel otherPlayer = null;
		/**
		 * 
		 * 游戏控制器
		 * 
		 */
		private Control control = null;

		public PlayerModel(int number, Control control) {
			this.name = "";
			this.number = number;
			this.control = control;
		}

		public List<Card> getCards() {
			return cards;
		}

		public void setCards(List<Card> cards) {
			this.cards = cards;
		}

		public List<Card> getEffectCards() {
			return effectCards;
		}

		public List<Building> getBuildings() {
			return buildings;
		}

		public int getInPrison() {
			return inPrison;
		}

		public void setInPrison(int inPrison) {
			this.inPrison = inPrison;
		}

		public PlayerModel getOtherPlayer() {
			return otherPlayer;
		}

		public void setOtherPlayer(PlayerModel otherPlayer) {
			this.otherPlayer = otherPlayer;
		}

		public int getNumber() {
			return number;
		}

		public int getInHospital() {
			return inHospital;
		}

		public void setInHospital(int inHospital) {
			this.inHospital = inHospital;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPart() {
			return part;
		}

		public void setPart(int part) {
			this.part = part;
		}

		public int getCash() {
			return cash;
		}

		public void setCash(int cash) {
			this.cash = cash;
		}
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void debug() {
			System.out.println("玩家:" + name + ",坐标：[" + x + "," + y + "].");
		}
        /**
         * 初始化玩家图像
         */
		  private void initPlayerIMG()
		  {
			  
		  }
		  /**
		   * 获取玩家图像
		   */
		  public Image getIMG(String str)
		  {
			  
		  }
		/**
		 * 
		 * 开始游戏设置
		 * 
		 */
		public void startGameInit() {
			// 初始化玩家图像
			this.initPlayerIMG();
			// 设置单位方格（60px）的运动时间
			this.lastTime = Control.rate / 3;
			// 初始化玩家金钱
			this.cash = GameRunning.PLAYER_CASH;
		}

		@Override
		public void updata(long tick) {
			this.nowTick = tick;
			// 移动玩家
			if (this.startTick < this.nowTick && this.nextTick >= this.nowTick) {
				this.control.movePlayer();
				// 路过建筑
				if (this.nextTick != this.nowTick) {
					this.control.prassBuilding();
				}
				// 玩家移动完毕，停下操作
				if (this.nextTick == this.nowTick) {
					this.control.playerStopJudge();
				}
			}
	 
}
