package controller.configurations;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public interface XMLParser {

    public void parse () throws ParserConfigurationException, SAXException, IOException;

}
