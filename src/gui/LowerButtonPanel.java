package gui;

import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.SimpleBackgroundedPanel;
import hochberger.utilities.gui.button.animated.VerticallyGrowingButton;
import hochberger.utilities.gui.button.animated.VerticallyGrowingButtonBuilder;
import hochberger.utilities.gui.font.FontLoader;
import hochberger.utilities.images.loader.ImageLoader;

import java.awt.Color;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;

public class LowerButtonPanel extends SimpleBackgroundedPanel {

	private static final int BUTTON_MAX_HEIGHT = 100;
	private static final int BUTTON_HEIGHT = 32;
	private static final int BUTTON_WIDTH = 100;
	private static final long serialVersionUID = 4314227632618067830L;
	private final EventBus eventBus;
	private final Font font;

	public LowerButtonPanel(EventBus eventBus) {
		super(ImageLoader.loadImage("graphics/background_gray.png"));
		this.eventBus = eventBus;
		this.font = FontLoader.loadFrom("font/Quicksand-Bold.otf")
				.deriveFont(Font.PLAIN).deriveFont(16f);
	}

	public void buildPanelContent() {
		setLayout(new MigLayout("center", ":[100]20[100]20[100]:",
				"0[100]0"));
		add(playButton());
		add(pauseButton());
		add(stopButton());
	}

	private VerticallyGrowingButton playButton() {
		VerticallyGrowingButton playButton = VerticallyGrowingButtonBuilder
				.newButtonWithText("Start")
				.andColors(new Color(39, 174, 96), Color.WHITE, Color.GRAY)
				.andDimensions(BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_MAX_HEIGHT)
				.andFont(this.font)
				.andImage(ImageLoader.loadImage("graphics/playback_play.png"))
				.create();
		return playButton;
	}

	private VerticallyGrowingButton pauseButton() {
		VerticallyGrowingButton pauseButton = VerticallyGrowingButtonBuilder
				.newButtonWithText("Pause")
				.andColors(new Color(230, 126, 34), Color.WHITE, Color.GRAY)
				.andDimensions(BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_MAX_HEIGHT)
				.andFont(this.font)
				.andImage(ImageLoader.loadImage("graphics/playback_pause.png"))
				.create();
		return pauseButton;
	}

	private VerticallyGrowingButton stopButton() {
		VerticallyGrowingButton stopButton = VerticallyGrowingButtonBuilder
				.newButtonWithText("Stop")
				.andColors(new Color(231, 76, 60), Color.WHITE, Color.GRAY)
				.andDimensions(BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_MAX_HEIGHT)
				.andFont(this.font)
				.andImage(ImageLoader.loadImage("graphics/playback_stop.png"))
				.create();
		return stopButton;
	}
}
