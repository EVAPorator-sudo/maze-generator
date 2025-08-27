public class Grid{
    public Cell[][] map;
    public int x_length;
    public int y_length;

    Grid(int x_len, int y_len){
        x_length = x_len;
        y_length = y_len;
        map = new Cell[x_len][y_len];
    }

    public void write_row(Row row, int y) {
        map[y] = row.cells.toArray(new Cell[0]);
    }


    public Character[][] draw(){
        Character[][] canvas = new Character[2*x_length + 1][2*y_length + 1];
        for (int x = 0; x < 2*x_length + 1;x += 1){
            for (int y = 0; y < 2*y_length + 1;y += 1){
                canvas[x][y] = '#';
            }
        }
        for (int y = 0; y < y_length; y++){
            for (int x = 0; x < x_length; x++){
                Cell cell = map[y][x];
                if (cell == null){
                    throw new java.lang.NullPointerException("null cell");
                }
                canvas[2 * x + 1][2 * y + 1] = ' ';
                if (x + 1 < x_length && map[y][x + 1] != null && map[y][x+1].path_num == cell.path_num){
                    canvas[2 * y + 1][2 * x + 2] = ' '; 
                }

                if (y + 1 < y_length && map[y + 1][x] != null && map[y + 1][x].path_num == cell.path_num){
                    canvas[2 * y + 2][2 * x + 1] = ' '; 
                }
            }
        }
        return canvas;
    }
}