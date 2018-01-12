package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorController
{
    @FXML
    TextField tfDisplay;


    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    @FXML
    public void initialize() {
        MathEngineUtility meu = new MathEngineUtility();
        System.out.println(meu.infixToPreFix("3 + 2 + 1"));
    }


    @FXML private void handleBTNOnAction(ActionEvent actionEvent)
    {
        //Button tempButton = (Button)actionEvent.getSource();

        //tfDisplay.appendText(tempButton.getText());
        //checkInput(tfDisplay.getText());


    }

    private String checkInput(String displayString)
    {
        try
        {
            System.out.println(engine.eval(displayString));
        }
        catch (ScriptException ex)
        {
            System.out.println(ex.toString());
        }

        return displayString;
    }


}
