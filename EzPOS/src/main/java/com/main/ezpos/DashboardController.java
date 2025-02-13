package com.main.ezpos;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DashboardController {

    @FXML
    private TextField fieldSearchBox;



    public void EnterBarcode() {
        System.out.print("Bar code scanned!");
        fieldSearchBox.requestFocus();

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
