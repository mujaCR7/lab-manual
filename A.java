import java.util.ArrayList;
import java.util.List;

// Encapsulation: Position class
class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}

// Abstract base class demonstrating Abstraction & Inheritance
abstract class Piece {
    protected boolean isWhite;
    protected Position position;

    public Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    public boolean isWhite() { return isWhite; }
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    // Polymorphism: Abstract method for move validation
    public abstract boolean isValidMove(Position newPosition, Board board);
}

// Concrete Piece: Rook
class Rook extends Piece {
    public Rook(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Board board) {
        int r1 = position.getRow(), c1 = position.getCol();
        int r2 = newPosition.getRow(), c2 = newPosition.getCol();
        return (r1 == r2 || c1 == c2); // Simplified move rule
    }
}

// Concrete Piece: Knight
class Knight extends Piece {
    public Knight(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Board board) {
        int rDiff = Math.abs(position.getRow() - newPosition.getRow());
        int cDiff = Math.abs(position.getCol() - newPosition.getCol());
        return (rDiff == 2 && cDiff == 1) || (rDiff == 1 && cDiff == 2);
    }
}

// Board representation
class Board {
    private Piece[][] grid = new Piece[8][8];

    public void setPiece(int r, int c, Piece p) {
        grid[r][c] = p;
    }

    public Piece getPiece(int r, int c) {
        return grid[r][c];
    }
}

public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();
        Piece rook = new Rook(true, new Position(0, 0));
        Piece knight = new Knight(true, new Position(0, 1));

        board.setPiece(0, 0, rook);
        board.setPiece(0, 1, knight);

        System.out.println("Is Rook move to (0, 5) valid? " + rook.isValidMove(new Position(0, 5), board)); // true
        System.out.println("Is Knight move to (2, 2) valid? " + knight.isValidMove(new Position(2, 2), board)); // true
    }
}
