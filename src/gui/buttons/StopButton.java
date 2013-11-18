package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import events.StopCountdownEvent;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.ImageButton;
import hochberger.utilities.images.loader.ImageLoader;

public class StopButton extends ImageButton implements ActionListener {

	private static final long serialVersionUID = 1642027897351710140L;
	private final EventBus eventBus;

	public StopButton(EventBus eventBus) {
		super(ImageLoader.loadImage("graphics/stop.png"),
				ImageLoader.loadImage("graphics/stop_hover.png"),
				ImageLoader.loadImage("graphics/stop.png"),
				ImageLoader.loadImage("graphics/stop.png"));
		this.eventBus = eventBus;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.eventBus.publishFromEDT(new StopCountdownEvent());
	}
}
