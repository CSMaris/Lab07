package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="NERCitem"
    private ChoiceBox<Nerc> NERCitem; // Value injected by FXMLLoader

    @FXML // fx:id="maxY"
    private TextField maxY; // Value injected by FXMLLoader

    @FXML // fx:id="maxH"
    private TextField maxH; // Value injected by FXMLLoader

    @FXML // fx:id="Worst"
    private Button Worst; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doWorst(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert NERCitem != null : "fx:id=\"NERCitem\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert maxY != null : "fx:id=\"maxY\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert maxH != null : "fx:id=\"maxH\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert Worst != null : "fx:id=\"Worst\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'PowerOutages.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		this.NERCitem.setItems(FXCollections.observableArrayList(model.getNercList()));
	}
}
