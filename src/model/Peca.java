package model;

import common.Cor;
import common.Estado;

class Peca {
	private Estado estado;
	private Cor cor;
	
	public Peca(Cor cor) {
		this.estado	 = Estado.NORMAL;
		this.cor = cor;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public Cor getCor() {
		return cor;
	}

	public void setEstado(Estado est) {
		if(this.estado == Estado.NORMAL)
		{
			this.estado = est; // so pode trocar o estado se for p/ capturado (uma peça capturada n pode voltar nunca ao jogo)		
		}
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public boolean movimentoValido(int xDestino, int yDestino)
	{
		System.out.println("kkkkkkk");
		return true;
	}
		
}
