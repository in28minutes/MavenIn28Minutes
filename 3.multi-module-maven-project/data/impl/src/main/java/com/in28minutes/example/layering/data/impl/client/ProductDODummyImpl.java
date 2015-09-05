package com.in28minutes.example.layering.data.impl.client;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.example.layering.data.api.client.ProductDO;
import com.in28minutes.example.layering.model.api.client.Currency;
import com.in28minutes.example.layering.model.api.client.Product;
import com.in28minutes.example.layering.model.api.client.ProductType;
import com.in28minutes.example.layering.model.impl.client.AmountImpl;
import com.in28minutes.example.layering.model.impl.client.ProductImpl;

public class ProductDODummyImpl implements ProductDO {

	@Override
	public List<Product> getAllProducts(long clientId) {
		List<Product> products = Arrays.asList(createProductWithAmount("5.0"),
				createProductWithAmount("6.0"));
		return products;
	}

	private Product createProductWithAmount(String amount) {
		return new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
				new AmountImpl(new BigDecimal(amount), Currency.EURO));
	}

	@Override
	public List<Product> insertProduct(long clientId, Product product) {
		return null;
	}

	@Override
	public List<Product> deleteProduct(long clientId, Product product) {
		return null;
	}

	@Override
	public List<Product> updateProduct(long clientId, Product product) {
		return null;
	}

}
