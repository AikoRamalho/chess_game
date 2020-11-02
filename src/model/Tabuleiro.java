package model;

import common.Cor;

class Tabuleiro {
	private Casa[][] casas;
	private static Tabuleiro staticTabuleiro = null; // a gente quer um tab so pro jogo inteiro entao a gente cria um estatico p/ nao criar diferentes instancias
	private static Peca selecionada = null;
	
	public static Tabuleiro getTabuleiro() {
		if(staticTabuleiro != null)
			return staticTabuleiro;
		
		staticTabuleiro = new Tabuleiro();
		staticTabuleiro.setTabuleiro();
		
		return staticTabuleiro;
	}
	
	public static void deleteTabuleiro() {
		staticTabuleiro = null;
	}
	
	public boolean selecionaPeca(int x, int y, Jogador jogadorDaVez)
	{
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		if(staticTabuleiro.casas[x][y].getPeca() == null) {
			return false;
		}
		if(staticTabuleiro.casas[x][y].getPeca().getCor() == jogadorDaVez.getCor()) {
			setSelecionada(staticTabuleiro.casas[x][y].getPeca());
			return true;
		}
		return false;
	}
	
	public boolean selecionaCasa(int xDestino, int yDestino, Jogador jogadorDaVez) // esse metodo recebe as coordenadas de destino de uma peça previamente selecionada, validando a movimentação
	{
		if(xDestino < 0 || xDestino > 7 || yDestino < 0 || yDestino > 7) {
			return false;
		}
		if(selecionada == null) {
			return false;
		}
		if(selecionada.getCor() == jogadorDaVez.getCor()) {
			return false; // n pode mover pra um lugar onde tem peça do jogador
		}
		return false;
	}
	
	private void setTabuleiro() {
		casas[0][0] = new Casa(0, 0, new Torre(Cor.BRANCO)); // Torre na posicao 0,0
		casas[0][1] = new Casa(0, 1, new Cavalo(Cor.BRANCO));
		casas[0][2] = new Casa(0, 2, new Bispo(Cor.BRANCO));
		casas[0][3] = new Casa(0, 3, new Rainha(Cor.BRANCO));
		casas[0][4] = new Casa(0, 4, new Rei(Cor.BRANCO));
		casas[0][5] = new Casa(0, 5, new Bispo(Cor.BRANCO));
		casas[0][6] = new Casa(0, 6, new Cavalo(Cor.BRANCO));
		casas[0][7] = new Casa(0, 7, new Torre(Cor.BRANCO));
				

		casas[7][0] = new Casa(7, 0, new Torre(Cor.BRANCO));
		casas[7][1] = new Casa(7, 1, new Cavalo(Cor.BRANCO));
		casas[7][2] = new Casa(7, 2, new Bispo(Cor.BRANCO));
		casas[7][3] = new Casa(7, 3, new Rainha(Cor.BRANCO));
		casas[7][4] = new Casa(7, 4, new Rei(Cor.BRANCO));
		casas[7][5] = new Casa(7, 5, new Bispo(Cor.BRANCO));
		casas[7][6] = new Casa(7, 6, new Cavalo(Cor.BRANCO));
		casas[7][7] = new Casa(7, 7, new Torre(Cor.BRANCO));
		
	
		for(int i = 0; i < 8; i++) {
			casas[1][i] = new Casa(1, i, new Peao(Cor.BRANCO));
			casas[6][i] = new Casa(7, i, new Peao(Cor.BRANCO));
		}

		for (int i = 2; i < 6; i++) { 
            for (int j = 0; j < 8; j++) { 
            	casas[i][j] = new Casa(i, j, null); // as casas sem peças sao inicializadas com null
            } 
        }
	}

	public static Peca getSelecionada() {
		return selecionada;
	}

	public static void setSelecionada(Peca selecionada) {
		Tabuleiro.selecionada = selecionada;
	}
	
    /*
    public static void main(String[] args) {
    	selecionada = new Torre(Cor.BRANCO);
    	selecionada.movimentoValido(10, 231);
    }
    */
	
}
