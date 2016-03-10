package controller.configurations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
				NodeList turtleViewInfoNode = workspaceElement.getElementsByTagName("turtle-view");
				Node turtleViewInfo = turtleViewInfoNode.item(0);

				if (turtleViewInfo.getNodeType() == Node.ELEMENT_NODE) {
					Element turtleViewInfoElement = (Element) turtleViewInfo;
					extractInfo("background-color", turtleViewInfoElement);
					extractInfo("turtle-count", turtleViewInfoElement);
					ObservableList<String> images = FXCollections.observableArrayList();
					Node imageList = turtleViewInfoElement.getElementsByTagName("image-list").item(0);
					if (imageList.getNodeType() == Node.ELEMENT_NODE) {
						Element imageListElement = (Element) imageList;
						for (int i = 0; i < imageList.getChildNodes().getLength(); i++) {
							images.add(imageListElement.getElementsByTagName("img" + String.valueOf(i)).item(0).getTextContent());
						}
					}
					myInfo.put("image-list", images);
				}
				
				NodeList settingsNode = workspaceElement.getElementsByTagName("settings");
				Node settings = settingsNode.item(0);
				
				if (settings.getNodeType() == Node.ELEMENT_NODE) {
					Element settingsElement = (Element) settings;
					extractInfo("language", settingsElement);
				}
			}
	}

}