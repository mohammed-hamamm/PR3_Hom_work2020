/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class ListViewApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> listViewNames = new ListView<>();
        TextField textFieldName = new TextField();
        Button buttonAdd = new Button("Add New");
        VBox vBox = new VBox(10, listViewNames,textFieldName,buttonAdd);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,200,300);
        primaryStage.setTitle("ListView JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
