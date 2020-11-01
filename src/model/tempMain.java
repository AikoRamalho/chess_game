package model;

import common.Cor;

public class tempMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tabuleiro tb = Tabuleiro.getTabuleiro();
//		tb.setTabuleiro();
		
		tb.mPecas[2][3] = new Rei(Cor.BRANCO,2,3);
//		tb.mPecas[3][5] = new Cavalo(Cor.PRETO,2,2);
//		tb.mPecas[0][2] = new Rainha(Cor.PRETO,0,6);
		
//		for(int linha = 0; linha < 8; linha++) {
//			for(int coluna = 0; coluna < 8; coluna++) {
//				System.out.println(tb.mPecas[linha][coluna]);				
//			}
//		}
		
		
		System.out.println("Ta em xeque: " + ((Rei) tb.mPecas[2][3]).isXeque());
//		System.out.println(tb.mPecas[2][3] instanceof Rei);
	}

}