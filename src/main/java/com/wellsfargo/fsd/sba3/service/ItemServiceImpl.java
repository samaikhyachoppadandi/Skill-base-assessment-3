package com.wellsfargo.fsd.sba3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.sba3.dao.ItemRepository;
import com.wellsfargo.fsd.sba3.entity.Item;
import com.wellsfargo.fsd.sba3.exception.CustomException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	@Override
	@Transactional
	public Item add(Item item) throws CustomException {
		if(item!=null) {
			if(itemRepo.existsById(item.getIcode())) {
				throw new CustomException("Item code already used!");
			}
			
			itemRepo.save(item);
		}
		return item;
	}

	@Override
	@Transactional
	public Item save(Item item) throws CustomException {
		if(item!=null) {
			if(!itemRepo.existsById(item.getIcode())) {
				throw new CustomException("Item Not Found");
			}
			
			itemRepo.save(item);
		}
		return item;
	}

	@Override
	@Transactional
	public boolean deleteItem(int icode) throws CustomException {
		if(!itemRepo.existsById(icode)) {
			throw new CustomException("Item Not Found");
		}
	
		itemRepo.deleteById(icode);
		return true;
	}

	@Override
	public Item getItemById(int icode) throws CustomException {
		return itemRepo.findById(icode).orElse(null);		
	}

	@Override
	public List<Item> getAllItems() throws CustomException {
		return itemRepo.findAll();
	}

}
