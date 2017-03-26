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
import javafx.scene.control.SpinnerValueFactory;
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
    @FXML
    private Spinner<String> spinnerTamano;
    
    //MIS ATRIBUTOS    
    ObservableList<String> listaTipoPizzas = FXCollections.observableArrayList("Basica", "Cuatro Quesos", "Barbacoa", "Mexicana");
    ObservableList<String> listaIngredientes = FXCollections.observableArrayList("Sin extra", "Jamon", "Queso", "Tomate", "Cebolla", "Olivas", "Picante");
    ObservableList<String> listaTamanos = FXCollections.observableArrayList("Grande", "Mediana", "Pequeña");
    ObservableList<String> list = FXCollections.observableArrayList();
    
    String tipoMasa = "", tipoPizza = "", tamano = "";
    private Pizza p1;
    private Pizza pizza;
    
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTipoPizza.setItems(listaTipoPizzas);
        cbTipoPizza.setValue("Tipo...");
        lvIngredientes.setItems(listaIngredientes);
                
        lvIngredientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        paneFuego.setVisible(false);
        
        //SPINNER (Hecho por mi)
        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(listaTamanos);        
        spinnerTamano.setValueFactory(valueFactory);        
        valueFactory.setValue("Pequeña");
//        spinnerTamano.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        
//        Posiciones de las flechas de seleccion en el Spinner
//        STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL
//        STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL
//        STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL
//        STYLE_CLASS_SPLIT_ARROWS_VERTICAL
//        STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL        
        
    }
    
    // Nuestros productos
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
    
    //Pizza al gusto
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

    @FXML
    private void tipoIngredientes(MouseEvent event) {

        paneFuego.setVisible(false);
        p1 = new Pizza(tipoMasa, tipoPizza, tamano);
        ObservableList<String> selectedItems = lvIngredientes.getSelectionModel().getSelectedItems();

        for (String ingrediente : selectedItems) {
            p1.preciosExtra.put(ingrediente, p1.buscarPrecio(ingrediente));
            if (ingrediente.equalsIgnoreCase("Picante")) {
                paneFuego.setVisible(true);
            }

        }

        labelPrueba.setText(p1.calcularPrecio() + "");

    }

    @FXML
    private void tamano(MouseEvent event) {
        tamano = spinnerTamano.getValue();
        p1 = new Pizza(tipoMasa, tipoPizza, tamano);
        
        labelPrueba.setText(p1.calcularPrecio() + "");
    }

}
