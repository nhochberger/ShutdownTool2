package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import events.StopCountdownEvent;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.ImageButton;
import hochberger.utilities.images.loader.ImageLoader;

public class PlayButton extends ImageButton implements ActionListener {

	private static final long serialVersionUID = 2465800663568061146L;
	private final EventBus eventBus;

	public PlayButton(EventBus eventBus) {
		super(ImageLoader.loadImage("graphics/go.png"),
				ImageLoader.loadImage("graphics/go_hover.png"),
				ImageLoader.loadImage("graphics/go.png"),
				ImageLoader.loadImage("graphics/go.png"));
		this.eventBus = eventBus;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.eventBus.publishFromEDT(new StopCountdownEvent());
	}
}
