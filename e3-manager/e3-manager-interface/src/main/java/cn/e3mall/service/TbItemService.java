package cn.e3mall.service;

import cn.e3mall.pageHelper.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface TbItemService {

	TbItem getItemById(long itemId);
	
	DataGridResult getItemByDataGrid(int page,int rows);
}
