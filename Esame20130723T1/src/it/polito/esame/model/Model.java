package it.polito.esame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import it.polito.esame.bean.Corso;
import it.polito.esame.bean.Studente;
import it.polito.esame.dao.IscrittiDAO;

public class Model {
	
	private List<Studente> studenti ;
	private IscrittiDAO dao ;
	private Graph<Studente, DefaultWeightedEdge> graph ;
	private StudenteIdMap studenteIdMap ;
	
	public Model() {
		studenteIdMap = new StudenteIdMap();
	}

	public Studente getInfoStudente(int matricola) {
		dao = new IscrittiDAO();
		
		Studente s = dao.getStudenteByMatricola(matricola, studenteIdMap);
		
		List<Corso> corsi = dao.getCorsiByStudente(s);

		if(!corsi.isEmpty())
			for(Corso c:corsi)
				s.addCorso(c);
		return s;
	}

	public List<Studente> getStudentiSimili(Studente s) {
		
		dao = new IscrittiDAO();
		
		List<Studente> result = dao.getStudentiSimili(s, studenteIdMap);
		
		List<Studente> simili = new ArrayList<>();
		
		int max = maxN(result);
		
		for(Studente st : result) {
			if(st.getNcorsi() == max)
				simili.add(st);
		}
		
		Collections.sort(simili);
		
		return simili;
	}

	private int maxN(List<Studente> simili) {
		int max = 0;
		for(Studente s : simili)
			if(s.getNcorsi() > max)
				max = s.getNcorsi();
		return max ;
	}

	

}
