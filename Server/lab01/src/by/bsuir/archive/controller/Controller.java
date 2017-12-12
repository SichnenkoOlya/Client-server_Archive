package by.bsuir.archive.controller;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.controller.command.Command;
import by.bsuir.archive.controller.command.exception.CommandException;
import by.bsuir.archive.view.ConsoleView;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final ConsoleView console = new ConsoleView();

	public String doAction(Message request) {
		String response = null;
		String commandName = request.getCommand();
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
		} catch (CommandException e) {
			response = "error:" + e.getLocalizedMessage() + "\n";
			console.writeLine(response);
		}
		return response;
	}

	public String doAction(String request) {
		String response = null;
		try {
			Command command = provider.getCommand(request);
			response = command.execute(new Message());
		} catch (CommandException e) {
			response = "error:" + e.getLocalizedMessage() + "\n";
			console.writeLine(response);
		}
		return response;
	}
}
