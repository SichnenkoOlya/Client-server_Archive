package by.bsuir.archive.controller.command;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.controller.command.exception.CommandException;

public interface Command {

	String execute(Message request) throws CommandException;
}

