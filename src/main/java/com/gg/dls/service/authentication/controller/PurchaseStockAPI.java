package com.gg.dls.service.authentication.controller;


import com.gg.dls.service.authentication.jms.SenderService;
import com.gg.dls.service.authentication.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/purchase/")
@RestController
public class PurchaseStockAPI {

    @Autowired
    SenderService senderService;

    @PostMapping("/stock")
    public ResponseEntity<?> getStock(@Valid @RequestBody Stock stock) {

        if(stock != null){
            senderService.send(stock.getName() + "accepted for purchase");
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
