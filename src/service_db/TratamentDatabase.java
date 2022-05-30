package service_db;

import entitate.programare.Tratament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TratamentDatabase implements CRUD<Tratament>{

    @Override
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS tratamente" +
                "(tratament_id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), durata int, cost int, " +
                "recomandari varchar(70))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Tratament t) {
        String query = "INSERT INTO tratamente (nume, durata, cost, recomandari) " +
                "VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, t.getNume());
            pstm.setInt(2, t.getDurata());
            pstm.setInt(3, t.getCost());
            pstm.setString(4, t.getRecomandari());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tratament> read() {
        String query = "SELECT * FROM tratamente";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Tratament> lt = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Tratament t = new Tratament();
                t.setTratament_id(rs.getInt(1));
                t.setNume(rs.getString(2));
                t.setDurata(rs.getInt(3));
                t.setCost(rs.getInt(4));
                t.setRecomandari(rs.getString(5));
                lt.add(t);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lt;
    }

    public static Tratament readAt(int index) {
        String query = "SELECT * FROM tratamente WHERE tratament_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Tratament t = new Tratament();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            t.setTratament_id(rs.getInt(1));
            t.setNume(rs.getString(2));
            t.setDurata(rs.getInt(3));
            t.setCost(rs.getInt(4));
            t.setRecomandari(rs.getString(5));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void update(Tratament t) {
        String query = "UPDATE tratamente SET nume = ?, durata = ?, cost = ?, recomandari = ? WHERE tratament_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, t.getNume());
            pstm.setInt(2, t.getDurata());
            pstm.setInt(3, t.getCost());
            pstm.setString(4, t.getRecomandari());
            pstm.setInt(5, t.getTratament_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM tratamente WHERE tratament_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stm = connection.createStatement();
            stm.execute(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
