package controller;

import gui.ShutdownToolGui;
import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.BasicLoggedApplication;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.eventbus.SimpleEventBus;

public class ShutdownToolApplication extends BasicLoggedApplication {

	private final ApplicationProperties properties;
	private final EventBus eventBus;

	public static void main(String[] args) {
		setUpLoggingServices(ShutdownToolApplication.class);
		try {
			ApplicationProperties properties = new ApplicationProperties();
			ShutdownToolApplication shutdownToolApplication = new ShutdownToolApplication(
					properties);
			shutdownToolApplication.start();
		} catch (Exception e) {
			getLogger().fatal(e);
		}
	}

	public ShutdownToolApplication(ApplicationProperties properties) {
		super();
		this.properties = properties;
		this.eventBus = new SimpleEventBus();
	}

	@Override
	public void start() {
		ShutdownToolGui gui = new ShutdownToolGui(this.properties, this.eventBus);
		gui.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
}
