package com.yayao.base;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@SuppressWarnings("rawtypes")
@Service
public class BaseServiceImpl<T,ID>  implements BaseService<T,ID>{
	@Resource
	private BaseDao baseDao;

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object t) {
		return baseDao.add(t);
	}

	@Override
	public boolean delete(Integer ID) {
		return baseDao.delete(ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean update(Object t) {
		return baseDao.update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Integer ID) {
		return (T) baseDao.load(ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countAll(Map eq, Map gt, Map ge, Map lt, Map le, Map between, Map like, Map in) {
		return baseDao.countAll(eq, gt, ge, lt, le, between, like, in);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List browse(int pageNum, int pageSize, String orderName, String orderWay, Map eq, Map gt, Map ge, Map lt,
			Map le, Map between, Map like, Map in) {
		return baseDao.browse(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
	}

	
	
}