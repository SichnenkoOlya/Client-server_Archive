package by.bsuir.archive.controller.command.impl;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.controller.command.Command;
import by.bsuir.archive.controller.command.exception.CommandException;
import by.bsuir.archive.service.MatterService;
import by.bsuir.archive.service.ServiceFactory;
import by.bsuir.archive.service.exception.ServiceException;

public class ChangeMatter implements Command{

	@Override
	public String execute(Message request) throws CommandException {
		ServiceFactory servaceFactory = new ServiceFactory();
		MatterService matterServise = servaceFactory.getMatterService();
		try {
			matterServise.changeMatter(request.getId(), request.getSurname(),
					request.getName(),request.getAge(), request.getUniversity(),
					request.getNumberOfGroup());
		} catch (ServiceException e) {
			throw new CommandException(e);
		}

		return "Дело успешно изменено";
	}

}
