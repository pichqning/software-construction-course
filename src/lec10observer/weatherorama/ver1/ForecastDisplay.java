package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer {

    private double prevTemp;
    private JFrame frame;
    private JTextArea area;

    public ForecastDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.LIGHT_GRAY);
        area.setText("Forecast:\n");

    }

    @Override
    public void update(double temp, double humid, double pressure) {
        double fore_temp = 0;

        if (prevTemp == 0)
            prevTemp = temp;
        double avg = (prevTemp + temp)/2;

        if (prevTemp == temp) fore_temp = temp;
        else if(prevTemp < temp) fore_temp = temp + avg/24;
        else fore_temp = temp - avg/(24);

        prevTemp = avg;

        area.setBackground(Color.pink);
        area.setText("Forecast next day:\n");
        area.append("Temperature = "+fore_temp);

    }
}
