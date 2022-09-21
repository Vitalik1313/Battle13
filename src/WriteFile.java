import java.io.*;

public class WriteFile {
    PrintStream file;
    boolean saveHistory = false;

    public WriteFile(String path) throws FileNotFoundException {
        try {
            PrintStream o = new PrintStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveHistory = true;
        System.setOut(file);
    }

    public boolean isSaveHistory() {
        return saveHistory;
    }
}
