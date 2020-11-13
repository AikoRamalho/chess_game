package view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import common.Cor;
import common.Observable;
import common.Observer;
import common.TiposPeca;
import model.ModelFacade;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;


public class PainelTabuleiro extends JPanel implements MouseListener, Observer {
	private Celula [][] celulas = new Celula[8][8];
	private final double ladoRetangulo = 70.0;
	private int[] pecaSelecionada = null;
	ModelFacade facade = ModelFacade.getInstance();// talvez seja melhor o controller
	Observable obs;
	Object lob[];
	List<List<Object>> dispPecas = new ArrayList<>();
	
	public PainelTabuleiro() {
		addMouseListener(this);
		facade.register(this);
		this.setCelulas(this.ladoRetangulo);
	}
	
	private void setCelulas(double lado) {
		// Notar que a posicao (0,0) é a superior esquerda, 7-linha necessario para ajustar.
		for(int x = 0; x<8; x++) {
			double leftX=lado*x;
			for(int y = 0; y<8; y++) {
				double topY=lado*y;
				if(x%2 == 0) {
					if(y%2 == 0)
						celulas[x][y] = new Celula(leftX,topY,Color.WHITE);
					else
						celulas[x][y] = new Celula(leftX,topY,new Color(192, 192, 192));
				}
				else {
					if(y%2 == 0)
						celulas[x][y] = new Celula(leftX,topY,new Color(192, 192, 192));
					else
						celulas[x][y] = new Celula(leftX,topY,Color.WHITE);
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		
		this.drawRetangulos(g2d);
//		this.drawImage(g2d, 1, 5, TiposPeca.PEAO, Cor.BRANCO); // Teste
		this.drawAllImages(g2d);
	}
	
	private void drawRetangulos(Graphics2D g2d) {
		// Define area do retangulo
		double larg=this.ladoRetangulo;
		double alt=this.ladoRetangulo;

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
	
	// Desenha uma unica image, de acordo com seu tipo e cor, na posicao (linha, coluna)
	// Notar que a posicao (0,0) é a superior esquerda, 7-y necessario para ajustar.
	private void drawImage(Graphics2D g2d, int x, int y, TiposPeca tipo, Cor cor) {
		ListaImagens li = ListaImagens.getInstance();
		g2d.drawImage(li.getImage(tipo, cor),
				(x)*(int)ladoRetangulo,
				(7-y)*(int)ladoRetangulo,65,65,null);
	}
	
	private void drawAllImages(Graphics2D g2d) {
		for(List<Object> obj : dispPecas) {
			this.drawImage(g2d,(int)obj.get(0),(int)obj.get(1),
					(TiposPeca)obj.get(2),(Cor)obj.get(3));
		}
	}
	
	private void marcaMovimentosValidos(List<List<Integer>> movimentos) {
		for(List<Integer> mov: movimentos) {
			// Talvez tenha que inverter
			int x = mov.get(0);
			int y = 7-mov.get(1);
			celulas[x][y].changeMarcada();
		}
		this.repaint();
	}
	
	private void desmarcaMovimentosValidos() {
		for(int x = 0; x<8;x++) {
			for(int y = 0;y<8;y++) {
				celulas[x][y].marcada = false;
			}
		}
		this.repaint();
	}
	
	// TODO: Aplicar a logica do jogo usando o Facade.
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {			
			int x=e.getX()/(int)ladoRetangulo;
			int y=e.getY()/(int)ladoRetangulo;
			y = 7-y;
			
			if(pecaSelecionada == null) { // Selecionando peca
				
				// Usar o facade para saber se a peca selecionada é valida,
				// caso seja, pedir os movimentos validos da peca,
				// usar marcaMovimentosValidos e pecaSelecionada = [linha, coluna].
				if(facade.selecionaPeca(x, y)) {
					this.marcaMovimentosValidos(
							facade.getMovimentosValidosDaPeca(x, y));
					pecaSelecionada = new int[2];
					pecaSelecionada[0] = x;
					pecaSelecionada[1] = y;
				}
				return;
			} else { // Selecionando casa
				// usar o facade para saber se a casa selecionada é valida,
				// ,caso seja, usar o facade para mover a peca.
				System.out.println(facade.selecionaCasa(x, y));
				if(facade.selecionaCasa(x, y)) {
//					System.out.printf("%d %d %d %d\n",pecaSelecionada[0],pecaSelecionada[1],
//							x,y);
					facade.movePecaDePara(pecaSelecionada[0],pecaSelecionada[1],
							x,y);
				}
				this.desmarcaMovimentosValidos();
				pecaSelecionada = null;
			}
//			pecaSelecionada = null;
//			desmarcaMovimentosValidos();			
//			this.repaint(); // Chama paintComponent() novamente
			
		} else if(SwingUtilities.isRightMouseButton(e)) {
			// TODO: continuar em futura iteracao
			JFileChooser jFileChooser = new JFileChooser();
        	int result = jFileChooser.showOpenDialog(new JFrame());
		}
		return;
	}
	
//	public void mouseClicked(MouseEvent e) {
//		if(SwingUtilities.isLeftMouseButton(e)) {			
//			int x = e.getX()/(int)this.ladoRetangulo;
//			int y = e.getY()/(int)this.ladoRetangulo;
//			
//			celulas[x][y].changeMarcada();
//			this.repaint(); // Chama paintComponent() novamente
//			
//		} else if(SwingUtilities.isRightMouseButton(e)) {
//			// TODO: continuar em futura iteracao
//			JFileChooser jFileChooser = new JFileChooser();
//        	int result = jFileChooser.showOpenDialog(new JFrame());
//		} else {
//			return;
//		}
//	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	@Override
	public void notify(Observable o) {
		obs=o;
		lob=(Object []) obs.get();
		dispPecas.clear();
		dispPecas = (List<List<Object>>) lob[0];		
		this.repaint();
	}
}
