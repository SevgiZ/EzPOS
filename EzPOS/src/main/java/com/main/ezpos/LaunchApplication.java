package com.main.ezpos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.IOException;
import java.util.Date;

public class LaunchApplication extends Application {


    public void CreateDatabase() throws SQLException, IOException {
        String url = "jdbc:sqlite:database\\database.db";
        File f = new File("database\\database.db");

        if (!f.exists() && !f.isDirectory()) {
            System.out.println("No existing database detected. Creating database...");
            FileWriter fw = new FileWriter("database\\database.db");
            fw.write("");
            fw.close();


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currentDateTime = df.format(date);


            Connection conn = DriverManager.getConnection(url);

            System.out.println(conn.isValid(0));

            Statement state = conn.createStatement();
            System.out.print("Creating users");
            state.executeUpdate("create table Users (\n" +
                    "user_id integer primary key,\n" +
                    "user_type string,\n" +
                    "username varchar(255),\n" +
                    "password varchar(255),\n" +
                    "date_created datetime,\n" +
                    "products_sold_total integer,\n" +
                    "products_sold_last_month integer,\n" +
                    "revenue_total real,\n" +
                    "revenue_month real\n" +
                    ");");

            System.out.print("Creating Products");
            state.executeUpdate("create table Products (\n" +
                    "barcode varchar(255) primary key,\n" +
                    "brand varchar(255),\n" +
                    "name varchar(255),\n" +
                    "size real,\n" +
                    "size_unit string,\n" +
                    "description varchar,\n" +
                    "price_bought_for real,\n" +
                    "price_selling_for real,\n" +
                    "product_type string,\n" +
                    "stock integer,\n" +
                    "number_sold_total integer,\n" +
                    "number_sold_last_month integer,\n" +
                    "number_refunded integer,\n" +
                    "number_written_off integer,\n" +
                    "put_on_shelf_date datetime,\n" +
                    "last_sold_date datetime,\n" +
                    "last_written_off_date datetime\n" +
                    ");");


            System.out.print("Inserting admin");
            state.executeUpdate("insert into Users values(0, \"admin\", \"653\", \"6534\",\""+currentDateTime+"\", 0, 0, 0, 0);");

            System.out.print("All done!");

            conn.close();
            state.close();
        }
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        CreateDatabase();

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //DashboardController controller = new DashboardController();
        Scene scene = new Scene(root);

//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                controller.EnterBarcode();
//            }
//        });
        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}