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
       ResultSet resultSet;

       resultSet = statement.executeQuery("SELECT * FROM Libros");
       while(resultSet.next()){

       }

       statement.close();
       resultSet.close();
    }

    public void mostrarLibrosPorAutor() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        System.out.println("Por favor escriba correctamente el nombre del autor");
        String nombreautor = bufferedReader.readLine();

        resultSet = statement.executeQuery("SELECT * FROM Libros WHERE autor LIKE '" + nombreautor + "'");
        while(resultSet.next()){
            System.out.println("Nombre: " + resultSet.getString(1) + " " + resultSet.getString(3) + "Resumen: " + resultSet.getString(4));
        }

        statement.close();
        resultSet.close();
    }

    public void modificarLibro() throws SQLException,NumberFormatException, IOException{

    }

    public void modificarLibros() throws SQLException,NumberFormatException, IOException{

    }

    public void eliminarLibro() throws SQLException,NumberFormatException, IOException{

    }

    public void eliminarLibros() throws SQLException,NumberFormatException, IOException{

    }
}
