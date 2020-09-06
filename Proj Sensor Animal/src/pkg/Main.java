package pkg;

public class Main {
		public static void main(String[] args) {
			Animal animal = new Animal();
			Posicao p1 = new Posicao();
			Posicao p2 = new Posicao();
			Posicao p3 = new Posicao();
			Posicao p4 = new Posicao();
			Sensor s1 = new Sensor();
			Sensor s2 = new Sensor();
			Sensor s3 = new Sensor();
			
			p1.setX(0);
			p1.setY(0);
			p2.setX(5);
			p2.setY(5);
			p3.setX(10);
			p3.setY(10);
			p4.setX(15);
			p4.setY(15);
			
			s1.setPosicaoSensor(p2);
			s2.setPosicaoSensor(p3);
			s3.setPosicaoSensor(p4);
			
			animal.setNome("cachorro");
			animal.setPosicao(p1);
			animal.adicionar(s1);
			animal.adicionar(s2);
			animal.adicionar(s3);
			animal.notificar();
			
			for(int i=0; i < 5; i++) {
				System.out.println("\nMovimentação " + i + ":");
				System.out.println(animal.getPosicao().toString());
				System.out.println("Distancia do s1 = " + s1.calcularDistancia());
				System.out.println("Distancia do s2 = " + s2.calcularDistancia());
				System.out.println("Distancia do s3 = " + s3.calcularDistancia());
				
				animal.movimentar();
				
				System.out.println("Se moveu para "+animal.getPosicao().toString());
				System.out.println("Distancia do s1 = " + s1.calcularDistancia());
				System.out.println("Distancia do s2 = " + s2.calcularDistancia());
				System.out.println("Distancia do s3 = " + s3.calcularDistancia());
		
		}                                                          
	}
}
