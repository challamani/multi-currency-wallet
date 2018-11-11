package in.co.myrupee.controller;

import in.co.myrupee.constant.ResponseCode;
import in.co.myrupee.model.BasicResponseBO;
import in.co.myrupee.repository.ApplicationResource;
import in.co.myrupee.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;


@RestController
public class AuthController {


    @Autowired
    AuthService authService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = {"/setSuperPin/{token}/{username}"},method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<BasicResponseBO> setAccountSuperPin(@PathVariable String token, @PathVariable @Valid @Pattern(regexp = "^[a-zA-Z]{3}[0-9]{7}$") String username,
                                     @RequestHeader(value = "SUPER_PIN", required = true) @Valid @Pattern(regexp = "^[0-9]{5}$") String superPin){



        try{

            if(ApplicationResource.ACTIVE_TOKENS.containsKey(username) && ApplicationResource.ACTIVE_TOKENS.get(username).getToken().equals(token)){
                    ApplicationResource.ACTIVE_TOKENS.remove(username);
                    BasicResponseBO basicResponseBO =  authService.setCustomerPin(username,superPin);
                return new ResponseEntity<>(basicResponseBO, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new BasicResponseBO(ResponseCode.NO_RESOURCE_FOUND.getResponse(), ResponseCode.NO_RESOURCE_FOUND.getDescription(), null), HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(new BasicResponseBO(ResponseCode.SYSTEM_MALFUNCTION.getResponse(), ResponseCode.SYSTEM_MALFUNCTION.getDescription(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
