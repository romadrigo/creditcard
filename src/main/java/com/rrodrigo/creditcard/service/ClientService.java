package com.rrodrigo.creditcard.service;

import com.creditcard.openapi.model.ClientRes;
import com.creditcard.openapi.model.ProductRes;
import com.rrodrigo.creditcard.model.Client;
import com.rrodrigo.creditcard.model.Product;
import com.rrodrigo.creditcard.repository.ClientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService  {

    private static final Logger logger = LogManager.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientRes getClientById(Long idClient) {
        Client client = null;
        client = clientRepository.getById(idClient);
        if(client != null){
            logger.info("client found");
            return mapToDto(client);
        }
        return null;
    }

    private ClientRes mapToDto(Client client) {
        ClientRes dto = new ClientRes();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setAddress(client.getAddress());
        dto.setCity(client.getCity());
        dto.setTelephone(client.getTelephone());
        dto.setProducts(client.getProducts().stream().map(this::mapProduct).toList());
        return dto;
    }

    private ProductRes mapProduct(Product data) {
        ProductRes product = new ProductRes();
        product.setId(data.getId());
        product.setAmount(data.getAmount());
        product.setStatus(data.getStatus());
        product.setType(data.getType());
        return product;
    }
}
