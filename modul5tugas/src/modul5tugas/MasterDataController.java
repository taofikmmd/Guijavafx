/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

import java.net.URL;

import java.util.List;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Taofik Dimas
 */
public class MasterDataController implements Initializable{
    @FXML
    private TableView<Kota> tblKota;
    
    @FXML
    private Button btnMasterData;
    
    @FXML private Button btnAddKot;
    
    @FXML private Button btnUpKot;
    
    @FXML private Button btnDelKot;
    
    @FXML private TextField txtNamaKota;
    
    @FXML
    private TableColumn<Kota, Integer> collId;
    
    @FXML
    private TableColumn<Kota, String> collKota;
  //    Organisasi 
    @FXML
    private TableView<Organisasi> tblOrganisasi;
  
    @FXML
    private TableColumn<Organisasi, String> collIdOr;

    @FXML
    private TableColumn<Organisasi, String> collNamaOr;
      @FXML
    private TableColumn<Organisasi, String> collJenisOr;
    
    @FXML
    private Button btnAddOr;
    
     @FXML
    private Button btnUpOr;
     
     @FXML
    private Button btnDelOr;
    
    
    @FXML
    private ToggleGroup groupOrganisasi;
    
    @FXML
    private RadioButton radioOrFak;
    
    @FXML
    private RadioButton radioOrPro;
    
    @FXML
    private RadioButton radioOrUn;
    
    
    @FXML
    private TextField txtOrganisasi; 
    // ANGGOTA
     @FXML
    private TableView<Anggota> tblAggt;
  
    @FXML
    private TableColumn<Anggota, String> collIdAgt;

    @FXML
    private TableColumn<Anggota, String> collNamaAgt;
      @FXML
    private TableColumn<Anggota, String> collJenisAgt;
       @FXML
    private TableColumn<Organisasi, String> collOrgAgt;
    
    @FXML
    private Button btnAddAgt;
    
     @FXML
    private Button btnUpAgt;
     
     @FXML
    private Button btnDelAgt;
    
    
    @FXML
    private ToggleGroup jk;
    @FXML
    private ToggleGroup Jenis;
    
    @FXML
    private RadioButton radio1;
    
    @FXML
    private RadioButton radio2;
    
    @FXML
    private RadioButton radio3;
    
    @FXML
    private RadioButton jkl;
    
    @FXML
    private RadioButton jkp;
    
    @FXML private ComboBox<Kota> cbxKota;
    
    @FXML private ComboBox<Organisasi> cbxOrg;
    
    @FXML
    private TextField txtNamaAgt; 
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtAlamat; 
    
    @FXML
    private TextField txtTelepon;
    
