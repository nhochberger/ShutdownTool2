package gui;

import hochberger.utilities.gui.SimpleBackgroundedPanel;
import hochberger.utilities.gui.UndecoratedEDTSafeFrame;
import hochberger.utilities.images.loader.ImageLoader;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ShutdownToolMainFrame extends UndecoratedEDTSafeFrame {

	public ShutdownToolMainFrame(String title) {
		super(title);
	}

	@Override
	protected void buildUI() {
		exitOnClose();
		setSize(400, 300);
		center();
		useLayoutManager(new MigLayout("", "0[400]0", "0[200]0[100]0"));
		JPanel topPanel = new SimpleBackgroundedPanel(ImageLoader.loadImage("graphics/background_white.png"));
		add(topPanel, "width 400px, height 200, wrap");
		LowerButtonPanel component = new LowerButtonPanel();
		component.buildPanelContent();
		add(component, "width 400px, height 100");
	}
}
