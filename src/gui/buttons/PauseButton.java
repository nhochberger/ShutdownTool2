package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import events.StopCountdownEvent;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.ImageButton;
import hochberger.utilities.images.loader.ImageLoader;

public class PauseButton extends ImageButton implements ActionListener {

	private static final long serialVersionUID = 2462249629857172388L;
	private final EventBus eventBus;

	public PauseButton(EventBus eventBus) {
		super(ImageLoader.loadImage("graphics/pause.png"),
				ImageLoader.loadImage("graphics/pause_hover.png"),
				ImageLoader.loadImage("graphics/pause.png"),
				ImageLoader.loadImage("graphics/pause.png"));
		this.eventBus = eventBus;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.eventBus.publishFromEDT(new StopCountdownEvent());
	}
}
