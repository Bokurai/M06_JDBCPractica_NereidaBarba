import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LecturaliaMain {

    public static void main(String[] args) throws SQLException, IOException {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();
        LecturaliaMenu lecturaliaMenu = new LecturaliaMenu();
        LibroController libroController = new LibroController(c);
        TemaController temaController = new TemaController(c);
        DBController dbController = new DBController(c);

        int op = lecturaliaMenu.menuPrincipal();
        while (op > 0 && op < 13){
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
                    libroController.modificarLibros();
                    break;
                case 7:
                    libroController.eliminarLibro();
                    break;
                case 8:
                    libroController.eliminarLibros();
                    break;
                case 9:
                    dbController.borrarTablas();

                    break;
                case 10:
                    dbController.crearTablaLibros();
                    dbController.crearTablaTemas();
                    break;
                case 11:
                    dbController.poblarTablas();
                    break;
                case 12:
                   break;
            }
            op = lecturaliaMenu.menuPrincipal();

        }
    }
}
