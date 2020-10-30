package model;

import common.Cor;

abstract class Peca {
	private boolean capturado;
	private Cor cor;
	private int x,y;
	
	public Peca(Cor cor, int x, int y) {
		this.capturado = false;
		this.cor = cor;
		this.x = x;
		this.y = y;
	}

	public boolean isCapturado() {
		return capturado;
	}

	public Cor getCor() {
		return cor;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[ " + cor + ", " + capturado + ", (" + x +", "+ y +") ]";
	}

	public abstract boolean movimentoValido(int x, int y);
}
