/**
 * Sample Skeleton for 'iscrittiT1.fxml' Controller Class
 */

package it.polito.esame;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.esame.bean.Corso;
import it.polito.esame.bean.Studente;
import it.polito.esame.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class IscrittiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="x1"
    private Color x1; // Value injected by FXMLLoader

    @FXML // fx:id="btnElencoCorsi"
    private Button btnElencoCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudentiSimili"
    private Button btnStudentiSimili; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    private Model model = new Model();

    @FXML
    void handleElenco(ActionEvent event) {
    	try {
    		int matricola = Integer.parseInt(this.txtMatricola.getText());
    		
    		if(matricola < 0)
    			throw new IllegalArgumentException();
    		
    		Studente s = model.getInfoStudente(matricola);
    		
    		this.txtResult.setText("Studente: "+s.getCognome() + " " +s.getNome() + "\n");
    		for(Corso c : s.getCaricodidattico()) {
    			this.txtResult.appendText(c.getNome()+"\n");
    			
    		}
    		
    	} catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero di matricola valido\n");
    	} catch(NullPointerException e) {
    		this.txtResult.setText("La matricola inserita non corrisponde a nessuno studente\n");
    	} catch(IllegalArgumentException e) {
    		this.txtResult.setText("La matricola non può essere un numero negativo\n");
    	}
    }

    @FXML
    void handleSimili(ActionEvent event) {
    	try {
    		int matricola = Integer.parseInt(this.txtMatricola.getText());
    		
    		//if(matricola < 0)
    		//	throw new IllegalArgumentException();
    		
    		Studente s = model.getInfoStudente(matricola);
    		
    		List<Studente> simili = model.getStudentiSimili(s);
    		
    		if(!simili.isEmpty()) {
    			this.txtResult.setText("Numero massimo di corsi comuni: " +simili.get(0).getNcorsi()+"\n");
        		
        		for(Studente st : simili)
        			this.txtResult.appendText(st.getCognome() + " " + st.getNome() +"\n");

    		}
    		
    	} catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero di matricola valido\n");
    	} catch(NullPointerException e) {
    		this.txtResult.setText("La matricola inserita non corrisponde a nessuno studente\n");
    	} catch(IllegalArgumentException e) {
    		this.txtResult.setText("La matricola non può essere un numero negativo\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'iscrittiT1.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'iscrittiT1.fxml'.";
        assert btnElencoCorsi != null : "fx:id=\"btnElencoCorsi\" was not injected: check your FXML file 'iscrittiT1.fxml'.";
        assert btnStudentiSimili != null : "fx:id=\"btnStudentiSimili\" was not injected: check your FXML file 'iscrittiT1.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'iscrittiT1.fxml'.";

    }
    
    void setModel(Model m) {
    	this.model = m;
    }
}


