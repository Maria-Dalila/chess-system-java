package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][]pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //Métodos da classe Board

    //acessando a peça
    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
           throw new BoardException("Position not on the board") ;
        }
        return pieces[row][column];
    }

    //acessando a posição da peça, ex: b5
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board") ;
        }
        return pieces[position.getRow()][position.getColumn()];
    }


    //atribuindo uma determinada peça a uma determinada posição.
    /* Nesse método temos um forte uso de Herança pois o metodo recebe
    * um objeto Piece, mas o que será atribuido à ele, será
    * uma classe(king, Rook) que extends ChessPiece que extends Piece.
    * Logo, essa classe É uma ChessPiece e uma Piece e está sendo atribuída
    * no método com o uso do UpCasting na Classe ChessMatch. */
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //Método auxiliar
    public boolean positionExists(int row, int column){
       return row >= 0 && row< rows && column >= 0 && column < columns;
    }

    //retorna um boolean dizendo se a posição existe no tabuleiro
    public boolean positionExists(Position position){
    return positionExists(position.getRow(), position.getColumn());
    }

    //retorna um boolean dizendo se a posição possui uma peça
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board") ;
        }
        return piece(position) != null;
    }



}

