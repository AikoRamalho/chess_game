package model;

import common.Cor;

class Torre extends Peca {

	public Torre(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimentoValido(int x, int y) {
		if((x < 0 || x > 7) || (y < 0 || y > 7)) {
			return false;
		}
		else {
			int currentRow = this.getLinha();
			int currentColumn = this.getColuna();
			
			boolean mesmaLinha = (currentRow == x);
			boolean mesmaColuna = (currentColumn == y);
			boolean naoEMesmaCasa = !((currentRow == x) && (currentColumn == y));
			
			return naoEMesmaCasa && (mesmaLinha || mesmaColuna);
		}
		
	}

}
