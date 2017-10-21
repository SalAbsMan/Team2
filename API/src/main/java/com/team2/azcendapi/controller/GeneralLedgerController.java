package com.team2.azcendapi.controller;

import com.team2.azcendapi.services.GeneralLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/gl", produces = MediaType
        .APPLICATION_JSON_VALUE)
public class GeneralLedgerController {

    private final GeneralLedgerService generalLedgerService;

    @Autowired
    public GeneralLedgerController(GeneralLedgerService generalLedgerService) {
        this.generalLedgerService = generalLedgerService;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String importGl(@RequestParam("file") MultipartFile file) {
        generalLedgerService.importGL(file);
        return "{\"status\":204}";
    }
}