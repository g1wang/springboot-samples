package com.stars.barcodesample.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @Description:
 * @Author l
 * @Date 2022/10/25 13:59
 */
@RestController
@RequestMapping("barcode")
public class BarcodeController {

    @PostMapping
    public String getBarcode(@RequestBody MultipartFile image) throws IOException, ChecksumException, NotFoundException, FormatException {
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(ImageIO.read(image.getInputStream()))));
        Reader reader = new MultiFormatReader();
        Result result = reader.decode(bitmap);
        return result.getText();

    }
}
