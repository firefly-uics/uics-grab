
package com.uics.grab.consumer;


import com.uics.grab.entity.From;
import com.uics.grab.facade.SignInVO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author baiqw
 */
public class RestClient {

  public static void main(String[] args) {
      final String port = "8828";
      signIn("http://localhost:" + port + "/api/v2/accounts/sign-in", MediaType.APPLICATION_JSON_TYPE);
  }

  private static void signIn(String url, MediaType mediaType) {
      System.out.println("signIn account via " + url);
      SignInVO account = new SignInVO();
      account.setName("白群伟");
      account.setPassword("123456");

      From from = new From();
      from.setAgentId("test");
      from.setAgentName("R03025");
      from.setAgentType("MacOS");
      from.setClientVersion("1.0");
      from.setLocation("1,2,3");
      from.setOsVersion("10.10.5");

      account.setFrom(from);

      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(url);
      Response response = target.request().post(Entity.entity(account, mediaType));

      try {
          if (response.getStatus() != 200) {
              throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
          }
          System.out.println("Successfully got result: " + response.readEntity(String.class));
      } finally {
          response.close();
          client.close();
      }
  }
}
