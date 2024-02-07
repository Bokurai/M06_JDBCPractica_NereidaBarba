import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase principal que ejecuta la aplicación de la Biblioteca Digital de Lecturalia.
 */
public class LecturaliaMain {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     * @throws SQLException         Si ocurre un error de base de datos.
     * @throws IOException          Si ocurre un error de entrada/salida.
     * @throws CsvValidationException Si ocurre un error al validar el archivo CSV.
     */
    public static void main(String[] args) throws SQLException, IOException, CsvValidationException {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();
        LecturaliaMenu lecturaliaMenu = new LecturaliaMenu();
        LibroController libroController = new LibroController(c);
        TemaController temaController = new TemaController(c);
        DBController dbController = new DBController(c);

        int op = lecturaliaMenu.menuPrincipal();
        while (op >= 0 && op < 13){
            switch (op) {
                case 1:
                    libroController.mostrarLibros();
                    break;

                case 2:
                    libroController.mostrarLibrosPorAutor();
                    break;

                case 3:
                    System.out.println("Aquí tiene los temas disponibles:");
                    temaController.mostrarTemas();
                    temaController.mostrarLibrosPorTema();
                    break;

                case 4:
                    temaController.mostrarTemas();
                    break;

                case 5:
                    libroController.modificarLibro();
                    break;

                case 6:
                    libroController.eliminarLibro();
                    break;

                case 7:
                    libroController.eliminarLibrosAutor();
                    break;

                case 8:
                    System.out.println("Aquí tiene los temas disponibles:");
                    temaController.mostrarTemas();
                   libroController.insertarLibro();
                    break;

                case 9:
                    dbController.borrarTablas();
                    break;

                case 10:
                    dbController.crearTablaTemas();
                    dbController.crearTablaLibros();
                    break;

                case 11:
                    dbController.poblarTablaTemas();
                    dbController.poblarTablaLibros();
                    break;

                case 12:
                    break;
                default:
                    System.out.println("No es válido");
                    break;
            }
            op = lecturaliaMenu.menuPrincipal();
        }
    }
}
