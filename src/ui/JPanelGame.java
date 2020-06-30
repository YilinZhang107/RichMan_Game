package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import control.Control;
import ui.massage.MassageOk;
import ui.massage.MassageSimple;
import ui.massage.MassageYesNo;

public class JPanelGame extends JPanel{
	
	private JFrameGame gameFrame = null;
	
	/**
	 * JLayeredPane：层级面板
	 * 为容器增加了深度，允许组件在需要时相互重叠
	 * 将组件放入容器时需要指定组件所在的层，以及组件所在该层内的位置
	 */
	private JLayeredPane layeredPane;
	
	private List<Layer> lays = null;
	private Background backgroundUI = null;
	private Lands landsUI = null;
	private Buildings buildingsUI = null;
	private Players playersUI = null;
	private TextTip textTip = null;
	private PlayersPanel layerPlayersPanel = null;
	private Dice dice = null;
	private Event event = null;
	private Shop shop = null;
	private Running running = null;
	private Effect effect = null;
	
	private PlayerInfo playerInfo = null;
	
	private MassageYesNo massageYesNo = null;
	private MassageOk massageOk = null;
	private MassageSimple massageSimple = null;
	
	private Control control = null;
	
	/*
	 * 全局左上角x
	 */
	public int posX = 100;
	
	/*
	 * 全局左上角Y
	 */
	public int posY = 100;
	
	public JPanelGame() {
		setLayout(new BorderLayout());
		//初始化游戏
		initGame();
	}
	
	/**
	 * 初始化游戏
	 */
	private void initGame() {
		//添加控制器
		control = new Control();
		//初始化ui
		initUI();
		//panel传入控制器
		control.setPanel(this);
	}
	
	/**
	 * 初始化UI
	 */
	private void initUI() {
		// 创建背景UI
		this.backgroundUI = new Background(0, 0, 950, 650,
				control.getBackground(),this);
		// 创建土地UI
		this.landsUI = new Lands(posX, posY, 950, 650, control.getLand());
		// 创建房屋UI
		this.buildingsUI = new Buildings(posX, posY, 950, 650,
				control.getBuilding());
		// 创建玩家显示UI
		this.playersUI = new Players(posX, posY, 950, 650,control.getRunning(), control.getPlayers());
		// 玩家信息面板UI
		this.layerPlayersPanel = new PlayersPanel(posX + 64, posY + 66, 170,
				250, control.getPlayers());
		// 文字显示面板UI
		this.textTip = new TextTip(0,0,950,650,control.getTextTip());
		// 骰子事件UI
		this.dice = new Dice(posX + 64, posY + 320, 170, 90, control);
		// 事件显示UI
		this.event = new Event(0, 0, 950, 650, control.getEvents());
		// 商店界面UI
		this.shop = new Shop(0, 0, 750, 650, control, this);
		// 游戏运转界面UI
		this.running = new Running(780, 0, 200, 80, control.getRunning(),this);
		// 场景效果UI
		this.effect = new Effect(0, 0, 950, 650, control.getEffect(),this);
		// 玩家信息面板显示
		this.playerInfo = new PlayerInfo(control.getPlayers(),this);
	
		// 对话UI
		this.massageYesNo = new MassageYesNo("选择框", "创建一个对话框", this);
		// 对话UI
		this.massageOk = new MassageOk("确定框", "创建一个对话框", this);
		// 对话UI
		this.massageSimple = new MassageSimple("多选框", "创建一个对话框", this);
		
		// lays存放所有panel组件
		lays = new ArrayList<Layer>();
		lays.add(backgroundUI);
		lays.add(dice);
		lays.add(playersUI);
		// lays.add(textTip);  //被注释是因为这三个继承的不是Layer是Panel
		lays.add(layerPlayersPanel);
		lays.add(buildingsUI);
		lays.add(landsUI);
		lays.add(backgroundUI);
		lays.add(running);
		lays.add(effect);
		// lays.add(shop);  //所以无法add
		// lays.add(massageYesNo);	
		
		layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		
		//添加组件
		int add = 1;
		// layeredPane.add(this.massageOk, add++);
		layeredPane.add(this.event, add++);
		layeredPane.add(this.effect, add++);
		layeredPane.add(this.textTip, add++);
		layeredPane.add(this.dice, add++);
		layeredPane.add(this.playersUI, add++);
		layeredPane.add(this.layerPlayersPanel, add++);
		layeredPane.add(this.buildingsUI, add++);
		layeredPane.add(this.landsUI, add++);
		layeredPane.add(this.running, add++);
		layeredPane.add(this.backgroundUI, add++);
		layeredPane.add(this.shop, add++);
		layeredPane.add(this.playerInfo,add++);
		
		add(layeredPane);
	}
	
	/*
	 * 初始化游戏配置
	 */
	public void startGamePanelInit() {
		for(Layer temp:this.lays) {
			//刷新窗口UI
			temp.startPanel();
		}
	}
	
	public MassageYesNo getMassageYesNo() {
		return massageYesNo;
	}
	
	public MassageOk getMassageOk() {
		return massageOk;
	}
	
	public MassageSimple getMassageSimple() {
		return massageSimple;
	}
	
	public Running getRunning() {
		return running;
	}

	public Dice getDice() {
		return dice;
	}

	public Shop getShop() {
		return this.shop;
	}
	
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	
	public Background getBackgroundUI() {
		return backgroundUI;
	}

	public Effect getEffect() {
		return effect;
	}

	public JFrameGame getGameFrame() {
		return gameFrame;
	}

	public PlayerInfo getPlayerInfo() {
		return playerInfo;
	}

	public void setGameFrame(JFrameGame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public Control getControl() {
		return control;
	}
	
	//去感叹号自动加的
	private static final long serialVersionUID = 1L;
}
