package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.Estado;
import common.Observable;
import common.Observer;
import common.TiposPeca;

class Tabuleiro implements Observable {
	private Casa[][] casas = new Casa[8][8];
	private static Tabuleiro staticTabuleiro = null; // a gente quer um tab so pro jogo inteiro entao a gente cria um estatico p/ nao criar diferentes instancias
	private static Peca selecionada = null; //peca do tabuleiro selecionada
	private int[] coordUpgrade = null; // Coordenadas do peão que deve ser aprimorado
	List<Observer> lob=new ArrayList<Observer>();
	
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
		
		staticTabuleiro = new Tabuleiro();
		return staticTabuleiro;
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
	
	public boolean selecionaCasa(int xDestino, int yDestino, Jogador jogadorDaVez) // esse metodo recebe as coordenadas de destino de uma pe�a previamente selecionada, validando a movimenta��o
	{
		if(xDestino < 0 || xDestino > 7 || yDestino < 0 || yDestino > 7) {
			return false;
		}
		
		// Verifica se a casa selecionanda contem peca aliada
		Peca pecaDestino = staticTabuleiro.casas[xDestino][yDestino].getPeca();
		if(pecaDestino != null && pecaDestino.getCor() == selecionada.getCor()) {
			if(selecionada instanceof Rei) {
				selecionada.movimentoValido(xDestino, yDestino);
			} else {
				return false;
			}
		}
		
		if (selecionada.movimentoValido(xDestino, yDestino) == false) {
			return false;
		}

		Cor corSelec = selecionada.getCor();
		Boolean linhaFinal = (corSelec == Cor.BRANCO && yDestino == 7) ||
							 (corSelec == Cor.PRETO && yDestino == 0);
		
		if (selecionada instanceof Peao && linhaFinal) {
			this.coordUpgrade = new int[] {xDestino, yDestino};
			for(Observer o:lob) {
				o.notify(this);
			}
		}
		
		return true;
	}
	
	// Busca o peão que chegou na última linha e aplica o upgrade escolhido nele.
	void melhorarPeao(TiposPeca novoTipo) {
		Cor corAtual = ModelFacade.mf.partida.jogadorDaVez.cor;
		int linhaFoco = corAtual == Cor.BRANCO ? 0 : 7;
		
		for (int col = 0; col < 8; col++) {
			Casa casaAtual = staticTabuleiro.casas[col][linhaFoco];
			Peca pecaAtual = casaAtual.getPeca();
			if (pecaAtual != null && pecaAtual.getCor() != corAtual) {
				casaAtual.upgradePeca(novoTipo);
				break;
			}
		}
		
		for (Observer o:lob) {
			o.notify(this);
		}
	}
	
	public void setTabuleiro(Jogador j, Jogador j2) {
		for(int i=0; i<8; i++) {
			for(int k=0; k<8;k++) {
				staticTabuleiro.casas[i][k] = new Casa(i, k, null);
			}
		}
		for(int i=0; i<j.getPecas().size(); i++){
			Casa casaJog1 = staticTabuleiro.casas[j.getPecas().get(i).getX()][j.getPecas().get(i).getY()];
			Casa casaJog2 = staticTabuleiro.casas[j2.getPecas().get(i).getX()][j2.getPecas().get(i).getY()];
			casaJog1.ocupaCasa(j.getPecas().get(i));
			casaJog2.ocupaCasa(j2.getPecas().get(i));
        }
		
		for(Observer o:lob) {
			o.notify(this);
		}
	}
	
	public void movePecaDePara(int xAtual, int yAtual, int xPara, int yPara) {
		Peca pecaParaMover = staticTabuleiro.getPeca(xAtual, yAtual);
		Peca pecaParaCapturar = staticTabuleiro.getPeca(xPara, yPara);
		if(pecaParaCapturar == null) { // posicao vazia
			// é roque
			if(staticTabuleiro.casas[xAtual][yAtual].getPeca() instanceof Rei &&
					((Rei)staticTabuleiro.casas[xAtual][yAtual].getPeca()).isRoque(xPara,yPara)) {
				System.out.println("Roque");
				if(xPara == 6) { // roque curto
					Torre torre = (Torre)staticTabuleiro.casas[7][yPara].getPeca();
					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
					pecaParaMover.movePara(xPara, yPara);
					staticTabuleiro.casas[xPara-1][yPara].setPeca(torre);
					torre.movePara(xPara-1, yPara);
					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
				} else { // roque longo
					Torre torre = (Torre)staticTabuleiro.casas[0][yPara].getPeca();
					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
					pecaParaMover.movePara(xPara, yPara);
					staticTabuleiro.casas[xPara+1][yPara].setPeca(torre);
					torre.movePara(xPara+1, yPara);
					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
				}
			} else {
				staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//				pecaParaMover.setX(xPara);
//				pecaParaMover.setY(yPara);
				pecaParaMover.movePara(xPara, yPara);
				staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			}			
		} else {
			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//			pecaParaMover.setX(xPara);
//			pecaParaMover.setY(yPara);
			pecaParaMover.movePara(xPara, yPara);
			staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			
			// Talvez seja desnecessario.
			pecaParaCapturar.setEstado();
			pecaParaCapturar.setX(-1);
			pecaParaCapturar.setY(-1);
		}
		
		for(Observer o:lob) {
			o.notify(this);
		}
	}
	
	
	
