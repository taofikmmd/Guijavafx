package modul5tugas;

import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnggotaDAO {
  
     public static ObservableList<Anggota> getAnggota() {
         
        ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();
        String query = "SELECT * FROM anggota";

        try (Connection koneksi = DBConnection.getConnection();
             Statement stmt = koneksi.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
                
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String jenis = rs.getString("jenis");
                String alamat = rs.getString("alamat");
                int id_kota = rs.getInt("id_kota");
                String telepon = rs.getString("telepon");
                String email = rs.getString("email");
                String tanggal_daftar = rs.getString("tanggal_daftar");
                String jenis_kelamin = rs.getString("jenis_Kelamin");
                int id_organisasi = rs.getInt("id_organisasi");
                anggotaList.add(new Anggota(
                    id,
                    nama,
                        jenis,
                        alamat,
                        id_kota,
                        telepon,
                        email,
                        tanggal_daftar,
                        jenis_kelamin,
                        id_organisasi
                ));
                
            }
              rs.close();
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anggotaList;
    }

    public static void addAnggota(Anggota anggota) {
        String query = "INSERT INTO anggota (nama, jenis, alamat, id_kota, telepon, email, tanggal_daftar, jenis_kelamin, id_organisasi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {
            smt.setString(1, anggota.getNama());
            smt.setString(2, anggota.getJenis());
            smt.setString(3, anggota.getAlamat());
            smt.setInt(4, anggota.getId_kota());
            smt.setString(5, anggota.getTelepon());
            smt.setString(6, anggota.getEmail());
            smt.setString(7, anggota.getTanggal_daftar());
            smt.setString(8, anggota.getJenis_kelamin());
            smt.setInt(9, anggota.getId_organisasi());

            smt.executeUpdate();
                
           smt.close();
                koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAnggota(Anggota anggota) {
        String query = "UPDATE anggota SET nama = ?, jenis = ?, alamat = ?, telepon = ?, tanggal_daftar = ?, jenis_Kelamin = ?, id_kota = ?, email = ?, id_organisasi = ? WHERE id = ?";

        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {

              smt.setString(1, anggota.getNama());
            smt.setString(2, anggota.getJenis());
            smt.setString(3, anggota.getAlamat());
            smt.setInt(4, anggota.getId_kota());
            smt.setString(5, anggota.getTelepon());
            smt.setString(6, anggota.getEmail());
            smt.setString(7, anggota.getTanggal_daftar());
            smt.setString(8, anggota.getJenis_kelamin());
            smt.setInt(9, anggota.getId_organisasi());


            smt.executeUpdate();
            smt.close();
                koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAnggota(int id) {
        String query = "DELETE FROM anggota WHERE id = ?";

        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {

            smt.setInt(1, id);
            smt.executeUpdate();
smt.close();
                koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

  