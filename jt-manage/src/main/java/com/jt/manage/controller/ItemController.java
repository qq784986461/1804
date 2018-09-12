package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItems(Integer page,Integer rows){

		return itemService.findItems(page,rows);
	}
	
	/**
	 * @ResponseBody 解析说明
	 * 	如果解析的是对象 则默认使用UTF-8编码格式
	 *  如果解析的是String字符串,则默认使用ISO-8859-1编码
	 *  源码:
	 *  public static final Charset DEFAULT_CHARSET = 
	 *  Charset.forName("ISO-8859-1");
	 * @param itemId
	 * @return
	 *  
	 */
	@RequestMapping(value="/cat/queryItemName",produces="html/text;charset=utf-8")
	@ResponseBody
	public String findItemCatNameById(Long itemId){
		return itemService.findItemCatNameById(itemId);
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item){
		
		try {
			itemService.saveItem(item);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品新增失败");
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item){
		try {
			itemService.updateItem(item);
			return SysResult.oK();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品修改失败");
		
	}
}














