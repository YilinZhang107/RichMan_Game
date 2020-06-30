package ui.massage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

import ui.JPanelGame;

public class MassageOk extends Massage{
	
	/**
	 * 为了去感叹号自动生成的
	 */
	private static final long serialVersionUID = 7124891950603975799L;

	//创建一个默认的文本域
	private JTextArea textArea = null;
		
	private MassageButton ok;
	
	public MassageOk(String title, String information, JPanelGame panel) {
		// 继承后自动生成的构造函数
		super(title, panel);
		this.titleStr = title;
		
		//增加OK按钮
		addButton();
		
		//增加文本域
		addTextArea();
		
		this.textArea.setText(information);
	}
	
	//增加按钮
	public void addButton() {
		ok = new MassageButton("ok", this, 18*6, 131);
		add(ok);
	}
	
	/**
	 * 增加文本域
	 * 不知道干啥的
	 */
	public void addTextArea() {
		textArea = new JTextArea();
		textArea.setText("?????");//文本框中显示的字样,后来在构造函数更改了
		textArea.setBounds(18,39,230,50);//组件位置
		textArea.setSelectedTextColor(Color.BLUE);//选中部分文本颜色
		textArea.setOpaque(false);//为false时，组件是透明的
		textArea.setEditable(false);//设置是否可编辑
		textArea.setLineWrap(true);//是否自动换行
		add(textArea);
	}

	public void setInfo(String titleStr) {
		this.textArea.setText(titleStr);
		this.title.setText("<html><font color='white'>"+titleStr+"</font></html>");
	}
	
	@Override
	public void paint(Graphics g) {
		paints(g);
		
		ok.update(g);
		super.paint(g);
	}
	
	public void paints(Graphics g) {
		g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0, bg.getWidth(null), bg.getHeight(null), null);	
	}
}
