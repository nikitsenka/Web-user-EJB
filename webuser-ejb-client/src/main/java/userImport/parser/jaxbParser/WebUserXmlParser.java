package userImport.parser.jaxbParser;

import userImport.model.WebUser;
import userImport.model.WebUsers;
import userImport.parser.WebUserParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class WebUserXmlParser implements WebUserParser {
    private File xmlFile;

    public WebUserXmlParser(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Override
    public List<WebUser> getAll() throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(WebUsers.class);
        Unmarshaller u = jc.createUnmarshaller();
        WebUsers webUsers = (WebUsers)u.unmarshal(xmlFile);
        return webUsers.getWebUsers();
    }
}
