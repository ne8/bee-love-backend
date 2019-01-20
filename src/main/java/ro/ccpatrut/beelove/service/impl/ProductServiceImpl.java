package ro.ccpatrut.beelove.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.ProductDTO;
import ro.ccpatrut.beelove.repository.ProductRepository;
import ro.ccpatrut.beelove.service.ProductService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findAll() {
        final List<ProductDTO> productDTOS = new ArrayList<>();
        this.productRepository.findAll()
                .forEach(productEntity -> productDTOS.add(this.modelMapper.map(productEntity, ProductDTO.class)));
        return productDTOS;
    }
}
