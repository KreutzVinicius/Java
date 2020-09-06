package sistema;

import java.util.ArrayList;

import dados.Ano;


public class AgendaComposite implements Agenda{
	private ArrayList<Agenda> agenda = new ArrayList<Agenda>();

	@Override
	public void showAgenda() {
		for (Agenda evento : agenda) {
			evento.showAgenda();
		}
	}
	
	public void addEvento(Ano ano) {
		agenda.add(ano);
	}

	public void removeEvento (Agenda evento) {
		agenda.remove(evento);
	}
}
