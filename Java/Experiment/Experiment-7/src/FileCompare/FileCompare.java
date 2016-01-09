package FileCompare;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nicholas on 16-1-8.
 * FileCompare
 */
public class FileCompare {
    public static void FileCompare(){
        FileReader file1,file2;
        try {
            file1 = new FileReader("src/CopySrc/CopySrc.java");
            file2 = new FileReader("src/CopySrc/CopySrc.txt");
            boolean flag = true;
            int val;
            while (flag && (val = file1.read()) != -1){
                flag = val == file2.read();
            }
            if (flag)
                System.out.println("Two file have same content");
            else
                System.out.println("Two file have different content");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
