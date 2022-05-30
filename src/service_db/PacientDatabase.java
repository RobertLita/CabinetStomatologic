package service_db;

import entitate.personal.Pacient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDatabase implements CRUD<Pacient>{

    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS pacienti" +
                "(pacient_id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), prenume varchar(30), cnp varchar(15), " +
                "doctor_id int, tratament_id int, totalPlata int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void create(Pacient p) {
        String query = "INSERT INTO pacienti (nume, prenume, cnp, doctor_id, tratament_id, totalPlata) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, p.getNume());
            pstm.setString(2, p.getPrenume());
            pstm.setString(3, p.getCnp());
            pstm.setInt(4, p.getDoctor().getDoctor_id());
            pstm.setInt(5, p.getTratament().getTratament_id());
            pstm.setInt(6, p.getTotalPlata());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pacient> read(){
        String query = "SELECT * FROM pacienti";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Pacient> lp = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pacient p = new Pacient();
                p.setPacient_id(rs.getInt(1));
                p.setNume(rs.getString(2));
                p.setPrenume(rs.getString(3));
                p.setCnp(rs.getString(4));
                p.setTratament(TratamentDatabase.readAt(rs.getInt(5)));
                p.setDoctor(DoctorDatabase.readAt(rs.getInt(6)));
                p.setTotalPlata(rs.getInt(7));
                lp.add(p);
            }
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }

    public static Pacient readAt(int index) {
        String query = "SELECT * FROM pacienti WHERE pacient_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Pacient p = new Pacient();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            p.setPacient_id(rs.getInt(1));
            p.setNume(rs.getString(2));
            p.setPrenume(rs.getString(3));
            p.setCnp(rs.getString(4));
            p.setTratament(TratamentDatabase.readAt(rs.getInt(5)));
            p.setDoctor(DoctorDatabase.readAt(rs.getInt(6)));
            p.setTotalPlata(rs.getInt(7));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void update(Pacient p) {
        String query = "UPDATE pacienti SET nume = ?, prenume = ?, cnp = ?, doctor_id = ?, tratament_id = ?, " +
                "totalPlata = ? WHERE pacient_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, p.getNume());
            pstm.setString(2, p.getPrenume());
            pstm.setString(3, p.getCnp());
            pstm.setInt(4, p.getDoctor().getDoctor_id());
            pstm.setInt(5, p.getTratament().getTratament_id());
            pstm.setInt(6, p.getTotalPlata());
            pstm.setInt(7, p.getPacient_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM pacienti WHERE pacient_id = " + index;
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
