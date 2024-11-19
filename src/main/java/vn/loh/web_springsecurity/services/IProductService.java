package vn.loh.web_springsecurity.services;

import vn.loh.web_springsecurity.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    <S extends Product> S save(S entity);

    Optional<Product> findById(Long aLong);

    void deleteById(Long aLong);

    void delete(Product entity);
}
