package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public EasyUIResult findItems(Integer page, Integer rows) {
		
		int total = itemMapper.findItemCount();
		
		Integer start = (page-1)*rows;
		List<Item> itemList = itemMapper.findItemByPage(start,rows);
		
		
		return new EasyUIResult(total, itemList);
	}

	@Override
	public String findItemCatNameById(Long itemId) {
		
		
		return itemMapper.findItemCatNameById(itemId);
	}

	@Override
	public void saveItem(Item item) {
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insert(item);
		
		
	}

	@Override
	public void updateItem(Item item) {
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKey(item);
	}

}
