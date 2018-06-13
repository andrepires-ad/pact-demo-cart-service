package com.appdirect.pactdemo.carts.apiclients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
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

		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().failOnUnknownProperties(false).build();


		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(getBaseUrl())
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create(objectMapper))
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
