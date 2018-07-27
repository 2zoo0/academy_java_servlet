package shop.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shop.vo.Product;

/**
 * 제품정보를 저장할 자료구를 리스트로 관리하는 창고 클래스
 * @author PC38206
 *
 */
public class SetWarehouse implements GeneralWarehouse {
	
	// 1. 멤버 변수 선언부
	private Set<Product> products;
	
	// 2. 생성자 선언부
	// (1) 기본 생성자
	public SetWarehouse() {
		products = new HashSet<Product>();
	}
	
	public SetWarehouse(Set<Product> prodsSet) {
		this.products = prodsSet;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int add(Product product) {
		boolean success = products.add(product);
		int successCnt = 0;
		
		if (success) {
			successCnt++;
		} 
		return successCnt;
	}


	@Override
	public Product get(Product product) {
		Product found = null;
		
		for (Product prod : products) {
			if (prod.equals(product)) {
				found = prod;
				break;
			}
		}
		return found;
	}

	@Override
	public int set(Product product) {
		int result = -1;
		if (products.contains(product)) {
			products.remove(product);
			products.add(product);
			result = 1;
		}
		
		return result;
	}

	@Override
	public int remove(Product product) {
		int result = -1;
		if (products.contains(product)) {
			products.remove(product);
			result = 1;
		}
		return result;
	}

	@Override
	public List<Product> getAllProducts() {	
		List<Product> products = new ArrayList<Product>();
		
		for (Product prod : this.products) {
			products.add(prod);
		}
		return products;
	}
	
//	// 리스트 안에 찾으려는 제품의 인덱스를 구하는 지원 메소드
//	private int findProductIdx(Product product) {
//		int index = -1;
//
//		for (int idx = 0; idx < products.size(); idx++) {
//			if (products.get(idx).equals(product)) {
//				index = idx;
//				break;
//			}
//		}
//		
//		return index;
//	}

}