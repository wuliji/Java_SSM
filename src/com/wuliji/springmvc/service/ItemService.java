package com.wuliji.springmvc.service;

import java.util.List;

import com.wuliji.springmvc.pojo.Items;

public interface ItemService {

	List<Items> selectItemsList();

	Items selectItemsById(Integer id);

	void updateItemsById(Items items);

}
