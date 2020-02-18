/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps;

import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class ListViewApp extends Application{
    private ListView<String> listViewNames;
    private TextField textFieldName;
    private Button buttonAdd;
    @Override
    public void start(Stage primaryStage) throws Exception {
        listViewNames = new ListView<>();
        textFieldName = new TextField();
        buttonAdd = new Button("Add Name");
        VBox vBox = new VBox(10, listViewNames,textFieldName,buttonAdd);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,260,300);
//        EventHandler1 eventHandler1 = new EventHandler1();
//        buttonAdd.setOnAction(eventHandler1);
//        buttonAdd.setOnAction(new EventHandler<ActionEvent>() { //Using Anonymous class
//            @Override
//            public void handle(ActionEvent event) {
//                if(event.getSource() == buttonAdd) //Checking the event source
//                if(!textFieldName.getText().equals(""))
//                    listViewNames.getItems().add(textFieldName.getText());
//                textFieldName.setText("");
//                listViewNames.getItems().setAll(
//                        listViewNames.getItems().stream()
//                        .sorted()
//                        .collect(Collectors.toList())
//                );
//            }
//        });
//
//        buttonAdd.setOnAction(event->{ //Using Lambda
//            if(event.getSource() == buttonAdd) //Checking the event source
//                if(!textFieldName.getText().equals(""))
//                    listViewNames.getItems().add(textFieldName.getText());
//                textFieldName.setText("");
//                listViewNames.getItems().setAll(
//                        listViewNames.getItems().stream()
//                        .sorted()
//                        .collect(Collectors.toList())
//                );
//        });
        EventHandler2 eventHandler2 = new EventHandler2();
        //Using addEventHandler
        //buttonAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler2);
        //buttonAdd.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler2);
        // or Using addEventFilter
        buttonAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
        buttonAdd.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler2);
        
        primaryStage.setTitle("ListView JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    // to be used for setOnAction
    private class EventHandler1 implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) { //implement event handling using ActionEvent calss 
            if(event.getSource() == buttonAdd) //Checking the event source
                if(!textFieldName.getText().equals(""))
                    listViewNames.getItems().add(textFieldName.getText());
                textFieldName.setText("");
                listViewNames.getItems().setAll(
                        listViewNames.getItems().stream()
                        .sorted()
                        .collect(Collectors.toList())
                );
        }    
    }
    
    //to be used by addEventHandler and addEventFilter
    private class EventHandler2 implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
             event.consume();
            if(event.getSource() == buttonAdd) //Checking the event source
                if(!textFieldName.getText().equals(""))
                    listViewNames.getItems().add(textFieldName.getText());
                textFieldName.setText("");
                listViewNames.getItems().setAll(
                        listViewNames.getItems().stream()
                        .sorted()
                        .collect(Collectors.toList())
                );

           
        }
        
    }
}
