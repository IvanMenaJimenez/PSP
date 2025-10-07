package EJ_1;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EJ_1 {

    static double MediaArray(ArrayList notas) {
        double media = 0;

        for (int i = 0; i < notas.size(); i++) {
            media += (double) notas.get(i);
        }
        System.out.println(media / notas.size());
        return (media / notas.size());
    }

    static void MediaAlumno(File file) {
        ArrayList notasAlumno = new ArrayList();

        String lineas;

        try (BufferedReader reader = new BufferedReader(new FileReader(file)); ObjectOutputStream serializar = new ObjectOutputStream(new FileOutputStream("notasAlumnos"))) {

            while ((lineas = reader.readLine()) != null) {
                notasAlumno.add(Double.parseDouble(lineas.split(" ")[1]));
            }

            Alumno a = new Alumno(file.getName(), MediaArray(notasAlumno));
            serializar.writeObject(a);
          
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    static Map Asignaturas(File file) {
        Map<String, ArrayList> mapa = new HashMap();
        String lineas;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((lineas = reader.readLine()) != null) {
                String[] notaAsignatura = lineas.split(" ");

                if (!mapa.containsKey(notaAsignatura[0])) {
                    mapa.put(notaAsignatura[0], new ArrayList());
                }
                mapa.get(notaAsignatura[0]).add(Double.parseDouble(notaAsignatura[1]));

            }

        } catch (IOException e) {
            System.out.println(e);
        }

        return mapa;
    }

    static void MediaAsignaturas(Map<String, ArrayList> mapa) {

        for (Map.Entry<String, ArrayList> entry : mapa.entrySet()) {
            System.out.println(entry.getKey());

            MediaArray(entry.getValue());

        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\Users\\ivan.menjim\\Documents\\NetBeansProjects\\DesarrolloServiciosYProcesos\\Alumnos");
        Map<String, ArrayList> mapa = new HashMap();

        File[] subdirectoria = file.listFiles();

        for (int i = 0; i < subdirectoria.length; i++) {
            File archivo = new File(subdirectoria[i] + "\\notas.txt");

            System.out.println(subdirectoria[i].getName());
            MediaAlumno(archivo);

            mapa.putAll(Asignaturas(archivo));

        }
        System.out.println("---------------------------------");
        MediaAsignaturas(mapa);
    }
}
