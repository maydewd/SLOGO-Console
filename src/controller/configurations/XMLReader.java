package controller.configurations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class XMLReader implements XMLParser {
	private File myFile;
	private Map<String, Object> myInfo;

	public XMLReader(File f, Map<String, Object> info) {
		myFile = f;
		myInfo = info;
	}

	private void extractInfo(String name, Element e) {
		myInfo.put(name, e.getElementsByTagName(name).item(0).getTextContent());
	}

	@Override
	public void parse() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(myFile);

		document.getDocumentElement().normalize();
		NodeList workspaceNode = document.getElementsByTagName("workspace");
		Node workspace = workspaceNode.item(0);

		if (workspace.getNodeType() == Node.ELEMENT_NODE) {
			Element workspaceElement = (Element) workspace;
			
			String[] preferencesArray = {"background-color", "turtle-count", "language"};
			for (String preference: preferencesArray) {
				extractInfo(preference, workspaceElement);
			}
			
			String[] listableOptions = {"image-list", "palette"};
			for (String setting: listableOptions) {
				ObservableList<String> items = FXCollections.observableArrayList();
				Node settingList = workspaceElement.getElementsByTagName(setting).item(0);
				if (settingList.getNodeType() == Node.ELEMENT_NODE) {
					Element settingListElement = (Element) settingList;
					for (int i = 0; i < settingList.getChildNodes().getLength(); i++) {
						items.add(settingListElement.getElementsByTagName("item" + String.valueOf(i)).item(0).getTextContent());
					}
					myInfo.put(setting, items);
				}
			}
		}
	}
}


