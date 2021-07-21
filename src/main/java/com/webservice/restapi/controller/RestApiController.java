package com.webservice.restapi.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
//@RequestMapping("RESTAPI")
public class RestApiController {

    @GetMapping(path = "/printString")
    public ResponseEntity<String> printString() {

        return ResponseEntity.status(HttpStatus.OK).body("Welcome");
    }

    @GetMapping(path= "/downloadExcel" /*consumes = "application/json", produces = {} */)
    public ResponseEntity<Object> downloadExcel() {
        System.out.print("hi...");
        String fileName = "rest_api_sample_excel.xlsx";

        InputStreamResource file = null;
        try {
            file = new InputStreamResource(new FileInputStream("src/main/resources/"+fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(ExceptionUtils.getStackTrace(fileNotFoundException));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}