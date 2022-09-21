import java.io.*;

public class WriteFile {
    private String textOfFile;
    private FileWriter file;
    private PrintWriter printWriter;
    private boolean saveHistory = false;

    public WriteFile(String path) throws FileNotFoundException {
        try {
            file = new FileWriter(path);
            printWriter = new PrintWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textOfFile = new String();
        saveHistory = false;
       // System.setOut(file);
    }

    public boolean isSaveHistory() {
        return saveHistory;
    }

    public void appendString(String str) {
        textOfFile = textOfFile.concat(str);
    }

    public void writeToFile(){
        try {
            file.write(textOfFile);
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean checkWriting(){
        if(saveHistory == true){
            return true;
        }
        return false;
    }
    public void setSaveFile(){
        saveHistory = true;
    }
}
