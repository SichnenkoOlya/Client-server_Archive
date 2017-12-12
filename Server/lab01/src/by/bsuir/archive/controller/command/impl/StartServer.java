package by.bsuir.archive.controller.command.impl;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.controller.command.Command;
import by.bsuir.archive.controller.command.exception.CommandException;
import by.bsuir.archive.service.ServerService;
import by.bsuir.archive.service.ServiceFactory;
import by.bsuir.archive.service.exception.ServiceException;

public class StartServer implements Command {

	@Override
	public String execute(Message request) throws CommandException {
		ServiceFactory servaceFactory = new ServiceFactory();
		ServerService serverServise = servaceFactory.getServerService();
		try {
			serverServise.start();
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return "Сервер запущен";
	}
}