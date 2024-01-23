package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parola = this.txtParola.getText();
    	
    	if(parola.isEmpty()) {
    		this.txtResult.setText("Non hai inserito alcuna parola!");
    		return;
    	}
    	
    	double start = System.nanoTime();
    	
    	elenco.addParola(parola);
    	
    	double stop = System.nanoTime();
    	
    	this.txtResult.clear();
    	
    	for(String p : elenco.getElenco()) {
    		this.txtResult.appendText(p + "\n");
    	}
    	
    	txtTime.clear();
    	
    	txtTime.setText("[INSERT]: " + (stop - start) + " nanoseconds");
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	
    	elenco.reset();

    	double stop = System.nanoTime();
    	
    	txtTime.clear();
    	
    	txtTime.setText("[RESET]: " + (stop - start) + " nanoseconds");
    	
    	
    	this.txtParola.clear();
    	this.txtResult.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String parola = this.txtParola.getText();
    	
    	if(parola.isEmpty()) {
    		this.txtResult.setText("Non hai inserito alcuna parola!");
    		return;
    	}
    	
    	double start = System.nanoTime();
    	
    	elenco.removeParola(parola);

    	double stop = System.nanoTime();
    	
    	this.txtResult.clear();
    	
    	for(String p : elenco.getElenco()) {
    		this.txtResult.appendText(p + "\n");
    	}
    	
    	txtTime.clear();
    	
    	txtTime.setText("[REMOVE]: " + (stop - start) + " nanoseconds");

    }

    @FXML
    void initialize() {
    	assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
