import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {

    private Connection connection;

    public DBController(Connection connection) {
        this.connection = connection;
    }

    public void borrarTablas() throws SQLException {
        Statement statement = connection.createStatement();

        String[] tablas = {"Libros", "Temas"};

        for (String tabla : tablas) {
            String orden = "DROP TABLE IF EXISTS " + tabla;
            statement.executeUpdate(orden);
            System.out.println("La tabla " + tabla + " ha sido borrada.");
        }

        statement.close();
    }

    public void crearTablaLibros() throws SQLException {
        String orden = "CREATE TABLE IF NOT EXISTS Libros (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    tema_id VARCHAR(255),\n" +
                "    titulo VARCHAR(255),\n" +
                "    autor VARCHAR(255),\n" +
                "    titulo_resumen VARCHAR(255),\n" +
                "    resumen TEXT,\n" +
                "    FOREIGN KEY (tema_id) REFERENCES Temas(nombre_tema)\n" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(orden);

        System.out.println("Se ha creado la tabla Libros.");

        statement.close();
    }

    public void crearTablaTemas() throws SQLException {
        String orden = "CREATE TABLE IF NOT EXISTS Temas (\n" +
                "    nombre_tema VARCHAR(255) PRIMARY KEY\n" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(orden);

        System.out.println("Se ha creado la tabla Temas.");

        statement.close();
    }


    public void poblarTablaLibros() throws SQLException, CsvValidationException, IOException {
        CSVReader csvR = new CSVReader(new FileReader("resources/temas_y_libros.csv"));

        String[] nextLine;
        String ordenInsertarLibro = "INSERT INTO Libros (titulo, autor, titulo_resumen, resumen, tema_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(ordenInsertarLibro);

        while ((nextLine = csvR.readNext()) != null) {
            String tema_id = nextLine[0];
            String titulo = nextLine[1];
            String autor = nextLine[2];
            String titulo_resumen = nextLine[3];
            String resumen = nextLine[4];

            preparedStatement.setString(1, tema_id);
            preparedStatement.setString(2, titulo);
            preparedStatement.setString(3, autor);
            preparedStatement.setString(4, titulo_resumen);
            preparedStatement.setString(5, resumen);


            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        csvR.close();
        preparedStatement.close();
    }

    public void poblarTablaTemas() throws CsvValidationException, IOException, SQLException {
        CSVReader csvR = new CSVReader(new FileReader("resources/temas_y_libros.csv"));

        String[] siguienteLinea;
        String ordenInsertarTema = "INSERT INTO Temas (nombre_tema) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(ordenInsertarTema);

        while ((siguienteLinea = csvR.readNext()) != null) {
            // Asigna valores desde el archivo CSV
            String nombre_tema = siguienteLinea[0];

            preparedStatement.setString(1, nombre_tema);

            preparedStatement.executeUpdate();
        }

        csvR.close();
        preparedStatement.close();
    }

}
