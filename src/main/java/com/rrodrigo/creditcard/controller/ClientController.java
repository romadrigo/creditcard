package com.rrodrigo.creditcard.controller;

import com.creditcard.openapi.api.ClientApi;
import com.creditcard.openapi.model.ClientRes;
import com.rrodrigo.creditcard.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClientController implements ClientApi {
    private static final Logger logger = LogManager.getLogger(ClientController.class);

    // TODO: Insert code in this controller
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client/{clientId}")
    public ResponseEntity<ClientRes> clientClientIdGet(@PathVariable Long clientId){
        logger.info("Ingresando Controller clientId: " + clientId);
        try {
            ClientRes result = clientService.getClientById(clientId);
           return new ResponseEntity<>(result, HttpStatus.OK);
       } catch (Exception e) {
            logger.info("Error:" + e.getMessage());
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
