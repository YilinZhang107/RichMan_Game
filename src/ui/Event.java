package ui;

import java.awt.Graphics;

import model.EventsModel;

/**
 * 事件显示UI
 * 
 * @author 喝燕麦粥的107
 *
 */
public class Event extends Layer{

	private EventsModel events = null;
	
	protected Event(int x, int y, int width, int height, EventsModel events) {
		super(x, y, width, height);
		this.events = events;
	}

	@Override
	public void paint(Graphics g) {
		this.paintEvent(g);
	}
	
	private void paintEvent(Graphics g) {
		if (events.getStartTick() < events.getNowTick() &&
				events.getNextTick() >= events.getNowTick()) {
			//背景图覆盖
			g.drawImage(events.getBG_BRACK(), 0, 0, 2000, 2000, 0, 0, 1, 1, null);
			g.drawImage(events.getImg(), events.getImgPoint().getPosX(), events.getImgPoint().getPosY(),
					events.getImgPoint().getPosX()+events.getImg().getWidth(null),
					events.getImgPoint().getPosY()+events.getImg().getHeight(null),0, 0,
					events.getImg().getWidth(null), events.getImg().getHeight(null), null);
		}
	}

	@Override
	public void stratPanel() {
		// TODO 自动生成的方法存根
	}
	
	//去感叹号自动生成的
	private static final long serialVersionUID = 1L;
}
