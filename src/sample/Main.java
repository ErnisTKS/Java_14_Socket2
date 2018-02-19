package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {
    public static final int PORT = 8080;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

//        launch(args);

        try {
            ServerSocket serveris = new ServerSocket(PORT);
            Socket kanalas = null;
            kanalas = serveris.accept(); //cia kodas sustos ir lauks prisijungimo
            System.out.println("Prisijungiau");

            ObjectOutputStream isvedimas = new ObjectOutputStream(kanalas.getOutputStream());

            isvedimas.writeUTF("Susijungem");

            isvedimas.flush();

            ObjectInputStream serverioKanalas = new ObjectInputStream(kanalas.getInputStream());
            String inputLine="";
            while ((inputLine = serverioKanalas.readUTF()) != null) {
                System.out.println(serverioKanalas.readUTF());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
