package in.co.myrupee.service.impl;

import in.co.myrupee.constant.ResponseCode;
import in.co.myrupee.constant.SystemConstants;
import in.co.myrupee.dto.*;
import in.co.myrupee.model.*;
import in.co.myrupee.repository.*;
import in.co.myrupee.service.AccountService;
import in.co.myrupee.util.VirtualCardUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountHolderIDInfoRepository accountHolderIDInfoRepository;

    @Autowired
    private AccountHolderAddressRepository accountHolderAddressRepository;

    @Autowired
    private AccountBalanceInfoRepository accountBalanceInfoRepository;


    @Override
    public AccountResponseBO createAccount(AccountBO accountBO) throws Exception{

        try {

            Account accountDto = new Account();
            accountDto.setAccountNumber(accountBO.getMsisdn());
            accountDto.setAccountType(accountBO.getAccountType());
            accountDto.setMsisdn(accountBO.getMsisdn());
            accountDto.setCountryCode(accountBO.getBirthCountryCode());
            accountDto.setEmail(accountBO.getEmail());
            accountDto.setFirstname(accountBO.getFirstname());
            accountDto.setLastname(accountBO.getLastname());
            accountDto.setProfileName(accountBO.getProfileName());
            accountDto.setStatus(SystemConstants.ACCOUNT_PENDING_STATUS);
            accountDto.setCreatedOn(new Date());

            //Need to check generated card is unique or not.
            if (!CollectionUtils.isEmpty(accountBO.getAccountBalanceInfoBOS())) {
                Set<AccountBalanceInfo> accountBalanceInfoList = new HashSet<>();
                for (AccountBalanceInfoBO accountBalanceInfoBO : accountBO.getAccountBalanceInfoBOS()) {
                    String description = accountBalanceInfoBO.getCurrencyCode().concat(" - ").concat(accountBO.getAccountType());
                    String virtualCard = VirtualCardUtil.getUniqueCardByCurrencyCode(accountBalanceInfoBO.getCurrencyCode());
                    accountBalanceInfoList.add(new AccountBalanceInfo(accountBalanceInfoBO.getCurrencyCode(), accountBalanceInfoBO.getBalance(), description, new Date(), virtualCard, SystemConstants.ACCOUNT_PENDING_STATUS,accountDto));
                }
                accountDto.setAccountBalanceInfos(accountBalanceInfoList);
            }


            if (!CollectionUtils.isEmpty(accountBO.getAccountHolderAddresses())) {
                Set<AccountHolderAddress> accountHolderAddressList = new HashSet<>();
                for (AccountHolderAddressBO accountHolderAddressBO : accountBO.getAccountHolderAddresses()) {
                    accountHolderAddressList.add(new AccountHolderAddress(accountHolderAddressBO.getStreet(), accountHolderAddressBO.getBuildingNo(), accountHolderAddressBO.getPinCode(), accountHolderAddressBO.getDistrict(), accountHolderAddressBO.getLandmark(), accountHolderAddressBO.getAddressType(), SystemConstants.ACCOUNT_PENDING_STATUS, new Date(),accountDto));
                }
                accountDto.setAccountHolderAddresses(accountHolderAddressList);
            }

            if (!CollectionUtils.isEmpty(accountBO.getAccountHolderIDInfos())) {
                Set<AccountHolderIDInfo> accountHolderIDInfoList = new HashSet<>();
                for (AccountHolderIDInfoBO accountHolderIDInfoBO : accountBO.getAccountHolderIDInfos()) {
                    accountHolderIDInfoList.add(new AccountHolderIDInfo(accountHolderIDInfoBO.getIdNumber(), accountHolderIDInfoBO.getCountryCode(), accountHolderIDInfoBO.getIssuedDate(), accountHolderIDInfoBO.getExpiredDate(), accountHolderIDInfoBO.getIssuedPlace(), new Date(), accountHolderIDInfoBO.getIdType(), accountDto));
                }
                accountDto.setAccountHolderIDInfos(accountHolderIDInfoList);
            }

            //need to create account for login
            String username =  accountBO.getProfileName().substring(0, 3).toUpperCase().concat(accountBO.getMsisdn().substring(0,8));
            AccountAuthInfo accountAuthInfo = new AccountAuthInfo();
            accountAuthInfo.setSuperPinMD5("");
            accountAuthInfo.setExpiredOn(new Date());
            accountAuthInfo.setUsername(username);
            accountAuthInfo.setAccount(accountDto);
            accountAuthInfo.setCreatedOn(new Date());
            accountDto.setAccountAuthInfo(accountAuthInfo);
            accountRepository.save(accountDto);


            AccountAuthInfoBO accountAuthInfoBO = new AccountAuthInfoBO();
            accountAuthInfoBO.setUsername(username);
            accountAuthInfoBO.setDescription("need to set pin, to get active access tokes for transactions.");

            String token = UUID.randomUUID().toString();
            TokenInfo tokenInfo = new TokenInfo(token, Calendar.getInstance().getTimeInMillis());
            ApplicationResource.ACTIVE_TOKENS.put(accountAuthInfoBO.getUsername(), tokenInfo);
            String refLink = SystemConstants.SET_PIN_RESOURCE.concat(accountAuthInfoBO.getUsername()).concat("/").concat(token);
            String createAccountDescription = String.format(SystemConstants.CREATE_ACCOUNT_TEMPLATE, new String[]{token});

            BasicResponseBO basicResponseBO = new BasicResponseBO(ResponseCode.SUCCESS.getResponse(), createAccountDescription, refLink);
            accountBO.setAccountAuthInfoBO(accountAuthInfoBO);
            List<AccountBO> accountBOList = new ArrayList<>();
            accountBOList.add(accountBO);

            AccountResponseBO accountResponseBO = new AccountResponseBO(basicResponseBO, accountBOList);
            return accountResponseBO;

        }catch (DataIntegrityViolationException de){

            throw new Exception("Database constraint violation, profile may exists with same values.");
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception("exception raised from createAccount service implementation block.");
        }
    }

    @Override
    public List<AccountBO> getAccountsByFilter(String filter) {
        return null;
    }

    @Override
    public AccountResponseBO getAccounts() throws Exception{

        try {
            AccountResponseBO accountResponseBO = new AccountResponseBO();
            List<AccountBO> accountBOList = new ArrayList<>();
            for (Account account : accountRepository.findAll()) {

                AccountBO accountBO = new AccountBO();

                if(!CollectionUtils.isEmpty(account.getAccountBalanceInfos())) {
                    List<AccountBalanceInfoBO> accountBalanceInfoBOList = new ArrayList<>();
                    for (AccountBalanceInfo balanceInfo : account.getAccountBalanceInfos()) {
                        accountBalanceInfoBOList.add(new AccountBalanceInfoBO(balanceInfo.getCurrencyCode(), balanceInfo.getBalance(), balanceInfo.getDescription(), balanceInfo.getCreatedOn(), balanceInfo.getVirtualCard(), balanceInfo.getWalletStatus()));
                    }
                    accountBO.setAccountBalanceInfoBOS(accountBalanceInfoBOList);
                }

                if(!CollectionUtils.isEmpty(account.getAccountHolderAddresses())){
                    List<AccountHolderAddressBO> accountHolderAddressBOList = new ArrayList<>();
                    for(AccountHolderAddress address:account.getAccountHolderAddresses()){
                        accountHolderAddressBOList.add(new AccountHolderAddressBO(address.getStreet(), address.getBuildingNo(),address.getPincode(),address.getDistrict(),address.getLandmark(),address.getAddressType(), address.getState()));
                    }
                    accountBO.setAccountHolderAddresses(accountHolderAddressBOList);
                }

                if(!CollectionUtils.isEmpty(account.getAccountHolderIDInfos())){
                    List<AccountHolderIDInfoBO> accountHolderIDInfoBOList =  new ArrayList<>();
                    for(AccountHolderIDInfo accountHolderIDInfo:account.getAccountHolderIDInfos()){
                        accountHolderIDInfoBOList.add(new AccountHolderIDInfoBO(accountHolderIDInfo.getIdNumber(),accountHolderIDInfo.getCountryCode(), accountHolderIDInfo.getIssuedDate(), accountHolderIDInfo.getExpiredDate(), accountHolderIDInfo.getIssuedPlace(), accountHolderIDInfo.getCreatedOn(), accountHolderIDInfo.getIdType()));
                    }
                    accountBO.setAccountHolderIDInfos(accountHolderIDInfoBOList);
                }

                accountBO.setAccountNumber(account.getAccountNumber());
                accountBO.setAccountType(account.getAccountType());
                accountBO.setBirthCountryCode(account.getCountryCode());
                accountBO.setCreatedOn(account.getCreatedOn());
                accountBO.setEmail(account.getEmail());
                accountBO.setFirstname(account.getFirstname());
                accountBO.setLastname(account.getLastname());
                accountBO.setStatus(account.getStatus());
                accountBOList.add(accountBO);
            }

            accountResponseBO.setAccountBOList(accountBOList);
            return accountResponseBO;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new Exception("exception raised from getAccount service implementation block.");
        }
    }

    @Override
    public AccountBO updateAccount(AccountBO account) {
        return null;
    }
}
