/**
 * Http client начиная с openjdk11
 */

package base.utilits;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.*;
import java.nio.file.Paths;
import java.time.Duration;
import java.net.http.HttpClient;

public class HttpClientR {

    private HttpClient client;

    private HttpRequest request;

    private HttpResponse<String> response;

    public HttpClientR() {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                //TODO реализовать конструктор для проски (не приоритет)
                //.proxy(ProxySelector.of(new InetSocketAddress("proxy", 80)))
                //TODO реализовать конструктор для аутентификации
                //.authenticator(Authenticator.getDefault())
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    private HttpRequest createPostReq(String urlApiPoint, String reqBody) {
        return HttpRequest.newBuilder()
                .uri(URI.create(urlApiPoint))
                .timeout(Duration.ofMinutes(1))
                //TODO реализовать метод для передачи файлов "application/json"
                .header("Content-Type", "text/json")
                .POST(HttpRequest.BodyPublishers.ofString(reqBody))
                .build();
    }

    public void getPostResponse(String urlApiPoint, String reqBody) throws IOException, InterruptedException {
        this.response =
                this.client.send(createPostReq(urlApiPoint, reqBody), HttpResponse.BodyHandlers.ofString());
        System.out.println(this.response.statusCode());
        System.out.println(this.response.body());
    }

}
