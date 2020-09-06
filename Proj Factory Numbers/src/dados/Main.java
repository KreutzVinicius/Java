package dados;

public class Main {
	public static void main(String[] args) {
		GeradoresFactory creator = new GeradoresFactory();
		
		Gerador gerador1 = creator.create("ABUNDANTE");
		gerador1.gerar(3);
		System.out.println(gerador1.toString());
		
		Gerador gerador2 = creator.create("FATORIAL");
		gerador2.gerar(3);
		System.out.println(gerador2.toString());
		
		Gerador gerador3 = creator.create("NATURAL");
		gerador3.gerar(3);
		System.out.println(gerador3.toString());
		
		Gerador gerador4 = creator.create("FIBONACCI");
		gerador4.gerar(3);
		System.out.println(gerador4.toString());
		
		Gerador gerador5 = creator.create("PRIMO");
		gerador5.gerar(3);
		System.out.println(gerador5.toString());
	}

}
