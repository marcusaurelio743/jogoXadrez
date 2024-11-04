package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
			
			//ter uma posi��o auxiliar
			Position p = new Position(0, 0);
			
			//verificar posi��o acima 
			p.setValues(position.getRow() - 1 , position.getColumn());
			
			while(getBoard().PositionExists(p) && !getBoard().TheresIsApieces(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() - 1);
			}
			
			if(getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//verificar posi��o esquerda 
			p.setValues(position.getRow()  , position.getColumn() - 1);
			
			while(getBoard().PositionExists(p) && !getBoard().TheresIsApieces(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() - 1);
			}
			
			if(getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//verificar posi��o direita 
			p.setValues(position.getRow()  , position.getColumn() + 1);
			
			while(getBoard().PositionExists(p) && !getBoard().TheresIsApieces(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() + 1);
			}
			
			if(getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//verificar posi��o baixo 
			p.setValues(position.getRow() + 1 , position.getColumn());
			
			while(getBoard().PositionExists(p) && !getBoard().TheresIsApieces(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() + 1);
			}
			
			if(getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			
		return mat;
	}
	
	

}