    @FXML private DatePicker tglDaftar;
    @FXML
    private void handleButtonMasterAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("MasterData.fxml");
    }
    //KODE ORGANISASI
    private void loadDataOrganisasi(){
        
       ObservableList<Organisasi> organisasiList = OrganisasiDAO.getOrganisasi();
        
        tblOrganisasi.setItems(organisasiList);
        cbxOrg.setItems(organisasiList);
    }
    //SELECT
    private Organisasi selectedOrganisasi;
    
     // CLEARFIELDS
       private void clearFieldsO(){
        txtOrganisasi.clear();
        selectedOrganisasi = null;
    }
       
       //SELECT ORGANISASI
        private void selectOrganisasi(Organisasi organisasi){
        if (organisasi != null) {
            selectedOrganisasi = organisasi;
            txtOrganisasi.setText(organisasi.getNama());
        }
    }
       //ADD ORGANISASI
        @FXML
    private void addOrganisasi(){
        
        String nama = txtOrganisasi.getText();
        String jenis = ((RadioButton) groupOrganisasi.getSelectedToggle()).getText(); 
       
        if (nama.isEmpty()) {
             showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        Organisasi newOrganisasi = new Organisasi(nama, jenis);
        OrganisasiDAO.addOrganisasi(newOrganisasi);
        loadDataOrganisasi();
        clearFieldsO();
    }
    //UPDATE
     @FXML
    private void updateOrganisasi() {
        if (selectedOrganisasi == null){
            showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        String nama = txtOrganisasi.getText();
        String jenis = ((RadioButton) groupOrganisasi.getSelectedToggle()).getText(); 
        
        if (nama.isEmpty()) { 
            showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        selectedOrganisasi.setNama(nama);
        selectedOrganisasi.setJenis(jenis);
        
        OrganisasiDAO.updateOrganisasi(selectedOrganisasi);
        loadDataOrganisasi();
        clearFieldsO();
        
    }
    
      @FXML
    private void deleteOrganisasi() {
        if (selectedOrganisasi == null) {
       showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
         
        OrganisasiDAO.deleteOrganisasi(selectedOrganisasi.getNama());
        loadDataOrganisasi();
        clearFieldsO();
    }
     @FXML
    public int getSelectedOrganisasiId() {
        Organisasi selectedOrganisasi = cbxOrg.getSelectionModel().getSelectedItem();
        return selectedOrganisasi != null ? selectedOrganisasi.getId() : -1;
    }
    
    // KODE KOTA
     private void loadDataKota(){
        
        ObservableList<Kota> kotaList = KotaDAO.getKota();
        
        tblKota.setItems(kotaList);
        cbxKota.setItems(kotaList);
    }
     // CLEARFIELDS
       private void clearFields(){
        txtNamaKota.clear();
        selectedKota = null;
    }
       //ALERT
        private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        //SELECT KOTA
      private void selectKota(Kota kota){
        if (kota != null) {
            selectedKota = kota;
            txtNamaKota.setText(kota.getNama());
        }
    }
    private Kota selectedKota;
    //ADD KOTA
    @FXML
    private void addKota(){
        
        String nama = txtNamaKota.getText();
       
        if (nama.isEmpty()) {
             showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        Kota newKota = new Kota(nama);
        KotaDAO.addKota(newKota);
        loadDataKota();
        clearFields();
    }
    //UPDATE
     @FXML
    private void updateKota() {
        if (selectedKota == null){
            showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        String nama = txtNamaKota.getText();
        
        if (nama.isEmpty()) { 
            showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        selectedKota.setNama(nama);
        
        KotaDAO.updateKota(selectedKota);
        loadDataKota();
        clearFields();
        
    }
    
    @FXML
    private void deleteKota() {
        if (selectedKota == null) {
       showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
         
        KotaDAO.deleteKota(selectedKota.getNama());
        loadDataKota();
        clearFields();
    }
    @FXML
    public int getSelectedKotaId() {
        Kota selectedKota = cbxKota.getSelectionModel().getSelectedItem();
        return selectedKota != null ? selectedKota.getId() : -1;
    }
    //KODE ANGGOTA
    
      private void loadDataAnggota(){
        
        ObservableList<Anggota> anggotaList = AnggotaDAO.getAnggota();
        
        tblAggt.setItems(anggotaList);
    }
      
     // CLEARFIELDS
       private void clearFieldsAgt(){
        txtNamaKota.clear();
        selectedKota = null;
       }
       
       private void selectAnggota(Anggota anggota){
        if (anggota != null) {
            selectedAnggota = anggota;
            txtNamaAgt.setText(anggota.getNama());
        }
    }
       private Anggota selectedAnggota;
       
        @FXML
    private void addAnggota(){
        
        String nama = txtNamaAgt.getText();
        String jenis = ((RadioButton) Jenis.getSelectedToggle()).getText(); 
         String  jenis_kelamin = ((RadioButton) jk.getSelectedToggle()).getText();
         String alamat = txtAlamat.getText();
         String telepon = txtTelepon.getText();
         LocalDate tanggal_daftar = tglDaftar.getValue();
         String email = txtEmail.getText();
        int id_kota = Integer.parseInt(cbxKota.getValue().getNama());
        int id_organisasi = Integer.parseInt(cbxOrg.getValue().getNama());

       
        if (nama.isEmpty()) {
             showAlert("input error", "Field Tidak boleh kosong!");
            return;
        }
        
        Anggota newAnggota = new Anggota(nama, jenis, alamat, id_kota, telepon, email, tanggal_daftar.toString(), jenis_kelamin, id_organisasi);
        AnggotaDAO.addAnggota(newAnggota);
        loadDataAnggota();
        clearFieldsAgt();
    }
   
@Override
public void initialize(URL url, ResourceBundle rb) {
        // TODO
    collKota.setCellValueFactory(new PropertyValueFactory<>("nama"));
    
    loadDataKota();
    
    tblKota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectKota(newValue)
    );
    
    collNamaOr.setCellValueFactory(new PropertyValueFactory<>("nama"));
    collJenisOr.setCellValueFactory(new PropertyValueFactory<>("jenis"));

        loadDataOrganisasi();
        
        tblOrganisasi.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectOrganisasi(newValue)
        );
        
         
    collNamaAgt.setCellValueFactory(new PropertyValueFactory<>("nama"));
    collJenisAgt.setCellValueFactory(new PropertyValueFactory<>("jenis"));
    collOrgAgt.setCellValueFactory(new PropertyValueFactory<>("organisasi"));
    
    loadDataAnggota();
        tblAggt.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectAnggota(newValue)
        );
    }   

    
}
