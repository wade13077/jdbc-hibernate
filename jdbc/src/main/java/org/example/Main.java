package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
         */

        // ---connect setting
        // postgres
        // String url = "jdbc:postgresql://localhost:5432/demo";
        // String uname = "postgres";
        // String pass = "6031";

        // mysql
        String url = "jdbc:mysql://localhost:3306/mydb"; // MySQL 使用 3306 port
        String uname = "root";
        String pass = "123456";


        // ---SQL
        String sql = "SELECT * FROM address";
        // String usql = "delete from student where sid = 5";
        int aId = 6;
        String address = "test";
        int mId = 2;
        String aAddress = "atest";
        String isql = "INSERT INTO address (aId, address, mId, aAddress) VALUES ("
                + aId + ", '" + address + "', " + mId + ", '" + aAddress + "')";

        String isql2 = "INSERT INTO address VALUES (?,?,?,?)";
        //---SQL END

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();

        // ---do query
        ResultSet rs = st.executeQuery(sql);
        // rs.next();
        // String name = rs.getString("address");
        // System.out.println("Name of a student is " + name);

        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }

        // ---do update
        // st.execute(usql);

        // ---do insert
        // isql
        st.execute(isql);

        // isql2
        PreparedStatement st2 = con.prepareStatement(isql2);
        st2.setInt(1, 7);
        st2.setString(2, "test2");
        st2.setInt(3, 2);
        st2.setString(4, "atest2");
        st2.execute();


        con.close();
        System.out.println("Connection closed");

    }
}
