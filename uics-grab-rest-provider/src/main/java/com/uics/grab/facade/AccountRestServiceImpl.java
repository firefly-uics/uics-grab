package com.uics.grab.facade;

import com.uics.grab.entity.Account;
import com.uics.grab.service.AccountService;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class AccountRestServiceImpl implements AccountRestService {

  private static final Logger logger = LoggerFactory.getLogger(AccountRestServiceImpl.class);

  private AccountService accountService;

  public AccountService getAccountService() {
      return accountService;
  }

  public void setAccountService(AccountService accountService) {
      this.accountService = accountService;
  }

  @Override
  public RestResult signIn(SignInVO signIn) {
      Account account = new Account();
      account.setName(signIn.getName());
      account.setPassword(signIn.getPassword());

      logger.debug("username:{}", signIn.getName());
      Account admin = accountService.signIn(account);


      logger.debug("admin:{}", admin);

      RestResult result = RestResult.OK(ImmutableMap.of("id", 4026, "enterprise", ImmutableMap.of("id", 2, "name", "锐捷网络"),"name","白群伟"));

      return result;
  }

  @Override
  public RestResult signUp(SignUpVO signUp) {
      return null;
  }

}
