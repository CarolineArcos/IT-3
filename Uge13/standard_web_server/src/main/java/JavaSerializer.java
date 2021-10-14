import java.io.*;
import java.io.Serializable;
public class JavaSerializer {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setName("testUser");
        patient.setCprnr("testCprnr");
        writeToFile(patient);
        System.out.println("Wrote file");
        System.out.println("Reading file");
        Patient loadedUser = readFromFile();
        System.out.println(loadedUser);
    }

    static Patient readFromFile() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Patient.obj"));
            Object o = objectInputStream.readObject();
            return (Patient) o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void writeToFile(Serializable s){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Patient.obj"));
            objectOutputStream.writeObject(s);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
