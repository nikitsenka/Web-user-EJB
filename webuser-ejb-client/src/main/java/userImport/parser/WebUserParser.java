package userImport.parser;


import userImport.model.WebUser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface WebUserParser {
    List<WebUser> getAll() throws JAXBException, FileNotFoundException;
}
