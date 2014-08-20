package userImport.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "WebUsers")
public class WebUsers {

    private List<WebUser> webUsers;

    public List<WebUser> getWebUsers() {
        return webUsers;
    }
    @XmlElement(name="WebUser")
    public void setWebUsers(List<WebUser> webUsers) {
        this.webUsers = webUsers;
    }
}
