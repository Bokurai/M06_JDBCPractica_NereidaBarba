import java.sql.Connection;

public class TemaController {
    private Connection connection;

    public TemaController(Connection connection){
        this.connection = connection;
    }
}