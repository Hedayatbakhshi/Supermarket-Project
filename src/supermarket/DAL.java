package supermarket;

import java.sql.*;

public class DAL {
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs; 

    public DAL() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/supermarket", "root", "");
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            Helper.Tools.show("Database connection error.");
            e.printStackTrace(); // For debugging during development
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement pst = con.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException e) {
            Helper.Tools.show("Error executing query.");
            e.printStackTrace();
            return null;
        }
    }

    public boolean execute(String query) {
        try (PreparedStatement pst = con.prepareStatement(query)) {
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            Helper.Tools.show("Execution failed.");
            e.printStackTrace();
            return false;
        }
    }

    // ✅ This allows access to the connection for PreparedStatements
    public Connection getConnection() {
        return con;
    }

    public void close() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Object[][] select (String command){
        
       try {
        PreparedStatement pst = con.prepareStatement(command); // ✅ create the statement here
        rs = pst.executeQuery(); // ✅ no need to pass the query again

        rs.last();
        int totalRow = rs.getRow();
        rs.beforeFirst();

        int totalColumn = rs.getMetaData().getColumnCount();
        Object[][] data = new Object[totalRow][totalColumn]; // ✅ fix: totalRow, not totalColumn

        int y = 0;
        while (rs.next()) {
            for (int x = 0; x < totalColumn; x++) {
                data[y][x] = rs.getObject(x + 1); // ✅ JDBC column indices start from 1
            }
            y++;
        }

        return data;

    } catch (Exception ex) {
        System.out.println("Select Error: " + ex.getMessage());
        return null;
    }
                
        
    }
}








