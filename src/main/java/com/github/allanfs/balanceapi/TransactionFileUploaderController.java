package com.github.allanfs.balanceapi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

@RestController
@RequestMapping("/upload/transaction")
public class TransactionFileUploaderController {
    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());

        Path temp = Files.createTempFile("transactions_", ".csv");
        File tmpFile = new File(temp.toString());

        file.transferTo(tmpFile);
        
        List<TransactionCSV> beans = new CsvToBeanBuilder(new FileReader(tmpFile))
        .withType(TransactionCSV.class)
        .withSeparator(';')
        .build()
        .parse();
        beans.forEach(System.out::println);

        // try (CSVReader reader = new CSVReader(Files.newBufferedReader(temp))) {
        //     List<String[]> r = reader.readAll();
        //     r.forEach(x -> System.out.println(Arrays.toString(x)));
        // } catch (CsvException e) {
        //     System.out.println("Falha pra ler o CSV" + e.getCause());
        // }

    }    
}
