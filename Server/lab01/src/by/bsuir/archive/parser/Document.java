package by.bsuir.archive.parser;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.archive.domain.Matter;

public class Document {
	private Node rootNode;

	public Node getRootNode() {

		return rootNode;
	}

	public void setRootNode(Node rootNode) {

		this.rootNode = rootNode;
	}

	public ArrayList<Matter> toArrayList() {

		ArrayList<Matter> listOfMatters = new ArrayList<Matter>();
		int depth = 0;
		Node nd = rootNode;
		Node currentParent = rootNode;

		Matter matter = new Matter();
		while (true) {
			currentParent = nd;
			nd = nd.getNextChild();
			while (nd == null) {

				if (currentParent.getChildren() != null) {

					int currDepth = depth;

					while (currDepth > 0) {

						currDepth--;
					}
					List<Attribute> listAttr = currentParent.getAttributes();
					String str;
					for (Attribute attr : listAttr) {
						switch (attr.getValue()) {
						case "ageOfStudent":
							str = currentParent.getFirstChild().getText();
							matter.setAgeOfStudent(Integer.parseInt(str));
							break;
						case "id":
							str = currentParent.getFirstChild().getText();
							matter.setId((Integer.parseInt(str)));
							break;
						case "nameOfStudent":
							str = currentParent.getFirstChild().getText();
							matter.setNameOfStudent(str);
							break;
						case "numberOfGroup":
							str = currentParent.getFirstChild().getText();
							matter.setNumberOfGroup((Integer.parseInt(str)));
							break;
						case "university":
							str = currentParent.getFirstChild().getText();
							matter.setUniversity(str);
							listOfMatters.add(matter);
							matter = new Matter();
							break;
						case "surname":
							str = currentParent.getFirstChild().getText();
							matter.setSurname(str);
							break;
						}
					}
				}

				if (currentParent.getParent() == null) {

					return listOfMatters;
				}
				depth--;
				nd = currentParent.getParent();
				nd = nd.getNextChild();
				currentParent = currentParent.getParent();
			}
			depth++;
		}
	}

}