
package com.networknt.eventuate.customer.command.handler;

import com.networknt.client.Client;
import com.networknt.server.Server;
import com.networknt.exception.ClientException;
import com.networknt.exception.ApiException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class ServerInfoGetHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(ServerInfoGetHandlerTest.class);

    @Test
    public void testServerInfoGetHandlerTest() throws ClientException, ApiException {
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpGet httpGet = new HttpGet ("http://localhost:8083/v1/server/info");

       // Client.getInstance().addAuthorization(httpGet);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
         //   Assert.assertEquals("", IOUtils.toString(response.getEntity().getContent(), "utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
