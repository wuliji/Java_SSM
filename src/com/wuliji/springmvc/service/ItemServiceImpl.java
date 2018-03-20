package com.wuliji.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuliji.springmvc.dao.ItemsMapper;
import com.wuliji.springmvc.pojo.Items;



/**
 * ��ѯ��Ʒ��Ϣ
 * @author lx
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	//��ѯ��Ʒ�б�
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	//�޸�
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
