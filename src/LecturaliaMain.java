import java.sql.Connection;

public class LecturaliaMain {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();
        LecturaliaMenu lecturaliaMenu = new LecturaliaMenu();
        LibroController libroController = new LibroController();
        TemaController temaController = new TemaController();

        int op = lecturaliaMenu.menuPrincipal();
        while (op > 0 && op < 12){
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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
