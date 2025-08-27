public class Main {
    public static void main(String[] args){
        Grid grid = Generator.Ellers(20, 20);
        Character[][] canvas = grid.draw();
        String maze_art = ""; 
        for (Character[] row: canvas){
            for(Character character: row){
                maze_art += character;
            }
            maze_art += "\n";
        }
        System.out.println(maze_art);
    }
}
