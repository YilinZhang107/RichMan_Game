package ui;

import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
	
	
	
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	
	//去感叹号自动加的
	private static final long serialVersionUID = 1L;
}
