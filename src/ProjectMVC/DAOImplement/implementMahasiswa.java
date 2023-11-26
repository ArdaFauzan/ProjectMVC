package projectmvc.DAOImplement;

import projectmvc.model.mahasiswa;
import java.util.List;
/**
 *
 * @author Muhammad 'Arda Rizqy Fauzan
 */
public interface implementMahasiswa {
    
    public void insert(mahasiswa b);

    public void update(mahasiswa b);

    public void delete(int id);

    public List<mahasiswa> getALL();

    public List<mahasiswa> getCariNama(String nama);
}
