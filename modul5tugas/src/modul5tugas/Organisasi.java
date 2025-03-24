/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

/**
 *
 * @author Taofik Dimas
 */
public class Organisasi {
     private int id;  // Ini tetap ada, tapi tidak diisi manual
    private String nama;
    private String jenis;


    // Konstruktor lengkap (kalau perlu digunakan untuk menampilkan data dari database)
    public Organisasi(int id, String nama, String jenis) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
    }
    
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    @Override
public String toString(){
return nama;
}
public Organisasi(String nama, String jenis) {
    this.nama = nama;
    this.jenis = jenis;
}

}
