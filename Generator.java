public class Generator {

    public static Grid Ellers(int x_len,int y_len) {

        Grid ellers_grid = new Grid(x_len, y_len);
        Row current_row = new Row(x_len);
        current_row.initialize();

        for (int y = 0; y < y_len - 1; y++) {
            
            current_row.random_merge();
            current_row.make_sets();
            current_row.carve_points();
            ellers_grid.write_row(current_row, y);
            current_row = current_row.carve(x_len);

        }

        current_row.merge_all();
        ellers_grid.write_row(current_row, y_len - 1);
        return ellers_grid;
    }
}