import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.*;
import java.text.ParseException;

public class LibroController {

    private Connection connection;

    public LibroController(Connection connection){
        this.connection = connection;
    }

    public void mostrarLibros() throws SQLException, NumberFormatException{
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT * FROM Libros");
    }


}
