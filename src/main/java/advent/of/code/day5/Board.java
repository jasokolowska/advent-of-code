package advent.of.code.day5;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private int colNbr;
    private int rowNbr;
    private List<List<Integer>> board = new LinkedList<>();

    public Board(int colNbr, int rowNbr) {
        this.colNbr = colNbr;
        this.rowNbr = rowNbr;

        for (int i = 0; i < rowNbr; i++) {
            List<Integer> row = new LinkedList<>();
            for (int j = 0; j < colNbr; j++) {
                row.add(0);
            }
            board.add(row);
        }
    }

    public void drawLineOnBoard(Line line) {
        for (Point point : line.getLine()) {
            int x = point.getX();
            int y = point.getY();

            int cellCurrentValue = board.get(y).get(x);
            board.get(y).set(x, cellCurrentValue+1);
        }
        

    }

    public int getColNbr() {
        return colNbr;
    }

    public int getRowNbr() {
        return rowNbr;
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String print = "";
        for (List<Integer> row : board) {
            for (Integer integer : row) {
                print += integer + " ";
            }
            print += "\n";
        }
        return print;
    }
}
