package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button button1;
    @FXML
    private TextArea textArea1;
    @FXML
    private TextField textField1;

    public void setButton1(ActionEvent event) {
        String string;
        Translator translator;
        string = textField1.getText();
        translator = new Translator(string.toCharArray());
        textArea1.setText(translator.translate());
    }
}
