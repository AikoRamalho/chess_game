package common;

public enum TiposPeca {
	PEAO(3), CAVALO(2), BISPO(0), TORRE(5), RAINHA(4), REI(1);
	
	private final int value;
	private TiposPeca(int value) {
		this.value = value;
	}
	
	public int getValue() {
        return value;
    } 
}
