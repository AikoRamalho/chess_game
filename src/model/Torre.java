package model;

import common.Cor;

class Torre extends Peca {

	public Torre(Cor cor) {
		super(cor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean movimentoValido(int xDestino, int yDestino)
	{
		super.movimentoValido(xDestino, yDestino);
		System.out.println("aaaaaaaa");
		return true;
	}

}
