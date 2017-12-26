package view;

import controller.Controller;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        */
        controller = new Controller();
        Label label = new Label("email");
        label.setLayoutX(100);
        label.setLayoutY(100);

        TextField tf = new TextField();
        tf.setLayoutX(200);
        tf.setLayoutY(100);

        Label label2 = new Label("password");
        label2.setLayoutX(100);
        label2.setLayoutY(200);

        TextField tf2 = new TextField();
        tf2.setLayoutX(200);
        tf2.setLayoutY(200);

        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {
                String email = tf.getText();
                String password = tf.getText();
                boolean resultOfLogin = controller.tryLogin(email,password);

                if(resultOfLogin){
                    String nameOfUser = controller.getNameByEmail(email);
                    Scene loginScene = new Scene(new Group(new Label("WELCOME "+nameOfUser)),200,100);
                    Stage loginStage = new Stage();
                    loginStage.setScene(loginScene);
                    loginStage.show();
                }else{
                    Scene loginScene = new Scene(new Group(new Label("Try Again")),200,100);
                    Stage loginStage = new Stage();
                    loginStage.setScene(loginScene);
                    loginStage.show();
                }

            }
        };
        Button button = new Button("login");
        button.setLayoutX(150);
        button.setLayoutY(300);
        button.setOnMouseClicked(handler);

        Group group = new Group(label,label2,tf,tf2,button);
        Scene scene = new Scene(group,400,400);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
