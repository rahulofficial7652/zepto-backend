package zepto.Zepto_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.RegisterProductDtos;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.model.Product;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.repository.ProductRepository;
import zepto.Zepto_backend.utility.MappingUtility;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    UserService userService;

    @Autowired
    MappingUtility mappingUtility;

    @Autowired
    ProductRepository productRepository;

    public void registerProduct(RegisterProductDtos registerProductDtos, UUID userId){
        User user = userService.getUserById(userId);
        if(user==null){
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userId.toString()));
        }
        if(userService.isAppAdmin(user) == false && userService.isMaintUser(user) == false ){
            throw new UnAuthorizedExceprion(
                    String.format("User with id %s is not allowed to perform invite-admin open", userId)
            );
        }

        // map register to DTO Model
        Product product = mappingUtility.mapRegisterProductToProduct(registerProductDtos);
        product = productRepository.save(product);
    }
    public Product saveOrUpdateProduct(Product product){
        return productRepository.save(product);
    }
    public Product getProductById(UUID id){
        return productRepository.findById(id).orElse(null);
    }}
