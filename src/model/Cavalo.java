package model;

import common.Cor;

class Cavalo extends Peca {

	public Cavalo(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimentoValido(int x, int y) {
		if((x < 0 || x > 7) && (y < 0 || y > 7)) {
			return false;
		}
		else {
			int currentRow = this.getLinha();
			int currentColumn = this.getColuna();
			//move 1 casa na Linha e 2 na Coluna
			boolean move1X2Y = (Math.abs(currentRow-x) == 1) && (Math.abs(currentColumn - y) == 2); //uso Math.abs para pegar o módulo
			//move 2 casas na Linha e 1 na Coluna
			boolean move2X1Y = (Math.abs(currentRow-x) == 2) && (Math.abs(currentColumn - y) == 1);
			boolean naoEMesmaCasa = !((currentRow == x) && (currentColumn == y));
			
			return naoEMesmaCasa && (move1X2Y || move2X1Y);
		}
		
	}

}
