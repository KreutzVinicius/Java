package dados;

public enum TipoGerador {
	ABUNDANTE(1), FATORIAl (2), FIBONACCI(3), NATURAl (4), PRIMO(5), PERFEITO(6), QUADRADO(7);
	
	public int tipo;
TipoGerador(int tipo) {
	this.tipo = tipo;
}

public int getTipo() {
	return tipo;
}
}
