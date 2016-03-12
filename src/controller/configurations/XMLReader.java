package controller.configurations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
			
			String backgroundIndex = "";
			List<String> imageFiles = new ArrayList<>();
			String turtleCount = "";
			String languageIndex = "";
			if (workspace.getNodeType() == Node.ELEMENT_NODE) {
				Element workspaceElement = (Element) workspace;
				NodeList turtleViewInfoNode = workspaceElement.getElementsByTagName("turtle-view");
				Node turtleViewInfo = turtleViewInfoNode.item(0);
				if (turtleViewInfo.getNodeType() == Node.ELEMENT_NODE) {
					Element turtleViewInfoElement = (Element) turtleViewInfo;
					backgroundIndex = extractInfo("background-color", turtleViewInfoElement);
					turtleCount = extractInfo("turtle-count", turtleViewInfoElement);
					addImages(imageFiles, turtleViewInfoElement);
				}
				
				NodeList settingsNode = workspaceElement.getElementsByTagName("settings");
				Node settings = settingsNode.item(0);
				if (settings.getNodeType() == Node.ELEMENT_NODE) {
					Element settingsElement = (Element) settings;
					languageIndex = extractInfo("language", settingsElement);
				}
			}
			return new Configuration(backgroundIndex, imageFiles, turtleCount, languageIndex);
	}

    private void addImages (List<String> imageFiles, Element turtleViewInfoElement) {
        Node imageList = turtleViewInfoElement.getElementsByTagName("image-list").item(0);
        if (imageList.getNodeType() == Node.ELEMENT_NODE) {
        	Element imageListElement = (Element) imageList;
        	for (int i = 0; i < imageList.getChildNodes().getLength(); i++) {
        		imageFiles.add(imageListElement.getElementsByTagName("img" + String.valueOf(i)).item(0).getTextContent());
        	}
        }
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
