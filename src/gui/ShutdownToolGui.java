package gui;

import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.Lifecycle;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.gui.EDTSafeFrame;

public class ShutdownToolGui implements Lifecycle {

	private final EDTSafeFrame frame;

	public ShutdownToolGui(ApplicationProperties applicationProperties,
			EventBus eventBus) {
		super();
		this.frame = new ShutdownToolMainFrame(applicationProperties.title(),
				eventBus);
	}

	@Override
	public void start() {
		this.frame.show();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}
}
