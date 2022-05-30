package com.example.circleexercise;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane pane=new Pane();

        double width=600;
        double height=600;
        double radius=Math.min(width,height)*0.25;

        Circle c= new Circle(width/2,height/2,radius, Color.TRANSPARENT);
        c.setStroke(Color.RED);
        c.setRotate(180);

        Text text=new Text("Ceren Ünlü");
        Font font=Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC,24);
        text.setFont(font);
        pane.getChildren().addAll(c,text);
        PathTransition pt=new PathTransition();
        pt.setDuration(Duration.millis(10000));
        pt.setPath(c);
        pt.setNode(text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(5000));
        ft.setNode(text);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        c.setOnMousePressed(e->{
            pt.pause();
            ft.pause();
        });
        c.setOnMouseReleased(e->{
            pt.play();
            ft.play();
        });

        Scene scene=new Scene(pane,width,height);
        primaryStage.setTitle("Week10");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}