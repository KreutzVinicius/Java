package sistema;

import dados.Ano;
import dados.Dia;
import dados.Evento;
import dados.Mes;

public class Main {
	public static void main(String[] args) {
		AgendaComposite agenda = new AgendaComposite();
		
		Ano ano1 = new Ano(2021);
		Mes mes1 = new Mes(05, "Maio");
		Dia dia1 = new Dia(25, "Terca");
		Evento evento1 = new Evento(1400, "meu aniversario");
		
		Ano ano2 = new Ano(2021);
		Mes mes2 = new Mes(05, "Maio");
		Dia dia2 = new Dia(25, "Terca");
		Evento evento2 = new Evento(2000, "jantar com amigos");
		
		Ano ano3 = new Ano(2022);
		Mes mes3 = new Mes(05, "Maio");
		Dia dia3 = new Dia(25, "Terca");
		Evento evento3 = new Evento(1400, "meu aniversario");
		
		Ano ano4 = new Ano(2022);
		Mes mes4 = new Mes(05, "Dezembro");
		Dia dia4 = new Dia(25, "Domingo");
		Evento evento4 = new Evento(1200, "natal");
		
		Ano ano5 = new Ano(2023);
		Mes mes5 = new Mes(01, "Janeiro");
		Dia dia5 = new Dia(01, "Segunda");
		Evento evento5 = new Evento(0001, "ano novo");
		
		
		
		ano1.getMeses().add(mes1);
		mes1.getDias().add(dia1);
		dia1.getEventos().add(evento1);
		agenda.addEvento(ano1);
		ano1.showAgenda();
		
		ano2.getMeses().add(mes2);
		mes2.getDias().add(dia2);
		dia2.getEventos().add(evento2);
		agenda.addEvento(ano2);
		ano2.showAgenda();
		
		ano3.getMeses().add(mes3);
		mes3.getDias().add(dia3);
		dia3.getEventos().add(evento3);
		agenda.addEvento(ano3);
		ano3.showAgenda();
		
		ano4.getMeses().add(mes4);
		mes4.getDias().add(dia4);
		dia4.getEventos().add(evento4);
		agenda.addEvento(ano4);
		ano4.showAgenda();
		
		ano5.getMeses().add(mes5);
		mes5.getDias().add(dia5);
		dia5.getEventos().add(evento5);
		agenda.addEvento(ano5);
		ano5.showAgenda();
		
	}
}
