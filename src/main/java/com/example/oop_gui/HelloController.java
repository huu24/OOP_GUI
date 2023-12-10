package com.example.oop_gui;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController {
    @FXML private AnchorPane fatherPane;
    @FXML private ScrollPane messagePane;
    @FXML private VBox messageContainer;
    @FXML private TextField textField;
    @FXML private Button sendButton;
    @FXML private ImageView ChooseImage;
    @FXML private ImageView Mic;
    @FXML private Button call;
    @FXML private Button callVideo;
    @FXML private Label callingLabel;
    @FXML private Label callingVideoLabel;
    @FXML private Label micLabel;
    @FXML private Label pickImageLabel;

    public void sendMessage(ActionEvent action) {
        String message = textField.getText();
        if (!message.isEmpty()) {
            Text text = new Text(message);
            text.setFont(new Font(14));
            double textWidth = text.getLayoutBounds().getWidth();
            double wrapWidth = 360;

            TextArea showText = new TextArea(message);
            showText.setStyle("-fx-control-inner-background:  rgb(230, 230, 265); -fx-text-fill: black;");
            showText.setWrapText(true);
            showText.setEditable(false);
            showText.setPrefWidth(textWidth);
            showText.setPrefHeight(computeTextHeight(message, 14, wrapWidth));
            messageContainer.getChildren().add(showText);
            textField.clear();

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> lisaMessage(action));
            pause.play();
        }
    }

    public void lisaMessage(ActionEvent action) {
        String mes1 = "Nice to meet you!";
        String mes2 = "Have a nice day!";
        String mes3 = "Wow, you so good!";
        String mes4 = "How can I help you?";

        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;

        String message = switch (randomNumber) {
            case 1 -> mes1;
            case 2 -> mes2;
            case 3 -> mes3;
            default -> mes4;
        };
            Text text = new Text(message);
        text.setFont(new Font(14));
        double textWidth = text.getLayoutBounds().getWidth();
        double wrapWidth = 360;

        TextArea showText = new TextArea(message);
        showText.setStyle("-fx-control-inner-background: pink; -fx-text-fill: black;");
        showText.setWrapText(true);
        showText.setEditable(false);
        showText.setPrefWidth(textWidth);
        showText.setPrefHeight(computeTextHeight(message, 14, wrapWidth));
        messageContainer.getChildren().add(showText);
        textField.clear();

    }

    public void call(ActionEvent action) {
        callingLabel.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> callingLabel.setVisible(false));
        pause.play();
    }

    public void callVideo(ActionEvent action) {
        callingVideoLabel.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> callingVideoLabel.setVisible(false));
        pause.play();
    }
     public void onMic(ActionEvent action) {
         micLabel.setVisible(true);
         PauseTransition pause = new PauseTransition(Duration.seconds(1));
         pause.setOnFinished(event -> micLabel.setVisible(false));
         pause.play();
     }

    public void chooseImage(ActionEvent action) {
        pickImageLabel.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> pickImageLabel.setVisible(false));
        pause.play();
    }
    private double computeTextHeight(String text, double fontSize, double wrapWidth) {
        Text tempText = new Text(text);
        tempText.setFont(new Font(fontSize));
        tempText.setWrappingWidth(wrapWidth);
        return tempText.getLayoutBounds().getHeight();
    }

}