package com.jolly.service;

import java.util.List;

import com.jolly.model.Item;

public interface IItemService {

	List<Item> getAllItems();
	Item saveItem(Item item);
	Item getItemById(Long id);
	Item updateItem(Item item);
	void deleteItem(Long id);
}
