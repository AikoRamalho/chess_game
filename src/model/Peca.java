package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.Estado;
import common.TiposPeca;

class Peca {
	private boolean jaMovimentou = false;
	private Estado estado;
	private Cor cor;
	private TiposPeca tipo;
	int x, y;
	
	public Peca(TiposPeca tipo, Cor cor, int x, int y) {
		this.tipo = tipo;
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
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Cor getCor() {
		return cor;
	}

	public TiposPeca getTipo() {
		return tipo;
	}

	public void setEstado() {
		if(this.estado == Estado.NORMAL)
		{
			this.estado = Estado.CAPTURADO; // so pode trocar o estado se for p/ capturado (uma pe�a capturada n pode voltar nunca ao jogo)		
		}
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public boolean isJaMovimentou() {
		return jaMovimentou;
	}
	
	public void setJaMovimentou(boolean movimentou) {
		this.jaMovimentou = movimentou;
	}
	
	public void movePara(int x, int y) {
		if(!this.jaMovimentou)
			this.jaMovimentou = true;
		this.setX(x);
		this.setY(y);
	}
	
	public void mockPara(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public boolean movimentoValido(int xDestino, int yDestino)
	{
		List<List<Integer>> movimentosValidos = this.getMovimentosValidos();
		for(List<Integer> mov: movimentosValidos) {
			if(mov.size() > 0) {
				if(mov.get(0) == xDestino && mov.get(1) == yDestino)
					return true;				
			}
		}
		return false;
	}

	public List<List<Integer>> getMovimentosValidos() { 
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		return movimentosValidos;
	}
		
}