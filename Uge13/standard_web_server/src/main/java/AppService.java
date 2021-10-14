import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.io.Serializable;

@Path("patient")
@Produces(MediaType.APPLICATION_XML)
public class AppService {
    @GET
    public String getPatient() throws JsonProcessingException,IOException  {
        Patient patient = new Patient();
        patient.setCprnr("123456-xxxx");
        patient.setName("Janos");
        JavaSerializer js = new JavaSerializer();
        js.writeToFile(patient);
        System.out.println("Wrote file");
        System.out.println("Reading file");
        Patient loadedPatient = js.readFromFile();
        System.out.println(loadedPatient);

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xmlString  = mapper.writeValueAsString(patient);
        System.out.println(xmlString );
        mapper.writeValue(new File("Patient.xml"),patient);
        System.out.println("written to a xml file" );
        Patient patientFromXML = mapper.readValue(new File("Patient.xml"), Patient.class);
        System.out.println("Read from XML: ");
        System.out.println(patientFromXML);
        return xmlString;
        //return patient;

    }
    @POST
    public String postAhoy(String username){
        return  "Ahoy" + username;
    }
    }

