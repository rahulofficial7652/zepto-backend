package zepto.Zepto_backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zepto.Zepto_backend.dtos.RegisterProductDtos;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.service.ProductService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity resisterProduct(@RequestBody RegisterProductDtos registerProductDtos, @RequestParam UUID userId){

        try{
            productService.registerProduct(registerProductDtos, userId);
            return new ResponseEntity("Product registered successfully", HttpStatus.CREATED);
        }catch (UserNotFountException e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (UnAuthorizedExceprion e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
