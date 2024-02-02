import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Controlador para operaciones relacionadas con la gestión de libros en la base de datos.
 */
public class LibroController {

    private final Connection connection;

    /**
     * Constructor de la clase LibroController.
     *
     * @param connection La conexión a la base de datos.
     */
    public LibroController(Connection connection){
        this.connection = connection;
    }

    /**
     * Muestra todos los libros disponibles en la base de datos.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     */
    public void mostrarLibros() throws SQLException, NumberFormatException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM libros");

        while (resultSet.next()) {
            String id_tema = resultSet.getString("id_tema");
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            String titulo_resumen = resultSet.getString("titulo_resumen");
            String resumen = resultSet.getString("resumen");

            System.out.println(id_tema + "\n" + titulo + "\n" + autor +  "\n" + titulo_resumen + "\n" + resumen + "\n✎✧˚ ༘ ⋆｡˚ ✎✧˚ ༘ ⋆｡");
        }

        resultSet.close();
        statement.close();
    }

    /**
     * Muestra los libros escritos por un autor específico.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
    public void mostrarLibrosPorAutor() throws SQLException, NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        System.out.println("Escriba correctamente el nombre del autor: ");
        String nombreautor = bufferedReader.readLine();

        resultSet = statement.executeQuery("SELECT * FROM libros WHERE autor LIKE '" + nombreautor + "'");
        while (resultSet.next()){
            String titulo = resultSet.getString("titulo");
            String titulo_resumen = resultSet.getString("titulo_resumen");
            String resumen = resultSet.getString("resumen");

            System.out.println(titulo + "\n" + titulo_resumen + "\n" + resumen + "\n✎✧˚ ༘ ⋆｡˚ ✎✧˚ ༘ ⋆｡");
        }

        statement.close();
        resultSet.close();
    }

    /**
     * Modifica los detalles de un libro específico.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
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

        int registroMod = preparedStatement.executeUpdate();

        if (registroMod > 0) {
            System.out.println("Se han modificado las propiedades del libro.");
        } else {
            System.out.println("No se pudo modificar el libro, por favor compruebe que ha escrito bien la información.");
        }
        preparedStatement.close();
        statement.close();
    }

    /**
     * Elimina un libro específico de la base de datos.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
    public void eliminarLibro() throws SQLException,NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ID del libro a eliminar: ");

        int id = Integer.parseInt(bufferedReader.readLine());

        String orden = "DELETE FROM libros WHERE id = ?";
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
