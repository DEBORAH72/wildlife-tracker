package models;
import org.sql2o.*;
import org.junit.rules.ExternalResource;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test","moringa", "c3l12i9f6f6");
    }
    @Override
    protected void after() {
        try (Connection con = Database.sql2o.open()) {
            String deleteSighting = "DELETE FROM sightings *;";
            String deleteEndangered = "DELETE FROM endangered_animals *;";
            String deleteAnimal = "DELETE FROM animals *;";
            con.createQuery(deleteAnimal).executeUpdate();
            con.createQuery(deleteEndangered).executeUpdate();
            con.createQuery(deleteSighting).executeUpdate();
        }
    }
}