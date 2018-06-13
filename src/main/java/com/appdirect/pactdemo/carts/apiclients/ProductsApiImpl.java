package com.appdirect.pactdemo.carts.apiclients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class ProductsApiImpl implements ProductsApi {

	@Value("${products.url}")
	private String baseUrl;

	@Override
	public Call<ProductWsDTO> getProductById(String id) {
		OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

		OkHttpClient client = builder.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(getBaseUrl())
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();

		ProductsApi productsAPI = retrofit.create(ProductsApi.class);

		return productsAPI.getProductById(id);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
