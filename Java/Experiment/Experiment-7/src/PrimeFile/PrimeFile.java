package PrimeFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by nicholas on 16-1-8.
 * PrimeFile
 */
public class PrimeFile {
    public static void PrimeFile() {
        int limit, index = 0;
        boolean isPrime;
        FileWriter writer;
        FileReader reader;
        try {
            writer = new FileWriter("src/PrimeFile/Prime.dat");
            for (int i = 2; i < 200; i++) {
                isPrime = true;
                limit = (int) Math.sqrt(i);
                for (int j = limit; j > 1; j--) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    writer.write(i + "\n");
                }
            }
            writer.close();
            reader = new FileReader("src/PrimeFile/Prime.dat");
            int val;
            while ((val = reader.read()) != -1) {
                System.out.print((char) val);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
