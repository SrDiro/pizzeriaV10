package pizzav1.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Tab tab2;
    @FXML
    private Pane cabecera;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cabecera.setStyle("-fx-background-images: url(file:///C:/Users/daw/Documents/NetBeansProjects/pizzaV1.0/img/cabecera.png");
    }    
    
    
}
