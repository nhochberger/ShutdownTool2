package gui;

import hochberger.utilities.gui.SimpleBackgroundedPanel;
import hochberger.utilities.images.loader.ImageLoader;
import net.miginfocom.swing.MigLayout;

public class LowerButtonPanel extends SimpleBackgroundedPanel {

	private static final long serialVersionUID = 4314227632618067830L;

	public LowerButtonPanel() {
		super(ImageLoader.loadImage("graphics/background_gray.png"));
	}

	public void buildPanelContent() {
		setLayout(new MigLayout("center", ":[]50[]50[]:", "25[]25"));

		ImageButton play = new ImageButton(
				ImageLoader.loadImage("graphics/go.png"),
				ImageLoader.loadImage("graphics/go_hover.png"),
				ImageLoader.loadImage("graphics/go_clicked.png"));
		add(play);
		ImageButton pause = new ImageButton(
				ImageLoader.loadImage("graphics/pause.png"),
				ImageLoader.loadImage("graphics/pause_hover.png"),
				ImageLoader.loadImage("graphics/pause_clicked.png"));
		add(pause);
		ImageButton stop = new ImageButton(
				ImageLoader.loadImage("graphics/stop.png"),
				ImageLoader.loadImage("graphics/stop_hover.png"),
				ImageLoader.loadImage("graphics/stop_clicked.png"));
		add(stop);
	}
}
