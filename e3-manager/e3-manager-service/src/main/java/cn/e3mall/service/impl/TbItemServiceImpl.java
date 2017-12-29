package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pageHelper.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.TbItemService;
/**
 * 商品管理Service
 * @author LiuTaiwen
 *
 */
@Service
public class TbItemServiceImpl implements TbItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//根据主键查询
//		TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public DataGridResult getItemByDataGrid(int page, int rows) {
		//1.设置分页
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example );
		//取分页信息
		PageInfo<TbItem> info = new PageInfo<>(list);
		
		//获取总的条数
		long total = info.getTotal();
		
		//创建DataGridResult对象
		DataGridResult result = new DataGridResult();
		//为DataGridResult对象设置参数
		result.setTotal(total);
		result.setRows(list);
		//返回result
		return result;
	}

}
