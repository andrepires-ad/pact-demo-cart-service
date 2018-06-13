package com.appdirect.pactdemo.carts.apiclients;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductsApi {
  /**
   * Get product list
   * Returns a product list.
   * @return List&lt;ProductWsDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("/products/{id}")
  Call<ProductWsDTO> getProductById(@Path(value = "id") String id);

}
