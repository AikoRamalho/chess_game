package model;

class Casa {
	private Peca peca;
	private int x;
	private int y;
	
	public Casa(int x, int y, Peca peca)
	{
		this.setX(x);
		this.setY(y);
		this.setPeca(peca);
	}
	

	public void ocupaCasa(Peca peca){
        if(this.peca != null) {
           this.peca.setEstado();
        }
        
        this.peca = peca;
    }

	public Peca getPeca() {
		return peca;
	}
	
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
