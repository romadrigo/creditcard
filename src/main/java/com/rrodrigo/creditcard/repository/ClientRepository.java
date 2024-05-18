package com.rrodrigo.creditcard.repository;

import com.rrodrigo.creditcard.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
