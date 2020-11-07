package view;

import java.awt.Color;

class Celula {
	double x,y;
	Color cor;
	boolean marcada = false;
	
	Celula(double x,double y, Color cor) {
		this.x=x;
		this.y=y;
		this.cor=cor;
	}

	protected double getX() {
		return x;
	}

	protected double getY() {
		return y;
	}

	protected Color getCor() {
		if(this.marcada) {
			return Color.GREEN;
		}
		return cor;
	}
	
	protected void setCor(Color cor) {
		this.cor = cor;
	}
	
	protected void changeMarcada() {
		this.marcada = !this.marcada;
	}
}
