package ke.co.safaricom;

import java.sql.Timestamp;
import java.util.List;
import org.sql2o.Connection;

public class Sighting implements DatabaseManagement {
    // Rest of the class remains the same...
    //...

    //update the Sightings table && throwing an exception in case the id is not mapped
    public void update() {
        String sql = "UPDATE sightings SET location = :location, ranger_name = :ranger_name WHERE id = :id";

        try (Connection con = DB.sql2o.open()) {
            Object location;
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("ranger_name", ranger_name) // Corrected parameter name here
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

}
