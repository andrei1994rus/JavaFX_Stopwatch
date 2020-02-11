package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * This class is used because that controls are created in sample.fxml.
 */
public class Controller
{
    /**
     * Object of class Stopwatch which is used for work of stopwatch.
     */
    Stopwatch stopwatch=new Stopwatch(10);

    /**
     * Time of every lap.
     */
    String timeOfLaps;

    /**
     * Object of class Button. Starts or pauses time.
     */
    @FXML
    public Button btnStartOrPause;

    /**
     * Object of class Button. Resets time and number of laps.
     */
    @FXML
    public Button btnReset;

    /**
     * Object of class Button. Does new lap and writes time of passed lap to lvTimeOfLaps.
     */
    @FXML
    public Button btnNewLap;

    /**
     * Object of class Label. Holds updated time of current lap.
     */
    @FXML
    public Label lTime;

    /**
     * Object of class ListView. Holds outputted time of every lap.
     */
    @FXML
    public ListView lvTimeOfLaps;


    /**
     * Happens reaction to click on btnStartOrPause.
     * If click on button with text Start, starts stopwatch.
     * If click on button with text Pause, pauses stopwatch.
     *
     * @param actionEvent
     *                   object of class ActionEvent. Defines what event happened.
     *
     */
    @FXML
    public void startOrPauseClick(ActionEvent actionEvent)
    {
        String buttonText=(String) btnStartOrPause.getText();

        if(buttonText.equals("Start"))
        {
            btnNewLap.setDisable(false);
            btnReset.setDisable(true);
            btnStartOrPause.setText("Pause");

            stopwatch.attach(this);
            stopwatch.start();
        }

        else if(buttonText.equals("Pause"))
        {
            btnNewLap.setDisable(true);
            btnReset.setDisable(false);
            btnStartOrPause.setText("Start");

            stopwatch.attach(this);
            stopwatch.pause();
        }
    }

    /**
     * Happens reaction to click on btnReset. Resets time.
     *
     * @param actionEvent
     *                   object of class ActionEvent. Defines what event happened.
     *
     */
    @FXML
    public void resetClick(ActionEvent actionEvent)
    {
        btnNewLap.setDisable(true);
        btnReset.setDisable(true);
        btnStartOrPause.setText("Start");

        lvTimeOfLaps.getItems().clear();

        stopwatch.attach(this);
        stopwatch.reset();
    }

    /**
     * Happens reaction to click on btnNewLap.
     *
     * @param actionEvent
     *                   object of class ActionEvent. Defines what event happened.
     *
     */
    @FXML
    public void newLapClick(ActionEvent actionEvent)
    {
        stopwatch.newLap();
    }

    /**
     * Updates time in lTime.
     */
    public void update()
    {
        Platform.runLater(() ->
        {
            long hours=stopwatch.getHours();
            long minutes=stopwatch.getMinutes();
            double seconds=stopwatch.getSeconds();

            if(hours<10
                    && minutes<10
                    && seconds<10)
            {
                lTime.setText(String.format("0%d:0%d:0%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours<10
                    && minutes<10
                    && seconds>=10)
            {
                lTime.setText(String.format("0%d:0%d:%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours<10
                    && minutes>=10
                    && seconds>=10)
            {
                lTime.setText(String.format("0%d:%d:%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours<10
                    && minutes>=10
                    && seconds<10)
            {
                lTime.setText(String.format("0%d:%d:0%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours>=10
                    && minutes<10
                    && seconds<10)
            {
                lTime.setText(String.format("%d:0%d:0%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours>=10
                    && minutes<10
                    && seconds>=10)
            {
                lTime.setText(String.format("%d:0%d:%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours>=10
                    && minutes>=10
                    && seconds>=10)
            {
                lTime.setText(String.format("%d:%d:%.2f",
                        hours,
                        minutes,
                        seconds));
            }

            else if(hours>=10
                    && minutes>=10
                    && seconds<10)
            {
                lTime.setText(String.format("%d:%d:0%.2f",
                        hours,
                        minutes,
                        seconds));
            }

        });
    }

    /**
     * Outputs time of every lap to lvTimeOfLaps.
     */
    public void outputTimeOfLaps()
    {
        int laps=stopwatch.getLaps();
        long hours=stopwatch.getHours();
        long minutes=stopwatch.getMinutes();
        double seconds=stopwatch.getSeconds();

        if(hours<10
                && minutes<10
                && seconds<10)
        {
            timeOfLaps=String.format("%d. 0%d:0%d:0%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours<10
                && minutes<10
                && seconds>=10)
        {
            timeOfLaps=String.format("%d. 0%d:0%d:%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours<10
                && minutes>=10
                && seconds>=10)
        {
            timeOfLaps=String.format("%d. 0%d:%d:%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours<10
                && minutes>=10
                && seconds<10)
        {
            timeOfLaps=String.format("%d. 0%d:%d:0%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours>=10
                && minutes<10
                && seconds<10)
        {
            timeOfLaps=String.format("%d. %d:0%d:0%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours>=10
                && minutes<10
                && seconds>=10)
        {
            timeOfLaps=String.format("%d. %d:0%d:%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours>=10
                && minutes>=10
                && seconds>=10)
        {
            timeOfLaps=String.format("%d. %d:%d:%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        else if(hours>=10
                && minutes>=10
                && seconds<10)
        {
            timeOfLaps=String.format("%d. %d:%d:0%.2f",
                    laps,
                    hours,
                    minutes,
                    seconds);
        }

        lvTimeOfLaps.getItems().add(timeOfLaps);
    }
}