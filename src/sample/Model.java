package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Model {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8080;

    public Model(){
        Socket kanalas = null;
        try {
            kanalas = new Socket(HOST, PORT);
            ObjectOutputStream isvedimas = new ObjectOutputStream(kanalas.getOutputStream());
            ObjectInputStream serverioKanalas = new ObjectInputStream(kanalas.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendData(String value){

    }

    public String GetData(){
        String msg="";
        return msg;
    }
}
