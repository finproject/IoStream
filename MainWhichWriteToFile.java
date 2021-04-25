package file_examples;

import lombok.SneakyThrows;
import model.Person;

import java.io.*;

/**
 * @author Evgeny Borisov
 */
public class MainWhichWriteToFile {

    @SneakyThrows
    public static void main(String[] args) {

        String path = "/home/dev/data/obj.txt";
        Person daniel = new Person("Daniel", 28, 33000);

        MainWhichWriteToFile mainWhichWriteToFile = new MainWhichWriteToFile();
        mainWhichWriteToFile.createFile(path);
        mainWhichWriteToFile.addObjectIntoTheFile(path, daniel);
        mainWhichWriteToFile.printObjectFromFile(path);
    }

    @SneakyThrows
    public void createFile(String path) {
        File file = new File(path);
        file.mkdirs();

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    @SneakyThrows
    public void addObjectIntoTheFile(String path, Object obj) {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }

    @SneakyThrows
    public void printObjectFromFile(String path) {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(path));
        Person o1 = (Person) ois.readObject();
        System.out.println(o1.toString());
        ois.close();
    }
}
