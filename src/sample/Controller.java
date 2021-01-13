package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView switchTheme;

    @FXML
    private Text cityName;

    @FXML
    private Text weatherCondition;

    @FXML
    private Text weatherDescription;

    @FXML
    private Text temperature;

    @FXML
    private Text temperatureText;

    @FXML
    private Text humidity;

    @FXML
    private Text humidityText;

    @FXML
    void initialize() {
        if (!getData().isEmpty()) {
            JSONObject obj = new JSONObject(getData());
            cityName.setText(obj.getString("name"));
            weatherCondition.setText(obj.getJSONArray("weather").getJSONObject(0).getString("main"));
            weatherDescription.setText(obj.getJSONArray("weather").getJSONObject(0).getString("description"));
            temperatureText.setText(String.valueOf(obj.getJSONObject("main").getDouble("temp")));
            humidityText.setText(String.valueOf(obj.getJSONObject("main").getDouble("humidity")));
        }
    }

    private static String getData() {
        StringBuilder content = new StringBuilder();
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
        return content.toString();
    }

    @FXML
    void switchTheme() {

    }
}
