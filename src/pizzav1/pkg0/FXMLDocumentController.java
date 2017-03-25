package pizzav1.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Spinner<String> spinnerPrueba ;
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
    @FXML
    private Pane paneFuego;
    private Button comprarCuatroQuesos;
    @FXML
    private Label labelTotal;
    @FXML
    private CheckBox cbCuatroQuesos;
    @FXML
    private CheckBox cbBarbacoa;
    @FXML
    private CheckBox cbMargarita;
    @FXML
    private Button finalizarCompra;
    
    //MIS ATRIBUTOS    
    ObservableList<String> listaTipoPizzas = FXCollections.observableArrayList("Básica", "Cuatro Quesos", "Barbacoa", "Mexicana");
    ObservableList<String> listaIngredientes = FXCollections.observableArrayList("Sin extra", "Jamón", "Queso", "Tomate", "Cebolla", "Olivas", "Picante");
    ObservableList<String> list = FXCollections.observableArrayList();
    
    String tipoMasa = "", tipoPizza = "", tamano = "";
    private Pizza p1;
    @FXML
    private Spinner<?> spinner;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTipoPizza.setItems(listaTipoPizzas);
        cbTipoPizza.setValue("Tipo...");
        lvIngredientes.setItems(listaIngredientes);

        lvIngredientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        paneFuego.setVisible(false);       
        
    }

    @FXML
    private void tipoMasa(ActionEvent event) {
        if (rbNormal.isSelected()) {
            tipoMasa = "Normal";
        } else if (rbIntegral.isSelected()) {
            tipoMasa = "Integral";
        }
        p1 = new Pizza(tipoMasa, tipoPizza, tamano);
        labelPrueba.setText(p1.calcularPrecio() + "");

    }

    @FXML
    private void tipoPizza(ActionEvent event) {

        tipoPizza = cbTipoPizza.getValue();
        p1 = new Pizza(tipoMasa, tipoPizza, tamano);
        labelPrueba.setText(p1.calcularPrecio() + "");

    }

//    @FXML
//    private void tipoIngredientes(MouseEvent event) {
//
//        paneFuego.setVisible(false);
//
//        ObservableList<String> selectedItems = lvIngredientes.getSelectionModel().getSelectedItems();
//
//        for (String ingrediente : selectedItems) {
//            p1.precios.put(ingrediente, Double.NaN);
//            
//            if (ingrediente.equalsIgnoreCase("Picante")) {
//                paneFuego.setVisible(true);
//            }
//
//        }
//
//        labelPrueba.setText(pizza.calcularPrecio() + "");
//
//    }
    
    

    @FXML
    private void comprarPizza(ActionEvent event) {
        double total, precioCuatroQuesos = 0.0, precioBarbacoa = 0.0, precioMargarita = 0.0;
        if (cbCuatroQuesos.isSelected()) {
            precioCuatroQuesos = 11.50;
        }
        if (cbBarbacoa.isSelected()) {
            precioBarbacoa = 10.50;
        }
        if (cbMargarita.isSelected()) {
            precioMargarita = 9.95;
        }

        total = precioCuatroQuesos + precioBarbacoa + precioMargarita;

        if (total == 0.0) {
            labelTotal.setText("0€");
        } else {
            labelTotal.setText(total + "€");
        }

    }

    @FXML
    private void tipoIngredientes(MouseEvent event) {
    }

}
