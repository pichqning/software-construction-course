package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;

    private JFrame frame;
    private JTextArea area , oceanArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(200, 200);
        area.setBackground(Color.ORANGE);
        area.setText("Average Temperature:\n");

        oceanArea = new JTextArea(200, 200);
        oceanArea.setBackground(Color.PINK);
        oceanArea.setText("Average Ocean:\n");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(area);
        frame.add(oceanArea);

    }

    @Override
    public void update(Subject data) {

        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avg;
            area.setBackground(Color.ORANGE);
            area.setText("Average Condition:\n");
            area.append("Temperature = " + avg +"\n");
        }

        else if (data instanceof OceanData) {
            OceanData oceanData = (OceanData) data;

            if (prevWave == 0)
                prevWave = oceanData.getWaveHeight();
            double avg2 = (prevWave+oceanData.getWaveHeight()) / 2;
            prevWave = avg2;
            oceanArea.setBackground(Color.PINK);
            oceanArea.setText("Average Condition:\n");
            oceanArea.append("Wave Height = " + avg2);

        }
    }
}
