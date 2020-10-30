package model;

public class tempMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tabuleiro tb = new Tabuleiro();
		tb.getTabuleiro();
		tb.setTabuleiro();
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.println(tb.mPecas[i][j]);				
			}
		}
	}

}
