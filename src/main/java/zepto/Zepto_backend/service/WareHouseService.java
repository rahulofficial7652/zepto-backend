package zepto.Zepto_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.CreateWareHouseRequestBody;
import zepto.Zepto_backend.dtos.WareHouseRequestBody;
import zepto.Zepto_backend.exceptions.InsufficentProductQuantityException;
import zepto.Zepto_backend.exceptions.RecordDoesNotExist;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.model.*;
import zepto.Zepto_backend.repository.WareHouseItemRepository;
import zepto.Zepto_backend.repository.WareHouseRepository;
import zepto.Zepto_backend.utility.MappingUtility;

import java.util.UUID;


@Service
public class WareHouseService {

    @Autowired
    MappingUtility mappingUtility;

    @Autowired
    LocationService locationService;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    WareHouseItemRepository wareHouseItemRepository;

    public void createWareHouse(CreateWareHouseRequestBody createWareHouseRequestBody, UUID userId) {

        Location location = mappingUtility.mapWareHouseLocationToLocation(createWareHouseRequestBody);
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userId.toString()));
        }
        if (userService.isAppAdmin(user) == false && userService.isMaintUser(user) == false) {
            throw new UnAuthorizedExceprion(
                    String.format("User with id %s is not allowed to perform invite-admin open", userId)
            );
        }
        location = locationService.saveLocation(location);
        WareHouse wareHouse = mappingUtility.mapWareHouseRBToWareHouse(createWareHouseRequestBody);
        wareHouse.setLocation(location);
        this.saveOrUpdateWareHouse(wareHouse);
    }

    public void assignProductToWareHouse(WareHouseRequestBody wareHouseRequestBody, UUID userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userId.toString()));
        }
        if (userService.isAppAdmin(user) == false && userService.isMaintUser(user) == false) {
            throw new UnAuthorizedExceprion(
                    String.format("User with id %s is not allowed to perform invite-admin open", userId)
            );
        }
        UUID wid = wareHouseRequestBody.getWid();
        UUID pid = wareHouseRequestBody.getPid();
        Product product = productService.getProductById(pid);
        WareHouse wareHouse = this.getWareHouseById(wid);
        if (product == null || wareHouse == null) {
            throw new RecordDoesNotExist("Product doesn't exist");
        }
        if (product.getQuantity() < wareHouseRequestBody.getTotalQuantity()) {
            throw new InsufficentProductQuantityException("Product quantity is less then required quantity");
        }
        product.setQuantity(product.getQuantity() - wareHouseRequestBody.getTotalQuantity());
        productService.saveOrUpdateProduct(product);
        WareHouseItem wareHouseItem = mappingUtility.mapWareHouseItemToWareHouseItem(wareHouseRequestBody);
        this.saveOrUpdateWareHouseItem(wareHouseItem);
        wareHouse.getWarehouseItemList().add(wareHouseItem);
        this.saveOrUpdateWareHouse(wareHouse);
    }

    public WareHouseItem saveOrUpdateWareHouseItem(WareHouseItem wareHouseItem){
        return wareHouseItemRepository.save(wareHouseItem);
    }

    public WareHouse getWareHouseById(UUID wid) {
        return wareHouseRepository.findById(wid).orElse(null);
    }

    public WareHouse saveOrUpdateWareHouse(WareHouse wareHouse) {
        return wareHouseRepository.save(wareHouse);
    }
}
