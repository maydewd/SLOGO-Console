package controller.configurations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

public class XMLReader {


	private String extractInfo(String name, Element e) {
		return e.getElementsByTagName(name).item(0).getTextContent();
	}

	public Configuration parse(File file) throws ParserConfigurationException, SAXException, IOException {
		Node workspace = getWorkspaceNode(file);

		HashMap<String, Object> configurations = new HashMap<>();
		String[] preferences = {"background-color", "turtle-count", "language", "initial-library"};
		String[] listPreferences = {"image-list", "palette"};
		
		if (workspace.getNodeType() == Node.ELEMENT_NODE) {
			Element workspaceElement = (Element) workspace;

			for (String preference: preferences) {
				configurations.put(preference, extractInfo(preference, workspaceElement));
			}
			
			for (String listPreference: listPreferences) {
				configurations.put(listPreference, extractListInfo(listPreference, workspaceElement));
			}
			
		}
		else {
			
			for (String preference: preferences) {
				configurations.put(preference, "");
			}
			for (String listPreference: listPreferences) {
				configurations.put(listPreference, new ArrayList<>());
			}
			
		}
		
		return new Configuration((String) configurations.get("background-color"), 
				(List<String>) configurations.get("image-list"), 
				(String) configurations.get("turtle-count"), 
				(String) configurations.get("language"),
				(List<String>) configurations.get("palette"),
				(String) configurations.get("initial-library"));
	}

	private List<String> extractListInfo (String setting, Element element) {
		ObservableList<String> items = FXCollections.observableArrayList();
		Node settingList = element.getElementsByTagName(setting).item(0);
		if (settingList.getNodeType() == Node.ELEMENT_NODE) {
			Element settingListElement = (Element) settingList;
			for (int i = 0; i < settingList.getChildNodes().getLength(); i++) {
				items.add(settingListElement.getElementsByTagName("item" + String.valueOf(i)).item(0).getTextContent());
			}
			return items;
		}
		else
			return new ArrayList<>();
	}
	

	private Node getWorkspaceNode (File file) throws ParserConfigurationException, SAXException,
	IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		document.getDocumentElement().normalize();
		NodeList workspaceNode = document.getElementsByTagName("workspace");
		Node workspace = workspaceNode.item(0);
		return workspace;
	}

}