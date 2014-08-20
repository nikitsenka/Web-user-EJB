package userImport.parser.jaxbParser;


import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<String, Boolean>
{

    @Override
    public Boolean unmarshal(String v) throws Exception {
        return Boolean.parseBoolean(v);
    }

    @Override
    public String marshal(Boolean v) throws Exception {
        return v.toString();
    }
}