import java.util.ArrayList;

public class Row {
    Cell[] cells;
    int count;
    ArrayList<Set> set_array = new ArrayList<Set>();

    public Row(int x_len) {
        cells = new Cell[x_len];
        count = 1;
    }

    public void initialize(){
        for (Cell cell: cells) {
            if (cell.path_num == 0){
                cell.path_num = count;
                count ++;
            }
        }
    }

    public void merge(Cell cell){
        throw new java.lang.RuntimeException("not implemented yet");
    }

    public void carve_points(Set set){
        throw new java.lang.RuntimeException("not implemented yet");
    }
    
    public void carve(){
        throw new java.lang.RuntimeException("not implemented yet");
    }
}
