package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][]pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    //Métodos da classe Board

    //acessando a peça
    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    //acessando a posição da peça, ex: b5
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }


    //atribuindo uma determinada peça a uma determinada posição.
    /* Nesse método temos um forte uso de Herança pois o metodo recebe
    * um objeto Piece, mas o que será atribuido à ele, será
    * uma classe(king, Rook) que extends ChessPiece que extends Piece.
    * Logo, essa classe É uma ChessPiece e uma Piece e está sendo atribuída
    * no método com o uso do UpCasting na Classe ChessMatch. */
    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}

