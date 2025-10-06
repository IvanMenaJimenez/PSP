package desarrolloserviciosyprocesos;

import java.io.*;
import java.util.Map;

public class EJ_1 {

    public static void main(String[] args) {
        BufferedReader read = null;

        try {
            read = new BufferedReader(new FileReader("notas.txt"));
            String linea = null;

            while ((linea = read.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (Exception e) {
        }

    }
}
