package FileProperty;

import java.io.File;

/**
 * Created by nicholas on 16-1-8.
 * FileProperty
 */
public class FileProperty {
    public static void FileProperty(){
        File file = new File("src/Lab.java");
        System.out.println("Path:"+file.getAbsolutePath());
        System.out.println("Name:"+file.getName());
        System.out.println("Length:"+file.length());
        System.out.println("Size:"+file.getTotalSpace());
    }
}
