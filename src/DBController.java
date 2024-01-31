import java.sql.Connection;

public class DBController {

    private Connection connection;

    public DBController(Connection connection){
        this.connection = connection;
    }
}
