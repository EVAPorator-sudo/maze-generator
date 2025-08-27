import java.util.ArrayList;
import java.util.Random;

public class Row {
    ArrayList<Cell> cells;
    ArrayList<Cell[]> set_array;
    ArrayList<Integer> carve_points;
    int count;

    public Row(int x_len) {
        count = 1;
        cells = new ArrayList<>();
        set_array = new ArrayList<>();
        carve_points = new ArrayList<>();
        for (int i = 0; i < x_len; i++){
            cells.add(new Cell());
        }
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

    void make_sets() {
        set_array.clear();
        int current_value = -1;
        ArrayList<Cell> working_array = new ArrayList<>();

        for (Cell cell : cells) {
            if (cell.path_num == current_value) {
                working_array.add(cell);
                } 
            else {
                if (!working_array.isEmpty()) {
                    set_array.add(working_array.toArray(new Cell[0]));
                }
                working_array = new ArrayList<>();
                working_array.add(cell);
                current_value = cell.path_num;
            }
        }
        if (!working_array.isEmpty()) {
            set_array.add(working_array.toArray(new Cell[0]));
        }
        }

    public void carve_points(){
        Random random = new Random();
        carve_points.clear();
        for (Cell[] set : set_array) {
            int randomIndex = random.nextInt(set.length);
            carve_points.add(cells.indexOf(set[randomIndex]));
        }
    }
    
    public Row carve(int x_len){
        Row new_row = new Row(x_len);
        for (int carve_point: carve_points){
            new_row.cells.get(carve_point).path_num = cells.get(carve_point).path_num;
        }
        new_row.initialize();
        return new_row;
    }
}
