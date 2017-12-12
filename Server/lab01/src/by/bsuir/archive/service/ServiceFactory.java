package by.bsuir.archive.service;

import by.bsuir.archive.service.impl.MatterServiceImpl;
import by.bsuir.archive.service.impl.ServerServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory factory = new ServiceFactory();

	private final MatterService matterService = new MatterServiceImpl();
	private final ServerService serverService = new ServerServiceImpl();

	public static ServiceFactory getInstance() {
		return factory;
	}

	public MatterService getMatterService() {
		return matterService;
	}

	public ServerService getServerService() {
		return serverService;
	}
}
