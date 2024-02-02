import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que gestiona las operaciones relacionadas con los temas en la base de datos.
 */
public class TemaController {
    private final Connection connection;

    /**
     * Constructor de la clase TemaController.
     *
     * @param connection La conexión a la base de datos.
     */
    public TemaController(Connection connection){
        this.connection = connection;
    }

    /**
     * Muestra todos los temas disponibles en la base de datos.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     */
    public void mostrarTemas()throws SQLException, NumberFormatException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM temas");

        while (resultSet.next()) {
            String id_tema = resultSet.getString("id_tema");
            System.out.println(id_tema);
        }


        resultSet.close();
        statement.close();
    }

    /**
     * Muestra los libros asociados a un tema literario específico.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
    public void mostrarLibrosPorTema() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        System.out.println("Escriba correctamente el tema literario: ");
        String id_tema = bufferedReader.readLine();

        resultSet = statement.executeQuery("SELECT * FROM libros WHERE id_tema LIKE '" + id_tema + "'");
        while (resultSet.next()){
            String nombre_libro = resultSet.getString("titulo");
            System.out.println(nombre_libro);
        }
        statement.close();
        resultSet.close();
    }


}
