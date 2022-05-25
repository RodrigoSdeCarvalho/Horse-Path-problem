import java.util.Scanner;

public class Solution {
    public static boolean checked(int[][] checked, Position position) {
        for (int[] pos : checked) {
            if (pos[0] == position.getColumn() && pos[1] == position.getRow()) {
                return true;
            }
        } return false;
    }

    public static int minimumDistance(Position start, Position destiny) {
        int[][] checked = new int[1000][2];
        Queue queue = new Queue(64);
        int checkedIndex = 0;

        queue.insert(start);
        while (!queue.isEmpty()) {
            Position poppedPosition = queue.pop();

            if (poppedPosition.getColumn() == destiny.getColumn() && poppedPosition.getRow() == destiny.getRow()) {
                System.out.println(poppedPosition.getColumn() + ", " + poppedPosition.getRow());
                return poppedPosition.getStep();
            }
            Position[] nextPositions = ChessMovement.horseMovement(poppedPosition);
            for (Position nextPosition : nextPositions) {
                if (!checked(checked, nextPosition) && nextPosition.isOnBoard()) {
                    queue.insert(new Position(nextPosition.getColumn(), nextPosition.getRow(), poppedPosition.getStep() + 1));

                    int[] poppedPositionChecked = {poppedPosition.getColumn(), poppedPosition.getRow()};
                    checked[checkedIndex] = poppedPositionChecked;
                    checkedIndex += 1;
                } 
            }
        } return -1;
    }

    public static void main(String[] args) {
        //inputs
        Scanner scanner = new Scanner(System.in);

        String start = scanner.nextLine();
        String destiny = scanner.nextLine();

        scanner.close();   

        //transform inputs to positions
        int startColumn = ChessMovement.columnNumber(start.charAt(0));
        Position startPosition = new Position(startColumn, (Character.getNumericValue(start.charAt(1))) - 1, 0);

        int destinyColumn = ChessMovement.columnNumber(destiny.charAt(0));
        Position destinyPosition = new Position(destinyColumn, (Character.getNumericValue(destiny.charAt(1))) - 1, 0);

        //Solution itself
        int distance = Solution.minimumDistance(startPosition, destinyPosition);

        //output
        System.out.println("Movimentos: " + distance);
    }
}
