package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class AverageHumidityDisplay implements Observer {

    private double prevHumid;
    private int datapoints = 1;
    private JFrame frame;
    private JTextArea area;

    public AverageHumidityDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.white);
        area.setText("Average Humidity:\n");

    }

    @Override
    public void update(double temp, double humid, double pressure) {
        if (prevHumid == 0)
            prevHumid = humid;
        double avg = (prevHumid*datapoints + humid)/(datapoints+1);
        prevHumid = avg;

        area.setBackground(Color.ORANGE);
        area.setText("Average Humidity:\n");
        area.append("Humidity = "+avg);

    }
}
