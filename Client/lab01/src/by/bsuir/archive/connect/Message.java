package by.bsuir.archive.connect;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String command;
	private String answer;

	private String name;
	private String surname;
	private int age;
	private String university;
	private int numberOfGroup;
	private int id;

	public Message(String command) {
		this.setCommand(command);
	}

	public Message(String command, String surname, String name, int age, String univer, int numberOfGroup) {
		this.setCommand(command);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.university = univer;
		this.numberOfGroup = numberOfGroup;
	}

	public Message(String command, String surname, String name, int age, String univer, int numberOfGroup, int id) {
		this.setCommand(command);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.university = univer;
		this.numberOfGroup = numberOfGroup;
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfGroup() {
		return numberOfGroup;
	}

	public void setNumberOfGroup(int numberOfGroup) {
		this.numberOfGroup = numberOfGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Message that = (Message) o;
		return (id == that.id) && (command == that.command) && (answer == that.answer);

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + id;
		return result;
	}

	@Override
	public String toString() {

		return "Message {" + "id= " + id + "," + " surname= " + surname + "," + " name=" + name + "," + " age= " + age
				+ "," + " university= " + university + "," + " group= " + numberOfGroup + " command= " + "," + command
				+ "," + " answer= " + answer + '}';

	}
}
