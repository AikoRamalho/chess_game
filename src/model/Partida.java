package model;

class Partida {
	Jogador jogador1, jogador2;
	Jogador jogadorDaVez = null;
	
	protected Partida(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogadorDaVez = this.jogador1;
	}
	
	protected Jogador getJogador1() {
		return jogador1;
	}
	protected Jogador getJogador2() {
		return jogador2;
	}
	protected Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}
	protected void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}
	protected void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}
	protected void passaVez() {
		if(this.jogadorDaVez == jogador1)
			this.jogadorDaVez = jogador2;
		else
			this.jogadorDaVez = jogador1;
	}

	protected void setJogadorDaVez(String nome) {
		if(!this.jogadorDaVez.nome.equals(nome))
			passaVez();
	}
}
