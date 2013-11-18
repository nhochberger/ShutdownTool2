package gui;

import gui.buttons.PauseButton;
import gui.buttons.PlayButton;
import gui.buttons.StopButton;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.SimpleBackgroundedPanel;
import hochberger.utilities.images.loader.ImageLoader;
import net.miginfocom.swing.MigLayout;

public class LowerButtonPanel extends SimpleBackgroundedPanel {

	private static final long serialVersionUID = 4314227632618067830L;
	private final EventBus eventBus;

	public LowerButtonPanel(EventBus eventBus) {
		super(ImageLoader.loadImage("graphics/background_gray.png"));
		this.eventBus = eventBus;
	}

	public void buildPanelContent() {
		setLayout(new MigLayout("center", ":[]50[]50[]:", "25[]25"));
		add(new PlayButton(this.eventBus));
		add(new PauseButton(this.eventBus));
		add(new StopButton(this.eventBus));
	}
}
