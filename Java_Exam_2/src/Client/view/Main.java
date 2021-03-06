package Client.view;

import Client.controller.Controller;
import Client.model.SocketClient;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


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
                String password = tf2.getText();
                boolean resultOfLogin = controller.tryLogin(email,password);

                boolean isTeacher = false; //if user.isTeacher = true/false osv - Dessa ska flyttas högre upp men är här nere för att testas atm
                boolean isAdmin = false; // if user.isAdmin = true/false osv - Dessa ska flyttas högre upp men är här nere för att testas atm

                if(resultOfLogin){
                    int idOfUser = controller.getidfrommail(email);




                    Button button1 = new Button();
                    button1.setText("Show Your Classes");
                    button1.setWrapText(true);
                    button1.setMinSize(100, 50);
                    button1.setOnAction(value -> {
                        try {
                            showYourClasses(idOfUser);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    });

                    Button button2 = new Button();
                    button2.setText("Show All Classes");
                    button2.setWrapText(true);
                    button2.setMinSize(100, 50);
                    button2.setOnAction(value -> {
                        showAllClasses();
                    });

                    Button button3 = new Button();
                    button3.setText("Enroll To New Classes");
                    button3.setWrapText(true);
                    button3.setMinSize(100, 50);
                    button3.setOnAction(value -> {
                        enrollNewCLass();
                    });

                    Button button4 = new Button();
                    button4.setText("Secret teacher Button");
                    button4.setWrapText(true);
                    button4.setMinSize(100, 50);
                    button4.setOnAction(value -> {
                        System.out.println("OOOoooOOoh - Is Teacher");
                    });

                    Button button5 = new Button();
                    button5.setText("Secret Admin Button");
                    button5.setWrapText(true);
                    button5.setMinSize(100, 50);
                    button5.setOnAction(value -> {
                        System.out.println("wow\n        amaze\n  very add\n     much course");
                    });

                    Button button6 = new Button();
                    button6.setText("Add new courses");
                    button6.setWrapText(true);
                    button6.setMinSize(100, 50);
                    button6.setOnAction(value -> {
                        addNewCourse();
                    });


                    HBox hbox;
                    if (isAdmin) {
                         hbox = new HBox(button2,button6, button5);
                    } else if (isTeacher) {
                         hbox = new HBox(button1, button2, button4);
                    } else {
                         hbox = new HBox(button1, button2, button3);
                    }
                    Scene scene = new Scene(hbox, 400, 150);
                    primaryStage.setScene(scene);
                    primaryStage.show();


                }else{
                    Scene loginScene = new Scene(new Group(new Label("Try Again")),500,500);
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
public static ArrayList[] emailsAndPasswords;
    public static void main(String[] args) {
        try {
            SocketClient.initSocket();
            emailsAndPasswords = SocketClient.loginSocket();
            launch(args);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showYourClasses(int id) throws IOException, ClassNotFoundException {
            ArrayList<Integer> toTheServer = new ArrayList<>();
            toTheServer.add(1);
            toTheServer.add(id);
            ArrayList[] fromTheServer = SocketClient.sendMessageToServer(toTheServer);
            ArrayList<Integer> course_id = fromTheServer[0];
            ArrayList<String> course_name = fromTheServer[1];
            ArrayList<Integer> teacher_id = fromTheServer[2];

            GridPane gridpane = new GridPane();

            int lenArrayName = course_name.size();
            int lenArrayId = course_id.size();
            int lenArrayTeacher = teacher_id.size();

            for (int i = 0; i < lenArrayName; i++){
                TextField tx1 = new TextField(String.valueOf(course_name.get(i)));
                tx1.setDisable(true);
                gridpane.add(tx1,1,i+2);
            }

            for (int i = 0; i < lenArrayId; i++){
                TextField tx1 = new TextField(String.valueOf(course_id.get(i)));
                tx1.setDisable(true);
                gridpane.add(tx1,0,i+2);
        }
            for (int i = 0; i < lenArrayTeacher; i++){
                TextField tx1 = new TextField(String.valueOf(teacher_id.get(i)));
                tx1.setDisable(true);
                gridpane.add(tx1,2,i+2);
        }


            TextField courseId = new TextField("Course ID");
            TextField name = new TextField("Course Name");
            TextField teacherId = new TextField("Teacher ID");

            courseId.setDisable(true);
            name.setDisable(true);
            teacherId.setDisable(true);

            gridpane.add(courseId,0,0);
            gridpane.add(name,1,0);
            gridpane.add(teacherId,2,0);

            Scene buttonScene = new Scene(gridpane, 500, 200);
            Stage buttonStage = new Stage();
            buttonStage.setScene(buttonScene);
            buttonStage.show();
    }

    public void showAllClasses(){

        String var1 ="KlassNamn"; //namn är endast placeholder ska bytas till variabel

        GridPane gridpane = new GridPane();

        TextField tx1 = new TextField(var1);
        tx1.setDisable(true);
        gridpane.add(tx1,1,0);


        Scene buttonScene = new Scene(gridpane, 500, 500);
        Stage buttonStage = new Stage();
        buttonStage.setScene(buttonScene);
        buttonStage.show();
    }

    public void enrollNewCLass(){
        String var1 ="KlassNamn"; //namn är endast placeholder ska bytas till variabel
        String var2 ="Teacher"; //namn är endast placeholder ska bytas till variabel

        GridPane gridpane = new GridPane();

        TextField tx1 = new TextField(var1);
        gridpane.add(tx1,1,0);

        TextField tx2 = new TextField(var2);
        gridpane.add(tx2,2,0);

        Scene buttonScene = new Scene(gridpane, 500, 500);
        Stage buttonStage = new Stage();
        buttonStage.setScene(buttonScene);
        buttonStage.show();

    }

    public void addNewCourse(){
        String var1 ="KlassNamn"; //namn är endast placeholder ska bytas till variabel
        String var2 ="Teacher"; //namn är endast placeholder ska bytas till variabel
        String var3 ="ClassCode"; //namn är endast placeholder ska bytas till variabel

        GridPane gridpane = new GridPane();

        TextField tx1 = new TextField(var1);
        gridpane.add(tx1,1,0);

        TextField tx2 = new TextField(var2);
        gridpane.add(tx2,2,0);


        TextField tx3 = new TextField(var3);
        gridpane.add(tx3,3,0);

        Scene buttonScene = new Scene(gridpane, 500, 500);
        Stage buttonStage = new Stage();
        buttonStage.setScene(buttonScene);
        buttonStage.show();
    }
}


