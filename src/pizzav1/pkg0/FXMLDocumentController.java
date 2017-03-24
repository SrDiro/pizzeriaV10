package pizzav1.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane fondoTab1;
    @FXML
    private AnchorPane fondoTab2;
    @FXML
    private AnchorPane fondoTab3;
    @FXML
    private AnchorPane fondoTab4;
    @FXML
    private Tab tab2;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane paneMasa;
    @FXML
    private Label labelMasa;
    @FXML
    private Pane paneTipoPizza;
    @FXML
    private Label labelTipoPizza;
    @FXML
    private Pane paneIngredientes;
    @FXML
    private Label labelIngredientes;
    @FXML
    private Pane paneTamano;
    @FXML
    private Label labelTamano;
    @FXML
    private RadioButton rbNormal;
    @FXML
    private RadioButton rbIntegral;
    @FXML
    private ToggleGroup tiposPizza;
    @FXML
    private Pane panePedido;
    @FXML
    private Label labelPrueba;
    @FXML
    private ComboBox<String> cbTipoPizza;
    @FXML
    private ListView<String> lvIngredientes;
    
    
    //MIS ATRIBUTOS
    private double precioMasa = 0.0, precioTipo = 0.0;
    ObservableList<String> listaTipoPizzas = FXCollections.observableArrayList("Básica", "Cuatro Quesos", "Barbacoa", "Mexicana");
    ObservableList<String> listaIngredientes = FXCollections.observableArrayList("Sin ingredientes", "Jamón", "Queso", "Tomate", "Cebolla", "Olivas");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTipoPizza.setItems(listaTipoPizzas);
        cbTipoPizza.setValue("Tipo...");
        lvIngredientes.setItems(listaIngredientes);        
    }

    @FXML
    private void tipoMasa(ActionEvent event) {
        if (rbNormal.isSelected()) {
            precioMasa = 9.00;
            labelPrueba.setText(precioMasa + "");
        } else if (rbIntegral.isSelected()) {
            precioMasa = 9.50;
            labelPrueba.setText(precioMasa + "");
        }
    }

    @FXML
    private void tipoPizza(ActionEvent event) {
        String tipo;
        tipo = cbTipoPizza.getValue();

        if (tipo.equalsIgnoreCase("Básica")) {
            precioTipo = 3.0;
        } else if (tipo.equalsIgnoreCase("Cuatro Quesos")) {
            precioTipo = 5.0;
        } else if (tipo.equalsIgnoreCase("Barbacoa")) {
            precioTipo = 7.0;
        } else if (tipo.equalsIgnoreCase("Mexicana")) {
            precioTipo = 8.5;
        }

    }

    @FXML
    private void tipoIngredientes(MouseEvent event) {
    }

}
