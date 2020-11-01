package model;

import common.Cor;

class Peao extends Peca {

	public Peao(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimentoValido(int x, int y) {
		// TODO Auto-generated method stub
		int currentRow = this.getLinha();
		int currentColumn = this.getColuna();
		boolean move1 = false;
        boolean move2 = false;
		boolean diagonal = false;
		boolean naoEMesmaCasa = !((currentRow==x) && (currentColumn==y)); //verifica se a casa de destino não é a casa que já está
		
		if(x > currentRow + 2) {
			return false;
		}
		
		if(this.getCor() == Cor.BRANCO) {
			move1 = ((currentColumn == y) && (currentRow + 1 == x)); //anda uma casa
			move2 = ((currentRow == 1) && (currentColumn == y) && (currentRow + 2 == x)); //anda 2 casas se for o primeio movimento
			diagonal = (currentRow+1 == x && currentColumn - 1 == y) || (currentRow+1 == x && currentColumn+1 == y);
		}
		else {
			move1 = ((currentColumn == y) && (currentRow - 1 == x)); //anda uma casa
			move2 = ((currentRow == 6) && (currentColumn == y) && (currentRow - 2 == x)); //anda 2 casas se for o primeio movimento
			diagonal = (currentRow - 1 == x && currentColumn - 1 == y) || (currentRow - 1 == x && currentColumn + 1 == y);
		}
		return naoEMesmaCasa && (move1 || move2 || diagonal);
	}

}
