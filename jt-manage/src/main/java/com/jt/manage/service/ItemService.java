package com.jt.manage.service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;

public interface ItemService {

	EasyUIResult findItems(Integer page, Integer rows);

	String findItemCatNameById(Long itemId);

	void saveItem(Item item);

	void updateItem(Item item);

}
