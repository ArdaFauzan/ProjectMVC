package projectmvc.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Muhammad 'Arda Rizqy Fauzan
 */
public class tableModelMahasiswa  extends AbstractTableModel{
    
    List<mahasiswa> lb;

    public tableModelMahasiswa(List<mahasiswa> lb) {
        this.lb = lb;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }


    public int getRowCount() {
        return lb.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nim";
            case 2:
                return "Nama";
            case 3:
                return "Kelas";
            case 4:
                return "UTS";
            case 5 :
                return "UAS";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNim();
            case 2:
                return lb.get(row).getNama();
            case 3:
                return lb.get(row).getKelas();
            case 4:
                return lb.get(row).getUTS();
            case 5 :
                return lb.get(row).getUAS();
            default:
                return null;
        }
    }
}
