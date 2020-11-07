package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameTabuleiro extends JFrame {
	public final int LARG_DEFAULT=640+18;
	public final int ALT_DEFAULT=640+41;
	
	public FrameTabuleiro() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int x=sl/2-LARG_DEFAULT/2;
		int y=0;
		
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tabuleiro");
		getContentPane().add(new PainelTabuleiro());
	}
	
//	public static void main(String[] args) {
//		new FrameTabuleiro().setVisible(true);
//	}
}
