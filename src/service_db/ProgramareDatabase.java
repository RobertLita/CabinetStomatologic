package service_db;

import entitate.programare.Programare;
import entitate.programare.Tratament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramareDatabase implements CRUD<Programare>{
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS programari" +
                "(programare_id int PRIMARY KEY AUTO_INCREMENT, zi int , luna int, an int, ora int, minut int, " +
                "subiect varchar(50), pacient_id int, doctor_id int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void create(Programare p) {
        String query = "INSERT INTO programari (zi, luna, an, ora, minut, subiect, pacient_id, doctor_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, p.getData().DAY_OF_WEEK);
            pstm.setInt(2, p.getData().MONTH);
            pstm.setInt(3, p.getData().YEAR);
            pstm.setInt(4, p.getData().HOUR_OF_DAY);
            pstm.setInt(5, p.getData().MINUTE);
            pstm.setString(6, p.getSubiect());
            pstm.setInt(7, p.getPacient().getPacient_id());
            pstm.setInt(8, p.getPacient().getDoctor().getDoctor_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Programare> read() {
        String query = "SELECT * FROM programari";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Programare> lp = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            stm.close();
            while(rs.next()){
                Programare p = new Programare();
                p.setProgramare_id(rs.getInt(1));
                p.setData(rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
                p.setSubiect(rs.getString(7));
                p.setPacient(PacientDatabase.readAt(rs.getInt(8)));
                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }

    @Override
    public void update(Programare p) {
        String query = "UPDATE programari SET zi = ?, luna = ?, an = ?, ora = ?, minut = ?, subiect = ?, pacient_id = ?," +
                " doctor_id = ? WHERE programare_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, p.getData().DAY_OF_WEEK);
            pstm.setInt(2, p.getData().MONTH);
            pstm.setInt(3, p.getData().YEAR);
            pstm.setInt(4, p.getData().HOUR_OF_DAY);
            pstm.setInt(5, p.getData().MINUTE);
            pstm.setString(6, p.getSubiect());
            pstm.setInt(7, p.getPacient().getPacient_id());
            pstm.setInt(8, p.getPacient().getDoctor().getDoctor_id());
            pstm.setInt(9, p.getProgramare_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Programare readAt(int index) {
        String query = "SELECT * FROM programari WHERE programare_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Programare p = new Programare();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            p.setProgramare_id(rs.getInt(1));
            p.setData(rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            p.setSubiect(rs.getString(7));
            p.setPacient(PacientDatabase.readAt(rs.getInt(8)));
            p.setProgramare_id(rs.getInt(9));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public void delete(int index) {
        String query = "DELETE FROM programari WHERE programare_id = " + index;
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
