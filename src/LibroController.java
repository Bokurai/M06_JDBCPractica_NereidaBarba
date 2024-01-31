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

       statement.close();
       resultSet.close();
    }

    public void mostrarLibrosPorAutor() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        System.out.println("Escriba correctamente el nombre del autor: ");
        String nombreautor = bufferedReader.readLine();

        resultSet = statement.executeQuery("SELECT * FROM Libros WHERE autor LIKE '" + nombreautor + "'");

        statement.close();
        resultSet.close();
    }

    public void modificarLibro() throws SQLException,NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();

        System.out.println("ID del libro a modificar: ");
        int id = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Escriba el nuevo título del libro:" );
        String titulo = bufferedReader.readLine();

        System.out.println("Escriba el nuevo autor del libro: ");
        String autor = bufferedReader.readLine();

        System.out.println("Escriba el nuevo título del resumen: ");
        String titulo_resumen = bufferedReader.readLine();

        System.out.println("Escriba el nuevo resumen del libro:");
        String resumen = bufferedReader.readLine();

        String orden = "UPDATE Libros SET titulo = ?, autor = ?, titulo_resumen = ?, resumen = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(orden);

        preparedStatement.setString(1, titulo);
        preparedStatement.setString(2, autor);
        preparedStatement.setString(3, titulo_resumen);
        preparedStatement.setString(4, resumen);
        preparedStatement.setInt(5, id);

        int registroMod = preparedStatement.executeUpdate();

        if (registroMod > 0) {
            System.out.println("Se han modificado las propiedades del libro.");
        } else {
            System.out.println("No se pudo modificar el libro, por favor compruebe que ha escrito bien la información.");
        }
        preparedStatement.close();
        statement.close();
    }

    public void eliminarLibro() throws SQLException,NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ID del libro a eliminar: ");

        int id = Integer.parseInt(bufferedReader.readLine());

        String orden = "DELETE FROM Libros WHERE ide = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(orden);

        int registroElim = preparedStatement.executeUpdate();

        if (registroElim > 0) {
            System.out.println("Se ha eliminado el libro.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
        preparedStatement.close();
    }
}
