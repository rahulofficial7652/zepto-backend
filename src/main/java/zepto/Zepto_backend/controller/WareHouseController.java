package zepto.Zepto_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zepto.Zepto_backend.dtos.CreateWareHouseRequestBody;
import zepto.Zepto_backend.dtos.WareHouseRequestBody;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.service.WareHouseService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @PostMapping("create")
    public ResponseEntity createWareHouse(@RequestBody CreateWareHouseRequestBody createWareHouseRequestBody, @RequestParam UUID userId){
        try{
            wareHouseService.createWareHouse(createWareHouseRequestBody, userId);
            return new ResponseEntity("WareHouse created successfully", HttpStatus.CREATED);
        }
        catch (UserNotFountException e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (
                UnAuthorizedExceprion e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/product/assign")
//    public ResponseEntity assignProductToWareHouse(@RequestBody WareHouseRequestBody wareHouseRequestBody){
//
//    }
}
