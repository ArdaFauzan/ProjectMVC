package projectmvc.model;
/**
 *
 * @author Muhammad 'Arda Rizqy Fauzan
 */
public class mahasiswa {
    
    private Integer id;
    private String nim;
    private String nama;
    private String kelas;
    private String uts;
    private String uas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getUTS() {
        return uts;
    }

    public void setUTS(String uts) {
        this.uts = uts;
    }
    
    public String getUAS() {
        return uas;
    }

    public void setUAS(String uas) {
        this.uas = uas;
    }

    

}