	public Rei getRei(Cor corPecaPraMover) {
		List<Peca> pecas = staticTabuleiro.getAllPecas();
		for (Peca peca: pecas) {
			if(peca instanceof Rei && peca.getCor() == corPecaPraMover) {
				return (Rei) peca;
			}
		}
		return null;
	}
	
//	public boolean verificaMovimentoTiraDoXeque(int xAtual, int yAtual, int xPara, int yPara) {
//		Peca pecaParaMover = staticTabuleiro.getPeca(xAtual, yAtual);
//		Rei rei = staticTabuleiro.getRei(pecaParaMover.getCor());
//		Peca pecaParaCapturar = staticTabuleiro.getPeca(xPara, yPara);
//		if(pecaParaCapturar == null) { // posicao vazia
//			// é roque
//			if(staticTabuleiro.casas[xAtual][yAtual].getPeca() instanceof Rei &&
//					((Rei)staticTabuleiro.casas[xAtual][yAtual].getPeca()).isRoque(xPara,yPara)) {
//				if(xPara == 6) { // roque curto
//					Torre torre = (Torre)staticTabuleiro.casas[7][yPara].getPeca();
//					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//					pecaParaMover.movePara(xPara, yPara);
//					staticTabuleiro.casas[xPara-1][yPara].setPeca(torre);
//					torre.movePara(xPara-1, yPara);
//					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
//				} else { // roque longo
//					Torre torre = (Torre)staticTabuleiro.casas[0][yPara].getPeca();
//					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//					pecaParaMover.movePara(xPara, yPara);
//					staticTabuleiro.casas[xPara+1][yPara].setPeca(torre);
//					torre.movePara(xPara+1, yPara);
//					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
//				}
//			} else {
//				staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//				pecaParaMover.movePara(xPara, yPara);
//				staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
//				boolean valorDeRetorno = rei.isChecked();
//				staticTabuleiro.casas[xAtual][yAtual].setPeca(pecaParaMover);
//				pecaParaMover.movePara(xAtual, yAtual);
//				staticTabuleiro.casas[xPara][yPara].setPeca(null);
//				return valorDeRetorno;
//			}			
//		} else {
//			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//			pecaParaMover.movePara(xPara, yPara);
//			staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
//			boolean valorDeRetorno = rei.isChecked();
//			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaCapturar);
//			pecaParaMover.movePara(xAtual, yAtual);
//			staticTabuleiro.casas[xAtual][yAtual].setPeca(pecaParaMover);
//			return valorDeRetorno;
//		}
//		return false;
//	}
	
	public boolean verificaMovimentoTiraDoXeque(int xAtual, int yAtual, int xPara, int yPara) {
		Peca pecaParaMover = staticTabuleiro.getPeca(xAtual, yAtual);
		Rei rei = staticTabuleiro.getRei(pecaParaMover.getCor());
		Peca pecaParaCapturar = staticTabuleiro.getPeca(xPara, yPara);
		if(pecaParaCapturar == null) { // posicao vazia
			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
			pecaParaMover.mockPara(xPara, yPara);
			staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			boolean valorDeRetorno = rei.isChecked();
			staticTabuleiro.casas[xAtual][yAtual].setPeca(pecaParaMover);
			pecaParaMover.mockPara(xAtual, yAtual);
			staticTabuleiro.casas[xPara][yPara].setPeca(null);
			return valorDeRetorno;	
		} else {
			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
			pecaParaMover.mockPara(xPara, yPara);
			staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			boolean valorDeRetorno = rei.isChecked();
			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaCapturar);
			pecaParaMover.mockPara(xAtual, yAtual);
			staticTabuleiro.casas[xAtual][yAtual].setPeca(pecaParaMover);
			return valorDeRetorno;
		}
	}
	
	public Peca getPeca(int x, int y) {
		return staticTabuleiro.casas[x][y].getPeca();
	}
	
	public void upgradePeca(int x, int y, TiposPeca a) {
		staticTabuleiro.casas[x][y].upgradePeca(a);
	}
	
	public List<Peca> getAllPecas() {
		List<Peca> lista = new ArrayList<>();
		for(int x = 0; x<8;x++) {
			for(int y=0;y<8;y++) {
				if(this.getPeca(x,y) != null) {
					lista.add(staticTabuleiro.getPeca(x,y));
				}
			}
		}
		return lista;
	}
	
	public List<List<Object>> getDisposicaoPecas() {
		List<List<Object>> listOfLists = new ArrayList<>();
		List<Peca> pecas =  this.getAllPecas();		
		for(Peca peca: pecas) {
			List<Object> innerList = new ArrayList<>();
			innerList.add(peca.getX());
			innerList.add(peca.getY());
			innerList.add(peca.getTipo());
			innerList.add(peca.getCor());
			listOfLists.add(innerList);
		}
		return listOfLists;
	}
	
	
	public static Peca getSelecionada() {
		return selecionada;
	}

	public static void setSelecionada(Peca selecionada) {
		Tabuleiro.selecionada = selecionada;
	}

	@Override
	public void addObserver(Observer o) {
		lob.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		lob.remove(o);
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		Object dados[] = new Object[2];
		dados[0] = this.getDisposicaoPecas();
		dados[1] = this.coordUpgrade;
		this.coordUpgrade = null;
		return dados;
	}

	public void setDisposicaoPecas(List<List<Object>> disposicaoPecas) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				casas[x][y].setPeca(null);
			}
		}
		for(List<Object> lst: disposicaoPecas) {
			int x = Integer.parseInt((String) lst.get(0));
			int y = Integer.parseInt((String) lst.get(1));
			TiposPeca tipo = TiposPeca.valueOf((String) lst.get(2));
			Cor cor = Cor.valueOf((String) lst.get(3));
			casas[x][y].setPeca(tipo, cor);
		}
		
		for(Observer o:lob) {
			o.notify(this);
		}
	}
	
    /*
    public static void main(String[] args) {
    	selecionada = new Torre(Cor.BRANCO);
    	selecionada.movimentoValido(10, 231);
    }
    */
	
}