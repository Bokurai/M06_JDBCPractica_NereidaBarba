import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TemaController {
    private Connection connection;

    public TemaController(Connection connection){
        this.connection = connection;
    }

    public void mostrarLibrosPorTema() throws SQLException, NumberFormatException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        System.out.println("Mostrando temas disponibles...");
    }
}
