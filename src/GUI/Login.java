package GUI;

import java.sql.*;
import java.util.logging.*;

public final class Login {

    private boolean success;
    private final String actor;
    private final String username;
    private final String password;
    private Connection c;
    private Statement stmt;
    private final String jdbcpostgres = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/Billing";
    private final String dbuser = "postgres";
    private final String dbpassword = "nepal123";
    private final String usernamecol;

    public Login(String actor, String username, String password) {

        this.actor = actor;
        this.username = username;
        this.password = password;
        if (actor.equals("admin")) {
            usernamecol = "adminusername";
        } else {
            usernamecol = "username";
        }
        checkCredentials();
    }

    boolean successful() {
        return success;
    }

    void checkCredentials() {
        try {
            Class.forName(jdbcpostgres);
            c = DriverManager.getConnection(url, dbuser, dbpassword);
            String sql = "SELECT password FROM " + actor + " WHERE " + usernamecol + "  =\'" + username + "\';";
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
//                    System.out.println(rs.getString("password"));
                    success = password.equals(rs.getString("password"));
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
