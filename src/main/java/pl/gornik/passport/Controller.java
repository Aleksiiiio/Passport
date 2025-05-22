package pl.gornik.passport;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private RadioButton eyeBlueRadio;

    @FXML
    private ToggleGroup eyecolor;

    @FXML
    private RadioButton eyeGreenRadio;

    @FXML
    private RadioButton eyeBrownRadio;

    @FXML
    private ImageView personImage;

    @FXML
    private ImageView fingerprintImage;

    @FXML
    private Button okButton;
    List<String> peopleImages = new ArrayList<>();
    List<String> fingerprintImages = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        peopleImages.add("000-zdjecie.jpg");
        peopleImages.add("111-zdjecie.jpg");
        peopleImages.add("333-zdjecie.jpg");
        fingerprintImages.add("000-odcisk.jpg");
        fingerprintImages.add("111-odcisk.jpg");
        fingerprintImages.add("333-odcisk.jpg");


        numberTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
               for (String src : peopleImages){
                   if (src.contains(numberTextField.getText())) {
                       personImage.setImage(new Image(src));
                       break;
                   }
                   else personImage.setImage(null);
               }
               for (String src : fingerprintImages){
                   if (src.contains(numberTextField.getText())) {
                       fingerprintImage.setImage(new Image(src));
                       break;
                   }
                   else fingerprintImage.setImage(null);
               }
            }
        });

        okButton.setOnAction(actionEvent ->  {
            Alert alert = null;
            RadioButton eyeColorData = (RadioButton) eyecolor.getSelectedToggle();
                if (!numberTextField.getText().isEmpty()
                        && !firstnameTextField.getText().isEmpty()
                        && !lastnameTextField.getText().isEmpty()
                        && (eyeBlueRadio.isSelected() || eyeGreenRadio.isSelected() || eyeBrownRadio.isSelected() )){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informacja");
                    alert.setContentText(firstnameTextField.getText()
                            +" "+lastnameTextField.getText()
                            +" kolor oczu "+eyeColorData.getText());
            } else if (firstnameTextField.getText().isEmpty() || lastnameTextField.getText().isEmpty()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Wprowadź dane");
                }
            alert.show();
        });


    }

}
