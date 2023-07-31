package ke.co.safaricom;

import org.sql2o.Sql2o;
import java.net.URI;
import java.net.URISyntaxException;

public class DB {
    private static Sql2o sql2o;

    static {
        try {
            String databaseUrl = System.getenv("DATABASE_URL");

            if (databaseUrl == null) {
                // If the DATABASE_URL environment variable is not set, use the local database URL.
                databaseUrl = "jdbc:postgresql://localhost:5432/wildlife_tracker";
            }

            URI dbUri = new URI(databaseUrl);

            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "alpha" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "pw*0711937973" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e) {
            // Handle any URISyntaxException that might occur during URI parsing.
            e.printStackTrace();
        }
    }

    public static Sql2o getSql2o() {
        return sql2o;
    }
}
