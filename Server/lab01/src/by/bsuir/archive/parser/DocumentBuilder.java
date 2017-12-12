package by.bsuir.archive.parser;

import java.util.*;
import java.io.*;
import java.util.regex.*;

import by.bsuir.archive.parser.exception.ParserException;

public class DocumentBuilder {

	public String getDocumentAsString(String location) throws ParserException {
		try {
			File file = new File(location);
			FileReader fReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fReader);
			String inputLine;
			StringBuffer strDocument = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {

				strDocument.append(inputLine);
			}
			fReader.close();
			return strDocument.toString();
		} catch (FileNotFoundException ex) {
			throw new ParserException(ex);
		} catch (IOException ex) {
			throw new ParserException(ex);
		}
	}

	public Document getDocument(String location) throws ParserException {

		String documentAsString = getDocumentAsString(location);
		return parseDocument(documentAsString);
	}

	public Document parseDocument(String documentStr) {
		Pattern nodeP = Pattern.compile("<(/?)([a-zA-Z_]+)([a-zA-Z_0-9:]*)([^>]*)(/?)>([ ]*)(([^<]*)?)");
		Matcher nodeM = nodeP.matcher(documentStr);
		Node current = null;
		Node currentParent = null;
		List<Attribute> attrs = null;
		Document doc = new Document();
		String name;
		if (nodeM.find()) {

			if (nodeM.group(3).isEmpty()) {
				name = nodeM.group(2);
			} else {
				name = nodeM.group(3).substring(1);
			}
			if (!nodeM.group(4).isEmpty()) {
				attrs = parseNodeAttributes(nodeM.group(4));
			}
			current = new Node(name, nodeM.group(7), null, attrs);
			attrs = null;
			doc.setRootNode(current);
			currentParent = current;
			if (!nodeM.group(5).isEmpty()) {
				current = current.getParent();
			}
		}
		while (nodeM.find()) {
			if (nodeM.group(1).isEmpty()) {
				if (nodeM.group(3).isEmpty()) {
					name = nodeM.group(2);
				} else {
					name = nodeM.group(3).substring(1);
				}
				if (!nodeM.group(4).isEmpty()) {
					attrs = parseNodeAttributes(nodeM.group(4));
				}
				Node newNode = new Node(name, nodeM.group(7), current, attrs);
				current = newNode;
				attrs = null;
				currentParent.addChild(current);
				currentParent = current;

				if (!nodeM.group(4).isEmpty()) {

					String str = nodeM.group(4);
					str = str.substring(str.length() - 1);

					if (str.charAt(0) == '/') {
						current = current.getParent();
						currentParent = currentParent.getParent();
					}
				}

			} else {
				current = current.getParent();
				currentParent = currentParent.getParent();
			}
		}

		return doc;
	}

	private List<Attribute> parseNodeAttributes(String str) {

		Pattern attrP = Pattern.compile(" ([a-zA-z_]+)=\"([\\p{Alnum}\\p{Punct}]+)\"");
		Matcher attrM = attrP.matcher(str);
		List<Attribute> attrs = new LinkedList<Attribute>();

		while (attrM.find()) {

			attrs.add(new Attribute(attrM.group(1), attrM.group(2)));
		}

		return attrs;
	}

}