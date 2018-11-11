package in.co.myrupee.service;

import in.co.myrupee.model.BasicResponseBO;

public interface AuthService {

    BasicResponseBO setCustomerPin(String username, String pin) throws Exception;
}
