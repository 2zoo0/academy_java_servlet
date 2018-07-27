package shop.dao;

import java.util.List;

import shop.exception.DuplicateException;
import shop.exception.NotFoundException;
import shop.vo.Product;

/**
 * 제품을 관리하기 위한 창고의 기능을 선언한 인터페이스
 * @author PC38207
 *
 */
public interface GeneralWarehouse {

	public abstract int add(Product product) throws DuplicateException;
	public abstract Product get(Product product) throws NotFoundException;
	public abstract int set(Product product) throws NotFoundException;
	public abstract int remove(Product product) throws NotFoundException;
	public abstract List<Product> getAllProducts();
}
