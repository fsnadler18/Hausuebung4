import java.io.IOException;

public class Bsp1Main {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        try {
            fm.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fm.printAllAsTable();
    }
}
