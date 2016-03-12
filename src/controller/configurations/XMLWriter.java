package controller.configurations;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.collections.FXCollections;
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

		// non list preferences
		String[] preferencesArray = {"background-color", "turtle-count", "language"};
		for (String preference: preferencesArray) {
			Element preferenceElement = addElement(workspace, preference);
			int preferenceValue = (Integer) myInfo.get(preference);
			addText(preferenceElement, String.valueOf(preferenceValue));
		}

		// list preferences
		String[] listableOptions = {"image-list", "palette"};
		for (String setting: listableOptions) {
			Element optionsList = addElement(workspace, setting);
			ObservableList<String> options = (ObservableList<String>) myInfo.get(setting);
			for (int i=0; i < options.size(); i++ ){
				Element option = addElement(optionsList, "item" + String.valueOf(i));
				addText(option, options.get(i));
			}
		}

	}

	@Override
	public void parse() throws ParserConfigurationException {
		setUpDoc();
		generateDoc();
		writeDoc();
	}

}


