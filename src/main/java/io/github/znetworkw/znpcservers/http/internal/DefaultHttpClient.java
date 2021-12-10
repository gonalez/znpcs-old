package io.github.znetworkw.znpcservers.http.internal;

import io.github.znetworkw.znpcservers.http.HttpMethod;
import io.github.znetworkw.znpcservers.http.HttpClient;
import io.github.znetworkw.znpcservers.http.HttpRequest;
import io.github.znetworkw.znpcservers.http.HttpResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class DefaultHttpClient implements HttpClient {
    public static HttpClient INSTANCE = new DefaultHttpClient();

    @Override
    public HttpResponse execute(HttpRequest request) throws IOException {
        final HttpURLConnection urlConnection =
            (HttpURLConnection) request.uri().toURL().openConnection();
        urlConnection.setConnectTimeout(request.timeout());
        urlConnection.setRequestMethod(request.method().name());
        if (request.method() == HttpMethod.POST) {
            urlConnection.setDoOutput(true);
            try (DataOutputStream outputStream =
                     new DataOutputStream(urlConnection.getOutputStream())) {
                outputStream.writeBytes(request.body());
                outputStream.flush();
            }
        }
        return new DefaultHttpResponse(
            urlConnection.getInputStream(), urlConnection.getResponseCode(),
            urlConnection.getResponseMessage());
    }
}
