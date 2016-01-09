package CopySrc;

import java.io.*;

/**
 * Created by nicholas on 16-1-8.
 * CopyFile
 */
public class CopySrc {
    public static void CopySrc() {
        FileReader reader;
        FileWriter writer;
        try {
            reader = new FileReader("src/CopySrc/CopySrc.java");
            writer = new FileWriter("src/CopySrc/CopySrc.txt",true);
            int val;
            while ((val = reader.read()) != -1) {
                writer.write((char) val);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
