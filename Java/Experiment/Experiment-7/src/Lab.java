import CopySrc.CopySrc;
import FileCompare.FileCompare;
import PrimeFile.PrimeFile;
import Typein.Typein;
import FileProperty.FileProperty;

import java.io.IOException;

/**
 * Created by nicholas on 16-1-8.
 * Lab
 */
public class Lab {
    public static void main(String[] args) throws IOException{
        Typein.Typein();
        FileProperty.FileProperty();
        CopySrc.CopySrc();
        FileCompare.FileCompare();
        PrimeFile.PrimeFile();
    }
}
