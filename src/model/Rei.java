package model;

import common.Cor;

class Rei extends Peca {

	public Rei(Cor cor) {
		super(cor);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * boolean isChecked() {
	 //   /* Check straight lines */
	 //   for (directions) { // up, down, left and right
	 //       for (square in direction) { // square by square from the king and out in the current direction
	 //           if (square contains opponent rook or queen)
	 //               return true;
	 //           else if (square contains friendly piece)
	 //               continue;

	    /* Check diagonals */
	 //   for (directions) { // left-up, left-down, right-up and right-down
	 //       for (square in direction) { // square by square from the king and out in the current direction
	 //           if (square contains opponent bishop or queen)
	 //               return true;
	 //           else if (square contains friendly piece)
	 //               continue;

	    /* Check pawns */
	 //   if (squares where pawns would threaten the king contains pawns)
	 //       return true;

	    /* Check king, this is to find if a square is legal to move to only */
	//    if (squares where a king would threaten the king contains king)
	//        return true;

	    /* Check knights */
	//    if (squares where knights would threaten the king contains knights)
	//        return true;
	
	boolean isChecked () {
		Tabuleiro 
	}

}
