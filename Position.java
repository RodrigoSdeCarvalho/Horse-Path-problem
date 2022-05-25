public class Position {
    private int column;
    private int row;
    private int step;
    
    //Constructor
    public Position(int column, int row, int step) {
        this.column = column;
        this.row = row;
        this.step = step;
    }
    
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getStep() {
        return step;
    }
    
    public void setStep(int step) {
        this.step = step;
    }

    public boolean isOnBoard() {
        boolean columnOnBoard = (0 <= this.column && this.column < 8);
        boolean rowOnBoard = (0 <= this.row && this.row < 8);

        return columnOnBoard && rowOnBoard;
    }
}
