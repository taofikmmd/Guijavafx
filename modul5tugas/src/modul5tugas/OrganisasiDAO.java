/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Taofik Dimas
 */
public class OrganisasiDAO{
public static ObservableList<Organisasi> getOrganisasi(){
       
        ObservableList<Organisasi> organisasiList = FXCollections.observableArrayList();
        String query = "SELECT * FROM organisasi";
        
        try (
                Connection koneksi =DBConnection.getConnection();
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(query)
            ){
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String jenis = rs.getString("jenis");
                organisasiList.add(new Organisasi(
                    id,
                    nama,
                    jenis
                ));
                
                
                
            }
            rs.close();
                stmt.close();
                koneksi.close();
        }catch (SQLException e) {
            e.printStackTrace();
                    }
            return organisasiList;
    }
    public static void addOrganisasi(Organisasi organisasi) {
            String query = "INSERT INTO organisasi (nama, jenis) VALUES (?, ?)";
            
            try (
                 Connection koneksi = DBConnection.getConnection();
                 PreparedStatement smt = koneksi.prepareStatement(query)) {
                
                
                smt.setString(1, organisasi.getNama());
                smt.setString(2, organisasi.getJenis());
                
                smt.executeUpdate();
                
                smt.close();
                koneksi.close();
                
            } catch (SQLException e) {
                e.printStackTrace();     
        }
        }
      public static void updateOrganisasi(Organisasi organisasi){
            String query = "UPDATE organisasi SET nama = ?, jenis = ?  WHERE id = ?";
            
             try (
                 Connection koneksi = DBConnection.getConnection();
                 PreparedStatement smt = koneksi.prepareStatement(query)){
                 
                smt.setString(1, organisasi.getNama());
                smt.setString(2, organisasi.getJenis());
                smt.setInt(3, organisasi.getId());
                
                smt.executeUpdate();
                
                smt.close();
                koneksi.close();
                
             }catch (SQLException e) {
                e.printStackTrace();     
                }
        }
        public static void deleteOrganisasi(String nama) {
            String query = "DELETE FROM organisasi WHERE nama = ?";
            
              try (
                 Connection koneksi = DBConnection.getConnection();
                 PreparedStatement smt = koneksi.prepareStatement(query)){
                 
                smt.setString(1, nama);
                
                smt.executeUpdate();
                
                smt.close();
                koneksi.close();
             }catch (SQLException e) {
              e.printStackTrace();     
        }
        }
 
}
