package by.bsuir.archive.service.impl;

import by.bsuir.archive.connect.Server;
import by.bsuir.archive.connect.exception.ConnectionException;
import by.bsuir.archive.service.ServerService;
import by.bsuir.archive.service.exception.ServiceException;

public class ServerServiceImpl implements ServerService {

	@Override
	public void start() throws ServiceException {
		Server server = Server.getInstance();
		try {
			server.Start();
		} catch (ConnectionException e) {
			throw new ServiceException(e);
		}

	}
}
