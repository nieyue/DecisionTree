package com.yayao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.dao.BaseDao;
import com.yayao.service.BaseService;

/**
 * 基础接口实现类
 * 定义为抽象类，不交由spring ioc管理,子类交由spring管理即可.
 * @author 聂跃
 * @date 2018年4月17日
 */
public abstract class BaseServiceImpl<T,ID>  implements BaseService<T,ID>{
	@Autowired
	private BaseDao<T,ID> baseDao;
	@Override
	public boolean add(T t) {
		return baseDao.add(t);
	}

	@Override
	public boolean delete(Integer ID) {
		return baseDao.delete(ID);
	}

	@Override
	public boolean update(T t) {
		return baseDao.update(t);
	}

	@Override
	public T load(Integer ID) {
		return (T) baseDao.load(ID);
	}

	@Override
	public int countAll(Map<String, Object> eq, Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt,
			Map<String, Object> le, Map<String, List<Object>> between, Map<String, Object> like,
			Map<String, List<Object>> in) {
		return baseDao.countAll(eq, gt, ge, lt, le, between, like, in);
	}

	@Override
	public List<T> list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		return baseDao.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
	}

}