package controller;

import gui.ShutdownToolGui;
import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.BasicLoggedApplication;

public class ShutdownToolApplication extends BasicLoggedApplication {

	private final ApplicationProperties properties;

	public static void main(String[] args) {
		setUpLoggingServices(ShutdownToolApplication.class);
		try {
			ApplicationProperties properties = new ApplicationProperties();
			ShutdownToolApplication shutdownToolApplication = new ShutdownToolApplication(properties);
			shutdownToolApplication.start();
		} catch (Exception e) {
			getLogger().fatal(e);
		}
	}

	public ShutdownToolApplication(ApplicationProperties properties) {
		super();
		this.properties = properties;
	}

	@Override
	public void start() {
		ShutdownToolGui gui = new ShutdownToolGui(this.properties);
		gui.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
}
