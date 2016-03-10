package controller.configurations;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;


public class XMLWriter implements XMLParser {
	private File myFile;
	private Document doc;
	private Map<String, Object> myInfo;

	public XMLWriter(File f, Map<String, Object> info) {
		myFile = f;
		myInfo = info;
	}

	private Element addElement(Element root, String name) {
		Element e = doc.createElement(name);
		root.appendChild(e);
		return e;
	}

	private void addText(Element root, String text) {
		root.appendChild(doc.createTextNode(text));
	}

	private void setUpDoc() throws ParserConfigurationException {
		DocumentBuilderFactory dbFactory =
				DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
	}

	private void writeDoc() {
		try {
			TransformerFactory transformerFactory =
					TransformerFactory.newInstance();
			Transformer transformer =
					transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result =
					new StreamResult(myFile);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generateDoc() {
		// root element
		Element workspace = doc.createElement("workspace");
		doc.appendChild(workspace);

		//  turtle view element
		Element turtleView = addElement(workspace, "turtle-view");

		// turtle view information
		Element bcolor = addElement(turtleView, "background-color");
		int bcolorInd = ((IntegerProperty) myInfo.get("background-color")).getValue();
		addText(bcolor, String.valueOf(bcolorInd));
		Element imglist = addElement(turtleView, "image-list");
		ObservableList<String> images = (ObservableList<String>) myInfo.get("image-list");
		for (int i=0; i < images.size(); i++ ){
			Element image = addElement(imglist, "img" + String.valueOf(i));
			addText(image, images.get(i));
		}
		Element numTurtles = addElement(turtleView, "turtle-count");
		addText(numTurtles, myInfo.get("turtle-count").toString());


		// settings element
		Element settings = addElement(workspace, "settings");

		// settings information
		Element language = addElement(settings, "language");
		int langInd = ((IntegerProperty) myInfo.get("language")).getValue();
		addText(language, String.valueOf(langInd));
		
	}

	@Override
	public void parse() throws ParserConfigurationException {
		setUpDoc();
		generateDoc();
		writeDoc();
	}

}


