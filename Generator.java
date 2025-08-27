import java.util.Random;

public class Generator {

    static Random random = new Random();

    public static Grid Ellers(int x_len,int y_len) {

        Grid ellers_grid = new Grid(x_len, y_len);
        Row current_row = new Row(x_len);
        current_row.initialize();

        for (int y = 1; y < y_len; y++) {
            
            for(Cell cell: current_row.cells){

                if (random.nextBoolean()) {
                    
                    current_row.merge(cell);
                }
            }

            for(Set set: current_row.set_array){

                current_row.carve_points(set);
            
            }
            
            ellers_grid.write_row(current_row);
            current_row.carve();

        }

        for (Cell cell : current_row.cells) {

            current_row.merge(cell);
            
        }

        ellers_grid.write_row(current_row);
        return ellers_grid;
    }
}