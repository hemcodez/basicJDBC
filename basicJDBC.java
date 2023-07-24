import java.sql.*;

public class basicJDBC {

    // -- Main method connects to the database and retrieves a result set
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // -- Try catch block to catch any database exceptions
        try {

            // -- Create a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "admin");

            // -- Create a new SQL statement using the connection
            Statement stmt = con.createStatement();

            // Execute the SQL statement to retrieve a result set of records from the database
            ResultSet rs = stmt.executeQuery("select * from categories"); // -> Retrieves all the records in the categories table

            // -- Use a while loop to iterate through the result set of records
            while (rs.next()){

                // -- Print out the data in each of the columns in the current record
                // - The first column contains an integer, so we are calling the getInt method
                // - The remaining columns are text values, so we are calling the getString method
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

            } //END WHILE LOOP

            // Insert a record in the database
            stmt.executeUpdate("INSERT INTO CATEGORIES (categoryID, categoryName, Description) VALUES (20, \"Paper Products\", \"Paper plates and napkins\")");

            // -- Execute the SQL statement to retrieve a result set of records from the database
            rs = stmt.executeQuery("select * from categories"); // -> This SQL query will retrieve all the records in the categories table

            // -- Use a while-loop to iterate through the result set of records
            while (rs.next()){

                // -- Print out the data in each of the columns in the current record
                // - The first column contains an integer, so we are calling the getInt method
                // - The remaining three columns are text values, so we are calling the getString method
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getString(3) + " "
                        + rs.getString(4));
            } //END WHILE LOOP


            // -- Update the record in the database
            stmt.executeUpdate("UPDATE CATEGORIES SET Description = \"Paper plates, towels, and napkins\" WHERE CategoryID = 20;");


            // -- Execute the SQL statement to retrieve a result set of records from the database
            rs = stmt.executeQuery("select * from categories"); // -> This SQL query will retrieve all the records in the categories table

            // -- Use a while-loop to iterate through the result set of records
            while (rs.next()){

                // -- Print out the data in each of the columns in the current record
                // - The first column contains an integer, so we are calling the getInt method
                // - The remaining three columns are text values, so we are calling the getString method
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getString(3) + " "
                        + rs.getString(4));
            } //END WHILE LOOP

            // -- Delete a record from the database
            stmt.executeUpdate("DELETE FROM CATEGORIES WHERE CategoryID = 20;");

            // -- Execute the SQL statement to retrieve a result set of records from the database
            rs = stmt.executeQuery("select * from categories"); // -> This SQL query will retrieve all the records in the categories table

            // -- Use a while-loop to iterate through the result set of records
            while (rs.next()){

                // -- Print out the data in each of the columns in the current record
                // - The first column contains an integer, so we are calling the getInt method
                // - The remaining three columns are text values, so we are calling the getString method
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getString(3) + " "
                        + rs.getString(4));
            } //END WHILE LOOP

            // -> Close the connection to the database
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        } //END TRY CATCH








    } //END MAIN

} //END CLASS
