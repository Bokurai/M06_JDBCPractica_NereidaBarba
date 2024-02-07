import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Controlador para operaciones relacionadas con la gestión de libros en la base de datos.
 */
public class LibroController {

    private final Connection connection;
    private TemaController temaController;

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
        ResultSet resultSet = statement.executeQuery("SELECT * FROM libros ORDER BY id");

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String id_tema = resultSet.getString("id_tema");
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            String titulo_resumen = resultSet.getString("titulo_resumen");
            String resumen = resultSet.getString("resumen");

            System.out.println(id + "\n" + id_tema + "\n" + titulo + "\n" + autor +  "\n" + titulo_resumen + "\n" + resumen + "\n✎✧˚ ༘ ⋆｡˚ ✎✧˚ ༘ ⋆｡");
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
     * Crea un registro nuevo de un libro en la base de datos
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
    public void insertarLibro() throws SQLException,NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = connection.createStatement();

        System.out.println("Escriba el tema del libro \n");
        String id_tema = bufferedReader.readLine();

        System.out.println("Escriba el título del libro:" );
        String titulo = bufferedReader.readLine();

        System.out.println("Escriba el autor del libro: ");
        String autor = bufferedReader.readLine();

        System.out.println("Escriba el título del resumen: ");
        String titulo_resumen = bufferedReader.readLine();

        System.out.println("Escriba el resumen del libro:");
        String resumen = bufferedReader.readLine();

        String orden = "INSERT INTO libros (id_tema, titulo, autor, titulo_resumen, resumen) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(orden);

        //preparedStatement.setInt(1);
        preparedStatement.setString(1, id_tema);
        preparedStatement.setString(2, titulo);
        preparedStatement.setString(3, autor);
        preparedStatement.setString(4, titulo_resumen);
        preparedStatement.setString(5, resumen);

        int registroNuevo = preparedStatement.executeUpdate();

        if (registroNuevo > 0) {
            System.out.println("Se ha añadido el libro a la biblioteca");
        } else {
            System.out.println("No se pudo añadir el libro, por favor compruebe que ha escrito bien la información.");
        }
        preparedStatement.close();
        statement.close();
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

        String orden = "UPDATE libros SET titulo = ?, autor = ?, titulo_resumen = ?, resumen = ? WHERE id = ?";
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

        preparedStatement.setInt(1, id);

        int registroElim = preparedStatement.executeUpdate();

        if (registroElim > 0) {
            System.out.println("Se ha eliminado el libro.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
        preparedStatement.close();
    }

    /**
     * Elimina todos los libros de la base de datos, ponoendo como condición el autor de los mismos.
     *
     * @throws SQLException          Si ocurre un error al ejecutar la consulta SQL.
     * @throws NumberFormatException Si ocurre un error al convertir datos.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
    public void eliminarLibrosAutor() throws SQLException,NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Diga el autor del cual quiera eliminar los libros, poniendo nombre y apellido entre comillas: ");

        String autor = bufferedReader.readLine();

        String orden = "DELETE FROM libros WHERE autor = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(orden);

        preparedStatement.setString(1, autor);

        int registroElim = preparedStatement.executeUpdate();

        if (registroElim > 0) {
            System.out.println("Se ha/n eliminado el/los libro/s.");
        } else {
            System.out.println("No se pudo/pudieron eliminar.");
        }
        preparedStatement.close();
    }
}
