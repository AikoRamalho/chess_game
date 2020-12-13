package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

import controller.Controller;
import model.ModelFacade;

public class FrameTabuleiro extends JFrame {
	public final int LARG_DEFAULT=560+18;
	public final int ALT_DEFAULT=560+41;
	
	public FrameTabuleiro(File arquivoLoad) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int x=sl/2-LARG_DEFAULT/2;
		int y=0;
		
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tabuleiro");
		
		getContentPane().add(new PainelTabuleiro(this));
		Controller.getInstance().iniciaTabuleiro();
		if(arquivoLoad != null) Controller.getInstance().carregaJogo(arquivoLoad);
	}
}
