# ProductsApi

All URIs are relative to *https://www.appdirect.com/product/0.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductById**](ProductsApi.md#getProductById) | **GET** /products/{productId} | Get product by id


<a name="getProductById"></a>
# **getProductById**
> getProductById(productId)

Get product by id

Returns the product.

### Example
```java
// Import classes:
//import com.appdirect.demo.product.ApiException;
//import com.appdirect.demo.product.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String productId = "productId_example"; // String | The product id
try {
    apiInstance.getProductById(productId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#getProductById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **String**| The product id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

