/*
 * Copy Right Paul Farr - Aug 19, 2016
 * I don't believe in intellectual property rights,
 * So do what ever you want, I'm not responsible for anything bad.
 */
package practicefx_doing_stuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PaulFarr
 *
 * I'm making a binary converter form my old CIS 143
 */
public class PracticeFX_Doing_stuff extends Application
{
    Button btnTobinary;
    Button btnToDec;
    TextField txtBinary;
    TextField txtDec;
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Creating Objs
        btnToDec = new Button("To Dec");
        btnTobinary = new Button("To Binary");
        txtBinary = new TextField();
        txtDec = new TextField();
        
        //add action liseners 
        btnToDec.setOnAction(e ->{
            
            try
            {
                txtDec.setText(Integer.toString(Integer.parseInt( txtBinary.getText(), 2)));
            }
            catch (Exception o)
            {
                System.out.println("Didn't Work");
                txtDec.setText("Error");
            }    
        });
        
        btnTobinary.setOnAction(e ->{
            
            try
            {
                txtBinary.setText(Integer.toBinaryString(Integer.parseInt(txtDec.getText())));
            }
            catch (Exception o)
            {
                System.out.println("Didn't Work");
                txtBinary.setText("Error");
            }
        });
        
        //creating layouts
        VBox layEverything = new VBox();
        
        //adding stuff to lable
        layEverything.getChildren().addAll(addLabel("Binary", txtBinary), btnTobinary, btnToDec, addLabel("Dec", txtDec));
        
        //adding layout to scene
        Scene myScene = new Scene(layEverything, 250, 110);
        
        //adding scene to Stage
        primaryStage.setScene(myScene);
        
        //Done :)
        primaryStage.setTitle("Binary Converter");
        primaryStage.show();
    }

    //My little Wraper class to add a label before stuff
    private HBox addLabel(String label, Control thing)
    {
        HBox myHBox = new HBox();
        myHBox.getChildren().addAll(new Label(label), thing);
        
        return myHBox;
    }
}
