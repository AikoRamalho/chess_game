package model;

import common.Cor;
import common.TiposPeca;

class Casa {
	private Peca peca;
	private int x;
	private int y;
	
	public Casa(int x, int y, Peca peca)
	{
		this.setX(x);
		this.setY(y);
		this.setPeca(peca);
	}

	public void upgradePeca(TiposPeca novoTipo) {
		Cor cor = this.peca.getCor();
		
		switch (novoTipo) {
		case BISPO:
			this.setPeca(new Bispo(cor, x, y));
			break;
		case CAVALO:
			this.setPeca(new Cavalo(cor, x, y));
			break;
		case RAINHA:
			this.setPeca(new Rainha(cor, x, y));
			break;
		case TORRE:
			this.setPeca(new Torre(cor, x, y));
			break;
		default:
			break;
		}
	}

	

	public void ocupaCasa(Peca peca){
        if(this.peca != null) {
           this.peca.setEstado();
        }
        
        this.peca = peca;
    }

	public Peca getPeca() {
		return peca;
	}
	
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setPeca(TiposPeca tipo, Cor cor) {
		switch (tipo) {
		case PEAO:
			this.setPeca(new Peao(cor, x, y));
			break;
		case BISPO:
			this.setPeca(new Bispo(cor, x, y));
			break;
		case CAVALO:
			this.setPeca(new Cavalo(cor, x, y));
			break;
		case RAINHA:
			this.setPeca(new Rainha(cor, x, y));
			break;
		case TORRE:
			this.setPeca(new Torre(cor, x, y));
			break;
		case REI:
			this.setPeca(new Rei(cor, x, y));
			break;
		default:
			break;
		}
	}
}