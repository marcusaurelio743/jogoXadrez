package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		if(rows < 1 || columns < 1 ) {
			throw new BoardExeption("error creating board: there must be at least 1 row and 1 column");
		}

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getColumns() {
		return columns;
	}


	public int getRows() {
		return rows;
	}

	
	public Piece piece(int rows,int columns) {
		if(!PositionExists(rows, columns)) {
			throw new BoardExeption("Position not on the Board");
		}
		return pieces[rows][columns];
	}
	
	public Piece piece( Position position) {
		if(!PositionExists(position)) {
			throw new BoardExeption("Position not on the Board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		
		if(TheresIsApieces(position)) {
			throw new BoardExeption("There is already a piece on position "+position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean PositionExists(int row, int column) {
		
		return row >=0 && row < rows && column >=0 && column < columns ;
	}
	public boolean PositionExists(Position position) {
		return PositionExists(position.getRow(), position.getColumn());
	}
	
	public boolean TheresIsApieces(Position position) {
		if(!PositionExists(position)) {
			throw new BoardExeption("Position not on the Board");
		}
		return piece(position) != null;
	}

	

}
