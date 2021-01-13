package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView switchTheme;

    @FXML
    void initialize() {

    }

    StringBuffer getData() {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Drochia&appid=5dfbc1c91fc61457629e0d4e30513742");
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Not found");
            e.printStackTrace();
        }
        return content;
    }

    @FXML
    void switchTheme() {
        System.out.println(getData());
    }
}
