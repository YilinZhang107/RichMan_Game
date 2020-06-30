package ui.massage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

import ui.JPanelGame;

public class MassageSimple extends Massage{
	
	/**
	 * 为了去掉感叹号自动生成的
	 */
	private static final long serialVersionUID = 5840436673092932020L;

	private JTextArea textArea = null;
	
	//新建按钮cancel
	private MassageButton cancel;
	
	public MassageSimple(String title, String information, JPanelGame panel) {
		super(title, panel);
		this.titleStr = title;
		
		//增加按钮
		addButtons();
		
		//增加文本域
		addTextArea();
	}
	
	private void addButtons() {
		cancel = new MassageButton("cancel", this, 18*8+64, 131);
		add(cancel);
	}
	
	public void addTextArea() {
		textArea = new JTextArea();
		textArea.setText("");
		textArea.setBounds(18, 39, 230, 50);
		textArea.setSelectedTextColor(Color.BLUE);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		add(textArea);
	}
	
	@Override
	public void paint(Graphics g) {
		paints(g);
		
		cancel.update(g);
		super.paint(g);
	}
	
	public void paints(Graphics g) {
		g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0,
				bg.getWidth(null), bg.getHeight(null), null);
	}
	
}
