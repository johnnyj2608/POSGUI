import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuAccess {

    private static Connection connection;
    private static PreparedStatement Pstatement;
    private static ResultSet resultSet;
    
    public static ArrayList<MenuSizes> getItemSizes(String item) {
        connection = DBConnection.getConnection();
        ArrayList<MenuSizes> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT * FROM sizes WHERE item = (?)");
            Pstatement.setString(1, item);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                MenuSizes entry = new MenuSizes(resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(3), 
                        resultSet.getDouble(4), resultSet.getDouble(5));
                food.add(entry);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<Integer> getItemAmt(String item) {
        connection = DBConnection.getConnection();
        ArrayList<Integer> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT amt FROM menu WHERE item = (?)");
            Pstatement.setString(1, item);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                food.add(resultSet.getInt(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static int updateItem(int amount, String item) {
        connection = DBConnection.getConnection();
        int count = 0;
        try {
            Pstatement = connection.prepareStatement("UPDATE menu SET amt = (?) where item = (?)");
            Pstatement.setInt(1, amount);
            Pstatement.setString(2, item);
            count = Pstatement.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }
    
    public static ArrayList<MenuSource> getAllFromCateg(String categ) {
        connection = DBConnection.getConnection();
        ArrayList<MenuSource> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT * FROM menu WHERE categ = (?)");
            Pstatement.setString(1, categ);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                MenuSource entry = new MenuSource(resultSet.getInt(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
                food.add(entry);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<String> getAllCateg() {
        connection = DBConnection.getConnection();
        ArrayList<String> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT categ FROM menu GROUP BY categ ORDER BY min(item_id)");
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                food.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<String> getItemCateg(String item) {
        connection = DBConnection.getConnection();
        ArrayList<String> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT categ FROM menu where item = (?)");
            Pstatement.setString(1, item);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                food.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<MenuSides> getSidePrices(String item) {
        connection = DBConnection.getConnection();
        ArrayList<MenuSides> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT * FROM sides where item = (?)");
            Pstatement.setString(1, item);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                MenuSides entry = new MenuSides(resultSet.getString(1), resultSet.getDouble(2),
                        resultSet.getDouble(3), resultSet.getDouble(4));
                food.add(entry);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<String> getAllSides() {
        connection = DBConnection.getConnection();
        ArrayList<String> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT item FROM sides");
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
                food.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
    
    public static ArrayList<MenuSource> getItemHalves(String item) {
        connection = DBConnection.getConnection();
        ArrayList<MenuSource> food = new ArrayList<>();
        try {
            Pstatement = connection.prepareStatement("SELECT * FROM menu where item = (?)");
            Pstatement.setString(1, item);
            resultSet = Pstatement.executeQuery();
            
            while(resultSet.next()) {
               MenuSource entry = new MenuSource(resultSet.getInt(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
                food.add(entry);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return food;
    }
}
