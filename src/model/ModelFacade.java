package model;

public class ModelFacade {
	private Tabuleiro tb = Tabuleiro.getTabuleiro();
	Partida partida;
	
	
	
	protected Partida getPartida() {
		return partida;
	}

	protected void setPartida(String nome1, String nome2) {
//		this.partida = Partida();
	}

	public void iniciaTabuleiro() {
		tb.setTabuleiro();
	}
	
	public void reiniciaTabuleiro() {
		tb.setTabuleiro();
	}
	
//	public boolean selecionaCasa(int linha, int coluna) {
//		if(tb.mPecas[linha][coluna] == null)
//			return false;
//		else {
//			if(tb.mPecas[linha][coluna].getCor() == )
//		}
//		return false;
//	}
	
}
