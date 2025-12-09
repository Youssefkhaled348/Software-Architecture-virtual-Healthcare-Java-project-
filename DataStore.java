import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static void save(Object data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Failed saving " + filename + ": " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T load(String filename, Class<T> cls) {
        File f = new File(filename);
        if (!f.exists()) {
            if (List.class.isAssignableFrom(cls)) return (T) new ArrayList<>();
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (T) ois.readObject();
        } catch (Exception e) {
            System.out.println("Failed loading " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
