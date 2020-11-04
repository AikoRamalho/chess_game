package model;

class Tabuleiro {
	private Casa[][] casas = new Casa[8][8];
	private static Tabuleiro staticTabuleiro = null; // a gente quer um tab so pro jogo inteiro entao a gente cria um estatico p/ nao criar diferentes instancias
	private static Peca selecionada = null; //peca do tabuleiro selecionada
	
	public static Tabuleiro getTabuleiro(Jogador j, Jogador j2) {
		if(staticTabuleiro != null)
			return staticTabuleiro;
		
		staticTabuleiro = new Tabuleiro();
		staticTabuleiro.setTabuleiro(j, j2);
		
		return staticTabuleiro;
	}
	
	public static Tabuleiro getTabuleiro() {
		if(staticTabuleiro != null)
			return staticTabuleiro;
		
		return null;
	}
	
	public static void deleteTabuleiro() {
		staticTabuleiro = null;
	}
	
	protected Casa[][] getCasas() {
		return casas;
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
	
	private void setTabuleiro(Jogador j, Jogador j2) {
		for(int i=0; i<8; i++) {
			for(int k=0; k<8;k++) {
				casas[i][k] = new Casa(i, k, null);
			}
		}
		for(int i=0; i<j.getPecas().size(); i++){
            casas[j.getPecas().get(i).getX()][j.getPecas().get(i).getY()].ocupaCasa(j.getPecas().get(i));
            casas[j2.getPecas().get(i).getX()][j2.getPecas().get(i).getY()].ocupaCasa(j2.getPecas().get(i));
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
