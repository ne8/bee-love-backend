package ro.ccpatrut.beelove.service.impl.shop;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.shop.AddressDTO;
import ro.ccpatrut.beelove.dto.shop.OrderDTO;
import ro.ccpatrut.beelove.dto.shop.ProductOrderDTO;
import ro.ccpatrut.beelove.dto.shop.UserDTO;
import ro.ccpatrut.beelove.entities.shop.OrderEntity;
import ro.ccpatrut.beelove.entities.shop.ProductOrderEntity;
import ro.ccpatrut.beelove.repository.OrderRepository;
import ro.ccpatrut.beelove.repository.ProductRepository;
import ro.ccpatrut.beelove.service.CheckoutService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void doCheckout(final OrderDTO orderDTO) {
        this.validateProducts(orderDTO.getProducts());

        final AddressDTO addressDTO = orderDTO.getAddress();
        final UserDTO userDTO = orderDTO.getUserData();

        final OrderEntity orderEntity = new OrderEntity();
        //user
        orderEntity.setFirstName(userDTO.getFirstName());
        orderEntity.setLastName(userDTO.getLastName());
        orderEntity.setEmailAddress(userDTO.getEmailAddress());

        //address
        orderEntity.setCity(addressDTO.getCity());
        orderEntity.setPostalCode(addressDTO.getPostalCode());
        orderEntity.setPhoneNumber(addressDTO.getPhoneNumber());
        orderEntity.setFullAddress(addressDTO.getFullAddress());

        orderEntity.setProductOrderEntityList(this.mapProducts(orderDTO.getProducts(), orderEntity));
        this.orderRepository.save(orderEntity);
    }


    private List<ProductOrderEntity> mapProducts(final List<ProductOrderDTO> productOrderDTOList,
                                                 final OrderEntity orderEntity) {
        final List<ProductOrderEntity> productOrderEntities = new ArrayList<>();
        productOrderDTOList.forEach(productOrderDTO -> {
                    final ProductOrderEntity productOrderEntity = this.modelMapper.map(productOrderDTO, ProductOrderEntity.class);
                    productOrderEntity.setId(null);
                    productOrderEntity.setOrderEntity(orderEntity);
                    productOrderEntities.add(productOrderEntity);
                }
        );
        return productOrderEntities;
    }

    private void validateProducts(final List<ProductOrderDTO> productOrderDTOList) {
        productOrderDTOList.forEach(productOrderDTO -> {
            if (!this.productRepository.existsById(productOrderDTO.getId())) {
                throw new IllegalArgumentException("Product with id: " + productOrderDTO.getId() + " does not exists!");
            }
        });

    }
}
