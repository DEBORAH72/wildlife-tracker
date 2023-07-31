package ke.co.safaricom;

package models;

import org.sql2o.Sql2o;

public class Database {
    // DEVELOPMENT DATABASE
    private static String testConnectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
    private static String testUser = "moringa";
    private static String testPassword = "c3l12i9f6f6";
    public static Sql2o sql2o = new Sql2o( testConnectionString, testUser, testPassword);// Comment this out if you are testing your app locally

    // PRODUCTION DATABASE
    private static String connectionString = "jdbc:postgresql://ec2-23-21-109-177.compute-1.amazonaws.com:5432/daatktuv7q3olc";
    private static String user = "hwrzcoarkmchix";
    private static String password = "3b4b0dfebd02a0a980b55c240a7d5f422022842758405b2d910202784f170e69";
//    public static Sql2o sql2o = new Sql2o(connectionString,user,password);
}