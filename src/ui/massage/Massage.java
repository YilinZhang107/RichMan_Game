package ui.massage;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.JPanelGame;

/**
 * 整个这个包都没用
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Massage extends JPanel{
	
	/**
	 * 去感叹号自动生成的
	 */
	private static final long serialVersionUID = -7027645709576295249L;

	/*
	 * 创建图片对象，给提示窗加上背景图片
	 * ImageIcon对象需要被转化为Image
	 */
	protected Image bg = new ImageIcon("images/massage/massage.png").getImage();
	
	//全局的位置变量，用于表示鼠标在窗口上的位置
	protected Point origin = new Point();
	
	//左上角x，y坐标， 面板宽度和高度
	protected int x, y, w, h;
	
	protected String titleStr = "面板标题";
	
	protected JLabel title = null;  //标题标签
	
	//JPanelGame为ui包中自定类
	protected JPanelGame panel = null;
	
	/**
	 * Massage类的构造函数 
	 *
	 * 创建一个信息对话框
	 */
	protected Massage(String title, JPanelGame panel) {
		this.titleStr = title;//传入对话框标题
		
		//初始化位置
		initBounds();
		
		/**
		 * 使用绝对布局(null)
		 * 使用绝对布局的窗口通常都是固定大小的
		 * 组件的位置和形状不会随窗体改变而发生变化
		 */
		setLayout(null);
		
		//增加标题
		addTitle();
		
		//增加监听器
		addListener();
		
		//设置背景透明
		setOpaque(false);
		this.panel = panel;
	}
	
	/**
	 * 初始化位置
	 */
	private void initBounds() {
		this.x = (950-bg.getWidth(null))/2;
		this.y = (650-bg.getHeight(null))/2;
		this.w = bg.getWidth(null);
		this.h = bg.getHeight(null);
		setBounds(x, y, w, h);
	}
	
	/**
	 * 增加标题
	 */
	private void addTitle() {
		title = new JLabel("<html><font color = 'white' >"+titleStr+"</font></html>");
		title.setBounds(18, 4, 230, 20);
		add(title);
	}
	
	/**
	 * 增加鼠标监听器
	 */
	private void addListener() {
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){ //按下鼠标
				origin.x = e.getX();  //鼠标按下时获得窗口当前的位置
				origin.y = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { //拖动鼠标
				x += e.getX() - origin.x;
				y += e.getY() - origin.y;
				if(x < 0) {
					x = 0;
				}
				if(x + w > 950) {
					x = 950 - w;
				}
				if(y < 0) {
					y = 0;
				}
				if(y + h > 650) {
					y = 650 - h;
				}
				setBounds(x, y, w, h);
			}
		});
	}
	
	//设置标题
	public void setTitleStr(String titleStr){
		this.titleStr = titleStr;
		this.title.setText("<html><font color='white' >"+titleStr+"</font></html>");
	}
		
	/**
	 * 将窗体隐藏	
	 * 
	 * JLayeredPane同一层内的组件可以通过以下两个方法调整在层内的位置
	 * 移动组件到其所在层的最底部位置
	 */
	public void moveToBack() {
		//ui包中自定类JPanelGame的gatLayeredPane()方法
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * 将窗体显现	
	 * 
	 * 同上
	 * 移动组件到其所在层的最顶部位置
	 */
	public void moveToFront() {
		//ui包中自定类JPanelGame的gatLayeredPane()方法
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	/**
	 * 按下OK按钮
	 */
	public void ok() {
		System.out.println("ok");  //输出到哪了？？？
	}
	
	/**
	 * 按下cancel按钮
	 */
	public void cancel() {
		System.out.println("cancel");
	}
}
