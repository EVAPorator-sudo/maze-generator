public class Generator {

    public static Grid Ellers(int x_len,int y_len) {

        Grid ellers_grid = new Grid(x_len, y_len);
        Row current_row = new Row(x_len);
        current_row.initialize();

        for (int y = 1; y < y_len; y++) {
            
            current_row.random_merge();

            current_row.carve_points();
            
            ellers_grid.write_row(current_row);
            current_row.carve();

        }

        current_row.merge_all();

        ellers_grid.write_row(current_row);
        return ellers_grid;
    }
}