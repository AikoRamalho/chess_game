package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import common.Cor;
import common.TiposPeca;

class ListaImagens {
	public static ListaImagens staticListaImagens = null;
	private Image []brancas=new Image[6];
	private Image []pretas=new Image[6];
	
	public static ListaImagens getInstance() {
		if(staticListaImagens != null)
			return staticListaImagens;
		
		staticListaImagens = new ListaImagens();
		return staticListaImagens;
	}
	
	private ListaImagens() {
		try {
			brancas[0] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanB.png"));
			pretas[0] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleB.png"));
			
			brancas[1] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanK.png"));
			pretas[1] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleK.png"));
			
			brancas[2] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanN.png"));
			pretas[2] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleN.png"));
			
			brancas[3] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanP.png"));
			pretas[3] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleP.png"));
			
			brancas[4] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanQ.png"));
			pretas[4] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleQ.png"));
			
			brancas[5] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/CyanR.png"));
			pretas[5] = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Pecas/Pecas_2/PurpleR.png"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	Image []getBrancas() { return brancas; }
	Image []getPretas() { return pretas; }
	
	Image getImage(TiposPeca tipo, Cor cor) {
			if(cor == Cor.BRANCO) {
				return brancas[tipo.getValue()];
			} else {
				return pretas[tipo.getValue()];
			}
	}
}
