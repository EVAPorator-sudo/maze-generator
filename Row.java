import java.util.ArrayList;
import java.util.Random;

public class Row {
    ArrayList<Cell> cells = new ArrayList<>();
    int count;
    ArrayList<Cell[]> set_array = new ArrayList<>();
    ArrayList<Integer> carve_points = new ArrayList<>();

    public Row(int x_len) {
        for (int i = 0; i < x_len; i++){
            cells.add(new Cell());
        }
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

    public void random_merge(){
        Random random = new Random();
        for(Cell cell: cells){

            if (random.nextBoolean()) {
                    
                if (cells.indexOf(cell) != 0) {

                    cell.path_num = cells.get(cells.indexOf(cell) - 1).path_num;
                }
                else{

                    cell.path_num = cells.get(cells.indexOf(cell) + 1).path_num;
                }
            
            }
            
        }
    }

    public void merge_all(){
        int merging_num = cells.get(0).path_num;
        for (Cell cell: cells){
            cell.path_num = merging_num;
        }
    }

    void make_sets(){
        int current_value = 0;
        ArrayList<Cell> working_array = new ArrayList<>();
        for (Cell cell: cells){
            if (cell.path_num == current_value) {
                working_array.add(cell);
            }
            else {
                set_array.add(working_array.toArray(new Cell[0]));
                working_array = new ArrayList<Cell>();
            }
        }
    }

    public void carve_points(){
        Random random = new Random();
        for (Cell[] set: set_array){
            boolean carved = false;
            while (carved == false) {
                for (Cell cell: set){
                    if (random.nextBoolean()){
                        carved = true;
                        carve_points.add(cells.indexOf(cell));
                    }
                }
            }
        }
    }
    
    public void carve(){
        throw new java.lang.RuntimeException("not implemented yet");
    }
}
