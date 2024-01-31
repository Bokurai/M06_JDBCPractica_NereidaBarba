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
        while (op > 0 && op < 12){
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
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
            }

            op = lecturaliaMenu.menuPrincipal();

        }
    }
}
