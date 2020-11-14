package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import model.ModelFacade;

public class FrameInicial extends JFrame implements ActionListener {
	public final int LARG_DEFAULT=400;
	public final int ALT_DEFAULT=300;
	
	
	public FrameInicial() {
		JButton btnNovaPartida = new JButton("Nova partida");
		JButton btnCarregarPartida = new JButton("Carregar partida");
		JPanel p = new JPanel();
		
		btnNovaPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCarregarPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(btnNovaPartida);
		p.add(btnCarregarPartida);
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnNovaPartida.addActionListener(this);
		btnNovaPartida.setActionCommand("novo");
		btnCarregarPartida.addActionListener(this);
		btnCarregarPartida.setActionCommand("carrega");
		
		setTitle("Tela Inicial");
		p.setBackground(Color.WHITE);
		getContentPane().add(p);	
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("novo")) {
			this.dispose();
			Controller.getInstance().iniciaPartida();
	    	new FrameTabuleiro().setVisible(true);
						
        } else if (command.equals("carrega")) {
        	JFileChooser jFileChooser = new JFileChooser();
        	int result = jFileChooser.showOpenDialog(new JFrame());
        	// TODO: continuar em futura iteracao
        }
	}
	
//	public static void main(String[] args) {    	
//		new FrameInicial().setVisible(true);
//	}
}
