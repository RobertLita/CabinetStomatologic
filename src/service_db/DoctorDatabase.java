package service_db;

import entitate.personal.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDatabase implements CRUD<Doctor>{
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS doctori" +
                "(doctor_id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), prenume varchar(30), cnp varchar(15), " +
                "salariu double, nota double, nrPacienti int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void create(Doctor d) {
        String query = "INSERT INTO doctori (nume, prenume, cnp, salariu, nota, nrPacienti) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, d.getNume());
            pstm.setString(2, d.getPrenume());
            pstm.setString(3, d.getCnp());
            pstm.setDouble(4, d.getSalariu());
            pstm.setDouble(5, d.getNota());
            pstm.setInt(6, d.getNrPacienti());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> read() {
        String query = "SELECT * FROM doctori";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Doctor> ld = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Doctor d = new Doctor();
                d.setDoctor_id(rs.getInt(1));
                d.setNume(rs.getString(2));
                d.setPrenume(rs.getString(3));
                d.setCnp(rs.getString(4));
                d.setSalariu(rs.getDouble(5));
                d.setNota(rs.getDouble(6));
                d.setNrPacienti(rs.getInt(7));
                ld.add(d);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ld;
    }

    public static Doctor readAt(int index) {
        String query = "SELECT * FROM doctori WHERE doctor_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Doctor d = new Doctor();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            d.setDoctor_id(rs.getInt(1));
            d.setNume(rs.getString(2));
            d.setPrenume(rs.getString(3));
            d.setCnp(rs.getString(4));
            d.setSalariu(rs.getDouble(5));
            d.setNota(rs.getDouble(6));
            d.setNrPacienti(rs.getInt(7));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void update(Doctor d) {
        String query = "UPDATE doctori SET nume = ?, prenume = ?, cnp = ?, salariu = ?, nota = ?, nrPacienti = ? WHERE doctor_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, d.getNume());
            pstm.setString(2, d.getPrenume());
            pstm.setString(3, d.getCnp());
            pstm.setDouble(4, d.getSalariu());
            pstm.setDouble(5, d.getNota());
            pstm.setInt(6, d.getNrPacienti());
            pstm.setInt(7, d.getDoctor_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        String query = "DELETE FROM doctori WHERE doctor_id = " + index;
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
