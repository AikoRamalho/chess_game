package model;

import common.Cor;
import common.Estado;

class Peca {
	private Estado estado;
	private Cor cor;
	int x, y;
	
	public Peca(Cor cor, int x, int y) {
		this.estado	 = Estado.NORMAL;
		this.cor = cor;
		this.x = x;
		this.y = y;
	}

	public Estado getEstado() {
		return this.estado;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public Cor getCor() {
		return cor;
	}

	public void setEstado() {
		if(this.estado == Estado.NORMAL)
		{
			this.estado = Estado.CAPTURADO; // so pode trocar o estado se for p/ capturado (uma peça capturada n pode voltar nunca ao jogo)		
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
