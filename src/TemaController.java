import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TemaController {
    private Connection connection;

    public TemaController(Connection connection){
        this.connection = connection;
    }

    public void mostrarLibrosPorTema() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        System.out.println("Mostrando temas disponibles...");
    }

    public void librosTemaAutor()throws SQLException, NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        System.out.println("Mostrando temas disponibles...");
    }

    public void mostrarTemas()throws SQLException, NumberFormatException, IOException {
    }
}
