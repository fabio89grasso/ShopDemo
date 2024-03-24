package com.jolly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jolly.model.Item;
import com.jolly.repository.IItemRepository;
import com.jolly.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private IItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		return (List<Item>) itemRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
	

}
