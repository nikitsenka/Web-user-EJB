package userImport.parser.jaxbParser;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampAdapter extends XmlAdapter<String, Timestamp> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Timestamp v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return new Timestamp(dateFormat.parse(v).getTime());
    }

}