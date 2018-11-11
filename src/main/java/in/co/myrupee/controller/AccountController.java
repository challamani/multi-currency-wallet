package in.co.myrupee.controller;


import in.co.myrupee.constant.ResponseCode;
import in.co.myrupee.exception.NoSuchSystemUserException;
import in.co.myrupee.model.AccountBO;
import in.co.myrupee.model.AccountResponseBO;
import in.co.myrupee.model.BasicResponseBO;
import in.co.myrupee.service.AccountService;
import in.co.myrupee.util.CipherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AccountController {


    @Autowired
    AccountService accountService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/accounts"},method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<AccountResponseBO> createAccount(@RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @Valid @RequestBody AccountBO accountBO) {

        logger.info("create account :: " + accountBO.toString());
        logger.info("basic auth ::" + authorization);

        String base64Auth = authorization.split(" ")[1];
        logger.info("base64 encoded value:" + base64Auth);

        String[] user_password = CipherUtil.decodeBase64Str(base64Auth);
        try{
            if (!CipherUtil.basicAuthValidation(user_password)) {
                BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.INVALID_CREDENTIALS.getResponse(), ResponseCode.INVALID_CREDENTIALS.getDescription(), null);
                return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.UNAUTHORIZED);
            }

        }catch (NoSuchSystemUserException e){
            logger.error(e.getMessage(),e);
            BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.NO_SUCH_USER.getResponse(), ResponseCode.NO_SUCH_USER.getDescription().concat(e.getMessage()), null);
            return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.UNAUTHORIZED);
        }


        try {
            AccountResponseBO accountResponseBO = accountService.createAccount(accountBO);
            logger.info(accountResponseBO.toString());
            return new ResponseEntity<AccountResponseBO>(HttpStatus.OK).ok(accountResponseBO);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.SYSTEM_MALFUNCTION.getResponse(), ResponseCode.SYSTEM_MALFUNCTION.getDescription().concat(e.getMessage()), null);
            return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(value = {"/accounts"},method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<AccountResponseBO> getAccounts(@RequestHeader(value = "Authorization", required = true) String authorization) {


        logger.info("basic auth ::" + authorization);
        String base64Auth = authorization.split(" ")[1];
        logger.info("base64 encoded value:" + base64Auth);

        String[] user_password = CipherUtil.decodeBase64Str(base64Auth);
        try{
            if (!CipherUtil.basicAuthValidation(user_password)) {
                BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.INVALID_CREDENTIALS.getResponse(), ResponseCode.INVALID_CREDENTIALS.getDescription(), null);
                return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.UNAUTHORIZED);
            }

        }catch (NoSuchSystemUserException e){
            logger.error(e.getMessage(),e);
            BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.NO_SUCH_USER.getResponse(), ResponseCode.NO_SUCH_USER.getDescription(), null);
            return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.UNAUTHORIZED);
        }


        try {
            AccountResponseBO accountResponseBO = accountService.getAccounts();

            if(ObjectUtils.isEmpty(accountResponseBO)) {
                BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.NO_RESOURCE_FOUND.getResponse(), ResponseCode.NO_RESOURCE_FOUND.getDescription(), null);
                return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null), HttpStatus.NOT_FOUND);
            }
            logger.info(accountResponseBO.toString());
            return new ResponseEntity<AccountResponseBO>(HttpStatus.OK).ok(accountResponseBO);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.SYSTEM_MALFUNCTION.getResponse(), ResponseCode.SYSTEM_MALFUNCTION.getDescription(), null);
            return new ResponseEntity<>(new AccountResponseBO(basicResponseBO, null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
