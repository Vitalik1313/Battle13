package Menu_and_File;

import java.io.*;

public class WriteFile {
    private String textOfFile;
    private FileWriter file;
    private boolean saveHistory;

    public WriteFile() throws FileNotFoundException {
        try {
            file = new FileWriter("C:\\Users\\admin\\Desktop\\Лабораторні_JAVA\\FightHistory.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        textOfFile = "";
        saveHistory = false;
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
        return saveHistory;
    }
    public void setSaveFile(){
        saveHistory = true;
    }

    public FileWriter getFile() {
        return file;
    }
}
