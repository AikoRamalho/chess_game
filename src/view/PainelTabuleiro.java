package view;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;


public class PainelTabuleiro extends JPanel implements MouseListener {
	private Celula [][] celulas = new Celula[8][8];
	
	public PainelTabuleiro() {
		addMouseListener(this);
		
		// Notar que a posicao (0,0) é a superior esquerda, 7-linha necessario para ajustar.
		for(int linha = 0; linha<8; linha++) {
			double topY=80.0*linha;
			for(int coluna = 0; coluna < 8; coluna++) {
				double leftX=80.0*coluna;
				if(coluna%2 == 0) {		
					if(linha%2 == 0) {
						celulas[7-linha][coluna] = new Celula(leftX,topY,Color.WHITE);
					}
					else {
						celulas[7-linha][coluna] = new Celula(leftX,topY,Color.BLACK);
					}
				}
				else {
					if(linha%2 == 0) {
						celulas[7-linha][coluna] = new Celula(leftX,topY,Color.BLACK);
					}
					else {
						celulas[7-linha][coluna] = new Celula(leftX,topY,Color.WHITE);
					}
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		
		// Define area do retangulo
		double larg=80.0;
		double alt=80.0;

		// Desenha os retângulos
		for(int linha = 0; linha<8; linha++) {
			for(int coluna = 0; coluna < 8; coluna++) {
				Celula celula = celulas[linha][coluna];
				Rectangle2D rt=new Rectangle2D.Double(celula.getX(),celula.getY(),larg,alt);
				// Pinta o retangulo
				g2d.setPaint(celula.getCor());
				g2d.fill(rt);
				// Desenha a borda do retangulo
				g2d.setPaint(Color.BLACK);
				g2d.draw(rt);
			}
		}
	}
	
	// TODO: Aplicar a logica do jogo usando o Facade.
	public void mouseClicked(MouseEvent e) {
		int x=e.getX(),y=e.getY();
		int linha = 7-y/80;
		int coluna = x/80;

//		System.out.printf("linha: %d, coluna:%d\n",linha,coluna);
		celulas[linha][coluna].changeMarcada();
		this.repaint(); // Chama paintComponent() novamente
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
