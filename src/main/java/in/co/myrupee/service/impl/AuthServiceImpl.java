package in.co.myrupee.service.impl;

import in.co.myrupee.constant.ResponseCode;
import in.co.myrupee.constant.SystemConstants;
import in.co.myrupee.dto.AccountAuthInfo;
import in.co.myrupee.model.BasicResponseBO;
import in.co.myrupee.repository.AccountAuthInfoRepository;
import in.co.myrupee.service.AuthService;
import in.co.myrupee.util.CipherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AuthServiceImpl implements AuthService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    AccountAuthInfoRepository accountAuthInfoRepository;


    @Override
    public BasicResponseBO setCustomerPin(String username, String pin) throws Exception {

        try {

            AccountAuthInfo accountAuthInfo = accountAuthInfoRepository.findByUsername(username);
            accountAuthInfo.setSuperPinMD5(CipherUtil.getMessageDigest(pin));
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,1);
            accountAuthInfo.setExpiredOn(calendar.getTime());
            accountAuthInfoRepository.save(accountAuthInfo);
            return new BasicResponseBO(ResponseCode.SUCCESS.getResponse(), ResponseCode.SUCCESS.getDescription().concat(SystemConstants.PIN_ACTION_SUCCESS), null);
        } catch (Exception e) {
            throw new Exception("exception raised from setCustomerPin service implementation block.");
        }
    }
}
