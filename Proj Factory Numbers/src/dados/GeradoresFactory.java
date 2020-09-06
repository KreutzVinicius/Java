package dados;

public class GeradoresFactory {
	private static GeradoresFactory uniqueInstance;

	GeradoresFactory(){
	}
	
	public static synchronized GeradoresFactory getInstance() {
		if (uniqueInstance == null) 
			uniqueInstance = new GeradoresFactory();
		return uniqueInstance;
	}
	
	public Gerador create(String TipoGerador) {
		if (TipoGerador == null ) {
			return null;
		}
		if (TipoGerador.equalsIgnoreCase("ABUNDANTE")){
			return new Abundantes();
		} else if (TipoGerador.equalsIgnoreCase("FATORIAL")){
			return new Fatoriais();
		} else if (TipoGerador.equalsIgnoreCase("FIBONACCI")){
			return new Fibonacci();
		} else if (TipoGerador.equalsIgnoreCase("NATURAL")){
			return new Naturais();
		} else if (TipoGerador.equalsIgnoreCase("PRIMO")){
			return new NumeroPrimos();
		} else if (TipoGerador.equalsIgnoreCase("PERFEITO")){
			return new Perfeitos();
		} else if (TipoGerador.equalsIgnoreCase("QUADRADO")){
			return new Quadrados();
		}
		
		return null;
	}
}
