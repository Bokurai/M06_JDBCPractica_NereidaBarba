import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TemaController {
    private Connection connection;

    public TemaController(Connection connection){
        this.connection = connection;
    }


    public void mostrarTemas()throws SQLException, NumberFormatException{
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        resultSet = statement.executeQuery("SELECT * FROM Temas");

        statement.close();
        resultSet.close();
    }

    public void mostrarLibrosPorTema() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        System.out.println("Escriba correctamente el tema literario: ");
        String nombre_tema = bufferedReader.readLine();

        resultSet = statement.executeQuery("SELECT * FROM Libros WHERE nombre_tema LIKE '" + nombre_tema + "'");

        statement.close();
        resultSet.close();
    }


}
