package ro.ccpatrut.beelove.service;

import ro.ccpatrut.beelove.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();
}
