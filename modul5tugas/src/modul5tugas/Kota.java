/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

/**
 *
 * @author Taofik Dimas
 */
public class Kota {
    private int id;  // Ini tetap ada, tapi tidak diisi manual
    private String nama;

    // Konstruktor TANPA id (untuk auto-increment)
    public Kota(String nama) {
        this.nama = nama;
    }

    // Konstruktor lengkap (kalau perlu digunakan untuk menampilkan data dari database)
    public Kota(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    @Override
public String toString(){
return nama;
}
    
}


