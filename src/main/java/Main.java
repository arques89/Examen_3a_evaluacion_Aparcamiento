import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de la clase File con la ruta al archivo
        File file = new File("Aparcamientos.csv");

        // Creamos un objeto Scanner para leer el archivo
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            scanner.nextLine(); 

            // Creamos los mapas para almacenar los datos
            Map<String, Integer> aparcamientosPorTipo = new HashMap<>();
            Map<String, Integer> aparcamientosPorDistrito = new HashMap<>();

            // Leemos archivo línea por línea
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] separador = line.split(",");

                // Obtener los datos de cada línea
                String tipo = separador[2];
                String distrito = separador[6];

                // Añadir los datos obtenidos en los mapas
                aparcamientosPorTipo.put(tipo, aparcamientosPorTipo.getOrDefault(tipo, 0) + 1);
                aparcamientosPorDistrito.put(distrito, aparcamientosPorDistrito.getOrDefault(distrito, 0) + 1);
            }

            // Mostrar los resultados
            System.out.println("Número de aparcamientos por tipo:");
            for (Map.Entry<String, Integer> entry : aparcamientosPorTipo.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Cerrar el objeto Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

