package com.fun.simple.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Component
public class ApiClient {

    private final boolean proxyActive;
    private final String proxyHostname;
    private final int proxyPort;

    public ApiClient(@Value("${proxy.active}") boolean proxyActive,
                     @Value("${proxy.hostname}") String proxyHostname,
                     @Value("${proxy.port}") int proxyPort
    ) {
        this.proxyActive = proxyActive;
        this.proxyHostname = proxyHostname;
        this.proxyPort = proxyPort;
    }


    private HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor());
        if (proxyActive) {
            client.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHostname, proxyPort)));
        }

        return client.build();
    }

    public Retrofit getRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build();
        return retrofit;
    }

    public <S> S createService(String baseUrl, Class<S> serviceClass) {
        return getRetrofit(baseUrl).create(serviceClass);
    }

}
