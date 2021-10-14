import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;@XmlRootElement


public class Patient implements Serializable {
    private String name;
    private String cprnr;

    @Override
    public String toString() {
        return "Patient{" +
                "patientName='" + name + '\'' +
                ", cprnr='" + cprnr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCprnr() {
        return cprnr;
    }

    public void setCprnr(String cprnr) {
        this.cprnr = cprnr;
    }




}
