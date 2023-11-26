package projectmvc.DAO;

import projectmvc.koneksi.koneksi;
import projectmvc.model.mahasiswa;
import projectmvc.DAOImplement.implementMahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Muhammad 'Arda Rizqy Fauzan
 */
public class daoMahasiswa implements implementMahasiswa{
    
    Connection connection;
    final String insert = "INSERT INTO tblmahasiswa (nim, nama, kelas, uts, uas) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE tblmahasiswa set nim=?, nama=?, kelas=?, uts=?, uas=? where id=? ;";
    final String delete = "DELETE FROM tblmahasiswa where id=? ;";
    final String select = "SELECT * FROM tblmahasiswa;";
    final String carinama = "SELECT * FROM tblmahasiswa where nama like ?";
    
    public daoMahasiswa() {
        connection = koneksi.connection();
    }

    public void insert(mahasiswa b) {
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, b.getNim());
        statement.setString(2, b.getNama());
        statement.setString(3, b.getKelas());
        statement.setString(4, b.getUTS());
        statement.setString(5, b.getUAS());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            b.setId(rs.getInt(1));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    public void update(mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getKelas());
            statement.setString(4, b.getUTS());
            statement.setString(5, b.getUAS());
            statement.setInt(6, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<mahasiswa> getALL() {
        List<mahasiswa> lb = null;
        try {
            lb = new ArrayList<mahasiswa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                mahasiswa b = new mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setUTS(rs.getString("uts"));
                b.setUAS(rs.getString("uas"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    public List<mahasiswa> getCariNama(String nama) {
        List<mahasiswa> lb = null;
        try {
            lb = new ArrayList<mahasiswa>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mahasiswa b = new mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setUTS(rs.getString("uts"));
                b.setUAS(rs.getString("uas"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
