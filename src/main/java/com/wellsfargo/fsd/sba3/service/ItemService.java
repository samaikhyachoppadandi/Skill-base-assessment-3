
package com.wellsfargo.fsd.sba3.service;

import java.util.List;

import com.wellsfargo.fsd.sba3.entity.Item;
import com.wellsfargo.fsd.sba3.exception.CustomException;

public interface ItemService {

	Item add(Item item) throws CustomException;

	Item save(Item item) throws CustomException;

	boolean deleteItem(int icode) throws CustomException;

	Item getItemById(int icode) throws CustomException;

	List<Item> getAllItems() throws CustomException;
}
