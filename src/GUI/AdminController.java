package GUI;

import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import jdk.nashorn.internal.runtime.logging.Loggable;

class AdminController {

    private final String url = "jdbc:postgresql://localhost:5432/Billing";
    private final String user = "postgres";
    private final String password = "nepal123";
    String driver = "org.postgresql.Driver";
//    private Connection con;
//    private Statement stat;

    String[] getCounterPeople() {
        return result("counterperson");
    }

    String[] getManagers() {
        return result("manager");
    }

    String[] result(String actor) {
        List dbResult = new ArrayList<>();
        String s = null;

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                con.setAutoCommit(false);
                System.out.println("The database is opened successfully.");
                String sql = "SELECT username FROM " + actor + ";";
                try (ResultSet rs = stat.executeQuery(sql)) {
                    while (rs.next()) {
                        s = rs.getString(1);
                        System.out.println("Direct print " + s);
                        dbResult.add(s);
                    }
                    con.close();
                    stat.close();
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(this.getClass()).log(Level.SEVERE, "Exception in AdminController", ex);
        }
        String[] arrayResult = new String[dbResult.size()];
        dbResult.toArray(arrayResult);
        return arrayResult;
    }

    public static void main(String[] args) {
        AdminController a = new AdminController();
        System.out.println("Managers: ");
        for (String ar : a.getManagers()) {
            System.out.println(ar);
        }

        System.out.println("Counterpeople: ");
        for (String ar : a.getCounterPeople()) {
            System.out.println(ar);
        }
        a.addRole("manager", "newman3", "newpass");
    }

    void addRole(String actor, String username, String newpassword) {
        try {
            Class.forName(driver);
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                con.setAutoCommit(false);
                System.out.println("The database is opened successfully.");
                String sql = "INSERT INTO " + actor + " (username,password) VALUES(\'" + username + "\',\'" + newpassword + "')";
                stat.executeUpdate(sql);
                con.commit();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(this.getClass()).log(Level.SEVERE, "Exception in AdminController", ex);
        }
    }

    void editRole(String actor, String findUsername, String newUserName) {
        try {
            Class.forName(driver);
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                con.setAutoCommit(false);
                System.out.println("The database is opened successfully.");
                String sql = "UPDATE " + actor + " SET username=\'" + newUserName + "\' WHERE username=\'" + findUsername + "\';";
                stat.executeUpdate(sql);
                con.commit();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(this.getClass()).log(Level.SEVERE, "Exception in AdminController in editing", ex);
        }
    }

    void changePassword(String actor, String username, String newPassword) {
        try {
            Class.forName(driver);
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                con.setAutoCommit(false);
                System.out.println("The database is opened successfully for editing.");
                String sql = "UPDATE " + actor + " SET password=\'" + newPassword + "\' WHERE username=\'" + username + "\';";
                stat.executeUpdate(sql);
                con.commit();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(this.getClass()).log(Level.SEVERE, "Exception in AdminController in editing", ex);
        }
    }

    void deleteRole(String actor, String username) {
        try {
            Class.forName(driver);
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                con.setAutoCommit(false);
                System.out.println("The database is opened successfully for deleting.");
                String sql = "DELETE FROM " + actor + " WHERE username=\'" + username + "\';";
                stat.executeUpdate(sql);
                con.commit();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(this.getClass()).log(Level.SEVERE, "Exception in AdminController in deleting", ex);
        }
    }

}
