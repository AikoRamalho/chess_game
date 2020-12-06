package controller;

import common.TiposPeca;
import model.ModelFacade;
import view.FrameInicial;
import view.PainelTabuleiro;

public class Controller {
	public static Controller ctrl = null;
	ModelFacade facade;
	FrameInicial frame;
	PainelTabuleiro painel;
	
	public static Controller getInstance() {
		if(ctrl != null)
			return ctrl;
		
		ctrl = new Controller();
		ctrl.facade = ModelFacade.getInstance();
		return ctrl;
	}
	
	public void setPainel(PainelTabuleiro p) {
		ctrl.painel = p;
	}
	
	public void mostraSelecaoPromocao() {	
		ctrl.painel.mostraSelecaoPromocao();
	}
	
	public void resultadoSelecaoPromocao(TiposPeca tipo) {
		//TODO: vai no facade e avisa o tipo escolhido para a promocao do peao
	}
	
	public void iniciaJogo() {
		ctrl.frame = new FrameInicial();
		ctrl.frame.setVisible(true);
	}
	
	// Seta ambos os jogadores, nome da funcao talvez nao seja o melhor possivel.
	public void iniciaPartida() {
		ctrl.facade.setPartida("p1", "p2");
	}
	
	// Distribui as pecas, nome da funcao talvez nao seja o melhor possivel.
	public void iniciaTabuleiro() {
		ctrl.facade.iniciaPartida();
	}
	
	public void mostraDialogoReiniciaJogo(String nomeVencedor) {
		ctrl.painel.mostraDialogoVencedorFechaJogo(nomeVencedor);
	}
	
	public void reiniciaJogo() {
		ctrl.painel = null;
		ctrl.frame = new FrameInicial();
		ctrl.frame.setVisible(true);
	}

	public static void main(String[] args) {
		Controller ctrl = Controller.getInstance();
		ctrl.iniciaJogo();
	}

}
