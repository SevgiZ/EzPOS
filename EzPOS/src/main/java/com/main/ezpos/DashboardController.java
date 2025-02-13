package com.main.ezpos;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class DashboardController {

    private ObservableList<Product> itemsList = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> tableScannedItems;

    @FXML
    private TextField fieldSearchBox;
    @FXML
    private TableColumn<ScannedItem, String> name;
    @FXML
    private TableColumn<ScannedItem, String> brand;
    @FXML
    private TableColumn<ScannedItem, String> price_selling_for;


    public void EnterBarcode() {
        System.out.print("Bar code scanned!");
        fieldSearchBox.requestFocus();
    }

    public void SearchBarcode() throws SQLException {
        String barcode = fieldSearchBox.getText();
        String url = "jdbc:sqlite:database\\database.db";
        Connection conn = DriverManager.getConnection(url);
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from Products where barcode = "+barcode+";");

        ResultSetMetaData rsmd = rs.getMetaData();

        while (rs.next()) {
                itemsList.add(new Product(
                        rs.getString("barcode"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        Float.parseFloat(rs.getString("size")),
                        rs.getString("size_unit"),
                        rs.getString("description"),
                        Float.parseFloat(rs.getString("price_bought_for")),
                        rs.getFloat("price_selling_for"),
                        rs.getString("product_type"),
                        Integer.parseInt(rs.getString("stock")),
                        Integer.parseInt(rs.getString("number_sold_total")),
                        Integer.parseInt(rs.getString("number_sold_last_month")),
                        Integer.parseInt(rs.getString("number_refunded")),
                        Integer.parseInt(rs.getString("number_written_off")),
                        rs.getString("put_on_shelf_date"),
                        rs.getString("last_sold_date"),
                        rs.getString("last_written_off_date")
                ));
        }

        //itemsList.add(new ScannedItem("Asahi", 0.0, 19.99));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        price_selling_for.setCellValueFactory(new PropertyValueFactory<>("price_selling_for"));

        tableScannedItems.setItems(itemsList);


        conn.close();
        state.close();
        rs.close();

        fieldSearchBox.clear();
    }


    @FXML
    public void ReadBarcode() throws IOException, NotFoundException {
        String path = "barcode_test.png";

        BufferedImage bf = ImageIO.read(new FileInputStream(path));
        BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf)));
        Result result = new MultiFormatReader().decode(bitMap);

        System.out.print(result.getText());
    }

}
