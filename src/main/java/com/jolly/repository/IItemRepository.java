package com.jolly.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jolly.model.Item;

@Repository
public interface IItemRepository extends CrudRepository <Item, Long>{
	//custom
	List<Item> findAllByOrderByIdDesc();

}
