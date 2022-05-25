public class ChessMovement {
    public static int columnNumber(char column) {
        String columns = "abcdefgh";
        return columns.indexOf(column);
    }
   
    public static Position[] horseMovement(Position position) {
        int[][] horseMovements = {{1, 2}, {-1, -2}, {-1, 2}, {1, -2}, 
                            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Position[] positions = new Position[8];
        
        int indexPosX;
        for (indexPosX = 0; indexPosX < 8; indexPosX++) {
            positions[indexPosX] = new Position(position.getColumn() + horseMovements[indexPosX][0], position.getRow() + horseMovements[indexPosX][1], 0);
        }
        
        return positions;
    }
}
