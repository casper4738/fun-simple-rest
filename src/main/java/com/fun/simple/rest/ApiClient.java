package com.fun.simple.rest;

import com.fun.simple.rest.ata.daily.FunGlobal;
import com.fun.simple.rest.ata.daily.retrofit.TeamsDailyApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Service
public class ApiClient {

    private HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    private OkHttpClient getClient() {
//        String hostname = "kpproxygsit.intra.bca.co.id";
//        int port = 8080;
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port));

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getLoggingInterceptor())
//                .proxy(proxy)
                .build();
        return client;
    }

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FunGlobal.TEAMS_WEBHOOK_INCOMING)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
        return retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

}
