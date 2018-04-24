package com.yayao.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.Analyse;
import com.yayao.service.AnalyseService;


/**
 * 分析
 * @author yy
 *
 */
public class AnalyseAction extends BaseAction<Analyse,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyseService analyseService;
	private Analyse analyse=new Analyse();//分析模型

	@Override
	public Analyse getModel() {
		return analyse;
	}
	/**
	 * 增加
	 */
	public String add()  {
		analyse.setUpdateDate(new Date());
		return super.add(analyse);
	}
	/**
	* 更新
	*/
	public String update()  {
		analyse.setUpdateDate(new Date());
		return super.update(analyse);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(analyse.getAnalyseId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(analyse.getAnalyseId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		return super.countAll(null, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, null, null, null, null, null, null, null, null);
	}

	
}