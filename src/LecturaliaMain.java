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
        while (op >= 0 && op < 11){
            switch (op) {
                case 1:
                    libroController.mostrarLibros();
                    break;

                case 2:
                    libroController.mostrarLibrosPorAutor();
                    break;

                case 3:
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
                    dbController.borrarTablas();
                    break;

                case 8:
                    dbController.crearTablaTemas();
                    dbController.crearTablaLibros();
                    break;

                case 9:
                    dbController.poblarTablaTemas();
                    dbController.poblarTablaLibros();
                    break;

                case 10:
                    break;
                default:
                    System.out.println("No es valido");
                    break;
            }
            op = lecturaliaMenu.menuPrincipal();
        }
    }
}
