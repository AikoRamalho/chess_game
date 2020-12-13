package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public void resultadoSelecaoPromocao(TiposPeca tipo) {
		ctrl.facade.melhorarPeao(tipo);
	}
	
	public void iniciaJogo() {
		ctrl.frame = new FrameInicial();
		ctrl.frame.setVisible(true);
	}
	
	// Seta ambos os jogadores, nome da funcao talvez nao seja o melhor possivel.
	public void iniciaPartida() {
		ctrl.facade.setPartida("Jogador Azul", "Jogador Roxo");
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
	
	public void carregaJogo(File arquivoLoad) {
		List<List<Object>> listOfList = new ArrayList<List<Object>>();
		String nomeJogador = "";
		try(
			Scanner file = new Scanner(arquivoLoad)
		) {
			nomeJogador = file.nextLine();
			while (file.hasNext()) {
				List<Object> innerList = new ArrayList<>();
				String line = file.nextLine();
				line = line.replace("[", "").replace("]", "").replace(" ", "");
				String[] arr = line.split(",");
				innerList.add(arr[0]);
				innerList.add(arr[1]);
				innerList.add(arr[2]);
				innerList.add(arr[3]);
				listOfList.add(innerList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		facade.carregaPartida(nomeJogador, listOfList);
	}

	public static void main(String[] args) {
		Controller ctrl = Controller.getInstance();
		ctrl.iniciaJogo();
	}

}