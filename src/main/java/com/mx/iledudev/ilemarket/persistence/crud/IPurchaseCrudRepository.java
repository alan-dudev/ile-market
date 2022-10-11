package com.mx.iledudev.ilemarket.persistence.crud;

import com.mx.iledudev.ilemarket.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends CrudRepository<Purchase, Long> {

    Optional<List<Purchase>> findByClientId(String clientId);
}
