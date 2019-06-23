package com.example.sweater.controller;

import com.example.sweater.domain.DocumentPdf;
import com.example.sweater.domain.NewLabel;
import com.example.sweater.domain.Product;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Controller

public class PrintController {
    @PostMapping("createpdf")
    public String myPrint(@RequestParam Product product) throws IOException {
        NewLabel documentPdf = new NewLabel(product);
        try {
            documentPdf.createPdf();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "documentpdf";
    }
}
