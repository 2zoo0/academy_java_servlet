package shop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import shop.exception.DuplicateException;
import shop.exception.NotFoundException;
import shop.vo.Product;

/**
 * 제품정보를 저장할 자료구를 리스트로 관리하는 창고 클래스
 * @author PC38206
 *
 */
public class MapWarehouse implements GeneralWarehouse {
	
	// 1. 멤버 변수 선언부
	private Map<String, Product> products;
	
	// 2. 생성자 선언부
	// (1) 기본 생성자
	public MapWarehouse() {
		products = new HashMap();
	}
	
	public MapWarehouse(Map<String, Product> prodsMap) {
		this.products = prodsMap;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	@Override
	public int add(Product product) throws DuplicateException {
		int successCnt = 0;
		
		if (!isExists(product)) {
			products.put(product.getProdCode(), product);
			successCnt++;
			
		} else {
			// 제품이 중복될 때
			throw new DuplicateException("add", product);
		}
		return successCnt;
	}


	@Override
	public Product get(Product product) throws NotFoundException {
		Product found = null;
		
		if (products.get(product.getProdCode()) != null) {
			found = products.get(product.getProdCode());
		} else {
			// 가져올 제품이 존재하지 않을 때
			throw new NotFoundException("get", product);
		}
		return found;
	}

	@Override
	public int set(Product product) throws NotFoundException {
		int result = -1;
		
		if (products.containsKey(product.getProdCode())) {
			products.put(product.getProdCode(), product);
			result = 1;
		} else {
			// 수정할 제품이 존재하지 않을 때
			throw new NotFoundException("get", product);
		}
		
		return result;
	}

	@Override
	public int remove(Product product) throws NotFoundException {
		int result = -1;
		
		if (products.containsKey(product.getProdCode())) {
			products.remove(product.getProdCode(), product);
			
			result = 1;
		} else {
			// 삭제할 제품이 존재하지 않을 때
			throw new NotFoundException("remove", product);
		}
		return result;
	}

	@Override
	public List<Product> getAllProducts() {	
		Set<String> keySet = this.products.keySet();
		List<Product> products = new ArrayList<Product>();
		for (String key : keySet) {
			products.add(this.products.get(key));
		}
		
		return products;
	}
	
	private boolean isExists(Product product) {
		return products.containsKey(product.getProdCode());
	}
	
}