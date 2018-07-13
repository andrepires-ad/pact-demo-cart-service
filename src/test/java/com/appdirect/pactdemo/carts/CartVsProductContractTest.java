package com.appdirect.pactdemo.carts;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.appdirect.pactdemo.carts.apiclients.ProductWsDTO;
import com.appdirect.pactdemo.carts.apiclients.ProductsApiImpl;
import com.google.common.collect.ImmutableMap;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class CartVsProductContractTest {

	private static final String CONSUMER_SERVICE = "demo-cart-service";
	private static final String PROVIDER_SERVICE = "demo-product-service";
	private static final String UUID = "e2490de5-5bd3-43d5-b7c4-526e33f71304";

	// This is the mock provider for the PRODUCT SERVICE
	@Rule
    public PactProviderRuleMk2 productsRule = new PactProviderRuleMk2(PROVIDER_SERVICE, "localhost", 8080, this);

	@Pact(consumer=CONSUMER_SERVICE, provider=PROVIDER_SERVICE)
	public RequestResponsePact createFragments(PactDslWithProvider builder) {

		final Map<String, String> headers = ImmutableMap.<String, String>builder()
				.put("Content-Type", "application/json")
				.build();

		return builder
				// successful scenario
				.given("product id exist")
				.uponReceiving("a request for 1 product")
				.path("/products/" + UUID)
				.method("GET")
				.headers(headers)
				.willRespondWith()
				.status(200)
				.body(buildPactResponse())
				.headers(headers)
				.toPact();
	}

    @Test
    @PactVerification(PROVIDER_SERVICE)
    public void runTest() throws IOException {
		final ProductsApiImpl productsApi = new ProductsApiImpl();
		productsApi.setBaseUrl(productsRule.getConfig().url());

		ProductWsDTO productWsDTO = productsApi.getProductById(UUID).execute().body();

		assertEquals(UUID, productWsDTO.getId());
		assertNotNull(productWsDTO.getName());
    }


	private PactDslJsonBody buildPactResponse() {
		PactDslJsonBody object = new PactDslJsonBody()
				.uuid("id", UUID)
				.stringType("name");
		return object;
	}
}
