package io.github.znetworkw.znpcservers.http.internal;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import io.github.znetworkw.znpcservers.http.AsyncHttpClient;
import io.github.znetworkw.znpcservers.http.HttpClient;
import io.github.znetworkw.znpcservers.http.HttpRequest;
import io.github.znetworkw.znpcservers.http.HttpResponse;

/**
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class DelegateAsyncHttpClient implements AsyncHttpClient {
    private final ListeningExecutorService executorService;
    private final HttpClient delegate;

    public DelegateAsyncHttpClient(ListeningExecutorService executorService, HttpClient delegate) {
        this.executorService = executorService;
        this.delegate = delegate;
    }

    @Override
    public ListenableFuture<HttpResponse> executeAsync(HttpRequest request) {
        return executorService.submit(() -> delegate.execute(request));
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
