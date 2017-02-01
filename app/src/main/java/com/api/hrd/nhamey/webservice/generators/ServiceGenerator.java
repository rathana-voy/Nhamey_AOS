package com.api.hrd.nhamey.webservice.generators;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rathana on 04/01/17.
 */

public class ServiceGenerator {

    // REMOTE SERVER
    public final static String ApiBaseUrl = "http://120.136.24.174:1304";
    private final static String KeyHeader="Basic c2V5aGE6Z3JvdXAyMTIzNDU2";

    // LOCAL SERVER
    /*public final static String ApiBaseUrl = "http://10.0.2.2:2017";
    private final static String KeyHeader="Basic c2V5aGE6Z3JvdXAyMTIzNDU2";*/

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(ApiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        //.header("Authorization", otherKeyHeader)
                        //for add orther api url
                        .addHeader("Authorization",KeyHeader)
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit= builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
