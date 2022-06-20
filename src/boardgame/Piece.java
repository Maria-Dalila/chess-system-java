package boardgame;

public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    //protected para ser acessado apenas pelas subclasses e pelas classes do pacote boardgame
    protected Board getBoard() {
        return board;
    }




}
