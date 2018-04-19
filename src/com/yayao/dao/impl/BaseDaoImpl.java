package com.yayao.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.yayao.dao.BaseDao;
/**
 * 基础数据访问接口实现类
 * 定义为抽象类，不交由spring ioc管理,子类交由spring管理即可.
 * @author 聂跃
 * @date 2018年4月17日
 */
public abstract class BaseDaoImpl<T,ID> implements BaseDao<T,ID>{
	@Resource
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	/**
	 * 获取类类型
	 */
	Class<T> getT(){
		Type genType = getClass().getGenericSuperclass();  
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		Class<T> entityClass = (Class<T>) params[0];
		return entityClass;
	}
	
	@Override
	public boolean add(T t) {
	 try{
		 getSession().save(t);
		// getSession().close();
	     return true;
	    }catch(Exception e){
	     //getSession().close();
	     return false;
	    }
	}

	@Override
	public boolean delete(Integer ID) {
		T t = (T)getSession().get(getT(), ID);
		 try{
			 getSession().delete(t);
			 //getSession().close();
		        return true;
		    }catch(Exception e){
		    	//getSession().close();
		        return false;
		    }
	}

	@Override
	public boolean update(T t) {
		try{
			 getSession().merge(t);
			// getSession().close();
		        return true;
		    }catch(Exception e){
		    //	getSession().close();
		        return false;
		    }
	}

	@Override
	public T load(Integer ID) {
		@SuppressWarnings("unchecked")
		T t = (T)getSession().get(getT(), ID);
		return t;
	}


	@Override
	public int countAll(Map<String, Object> eq, Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt,
			Map<String, Object> le, Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Criteria c = getSession().createCriteria(getT());
		//不为空，则遍历
		//等于
		if(MapUtils.isNotEmpty(eq)){
			for (Map.Entry<String, Object> entry : eq.entrySet()) {
				c.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		//大于
		if(MapUtils.isNotEmpty(gt)){
			for (Map.Entry<String, Object> entry : gt.entrySet()) {
				c.add(Restrictions.gt(entry.getKey(), entry.getValue()));
			}
		}
		//大于等于
		if(MapUtils.isNotEmpty(ge)){
			for (Map.Entry<String, Object> entry : ge.entrySet()) {
				c.add(Restrictions.ge(entry.getKey(), entry.getValue()));
			}
		}
		//小于
		if(MapUtils.isNotEmpty(lt)){
			for (Map.Entry<String, Object> entry : lt.entrySet()) {
				c.add(Restrictions.lt(entry.getKey(), entry.getValue()));
			}
		}
		//小于等于
		if(MapUtils.isNotEmpty(le)){
			for (Map.Entry<String, Object> entry : le.entrySet()) {
				c.add(Restrictions.le(entry.getKey(), entry.getValue()));
			}
		}
		//between
		if(MapUtils.isNotEmpty(between)){
			for (Map.Entry<String, List<Object>> entry : between.entrySet()) {
				c.add(Restrictions.between(entry.getKey(), entry.getValue().get(0),entry.getValue().get(1)));
			}
		}
		//like模糊查询
		if(MapUtils.isNotEmpty(like)){
			for (Map.Entry<String, Object> entry : like.entrySet()) {
				c.add(Restrictions.like(entry.getKey(), "%"+entry.getValue()+"%"));
			}
		}
		//in 多个值里面
		if(MapUtils.isNotEmpty(in)){
			for (Map.Entry<String, List<Object>> entry : in.entrySet()) {
				c.add(Restrictions.in(entry.getKey(), entry.getValue()));
			}
		}
		//行数
		c.setProjection(Projections.rowCount()); 
		return ((Long)c.uniqueResult()).intValue();
	}

	@Override
	public List<T> list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Criteria c = getSession().createCriteria(getT());
		//不为空，则遍历
		//等于
		if(MapUtils.isNotEmpty(eq)){
			for (Map.Entry<String, Object> entry : eq.entrySet()) {
				c.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		//大于
		if(MapUtils.isNotEmpty(gt)){
			for (Map.Entry<String, Object> entry : gt.entrySet()) {
				c.add(Restrictions.gt(entry.getKey(), entry.getValue()));
			}
		}
		//大于等于
		if(MapUtils.isNotEmpty(ge)){
			for (Map.Entry<String, Object> entry : ge.entrySet()) {
				c.add(Restrictions.ge(entry.getKey(), entry.getValue()));
			}
		}
		//小于
		if(MapUtils.isNotEmpty(lt)){
			for (Map.Entry<String, Object> entry : lt.entrySet()) {
				c.add(Restrictions.lt(entry.getKey(), entry.getValue()));
			}
		}
		//小于等于
		if(MapUtils.isNotEmpty(le)){
			for (Map.Entry<String, Object> entry : le.entrySet()) {
				c.add(Restrictions.le(entry.getKey(), entry.getValue()));
			}
		}
		//between
		if(MapUtils.isNotEmpty(between)){
			for (Map.Entry<String, List<Object>> entry : between.entrySet()) {
				c.add(Restrictions.between(entry.getKey(), entry.getValue().get(0),entry.getValue().get(1)));
			}
		}
		//like模糊查询
		if(MapUtils.isNotEmpty(like)){
			for (Map.Entry<String, Object> entry : like.entrySet()) {
				c.add(Restrictions.like(entry.getKey(), "%"+entry.getValue()+"%"));
			}
		}
		//in 多个值里面
		if(MapUtils.isNotEmpty(in)){
			for (Map.Entry<String, List<Object>> entry : in.entrySet()) {
				c.add(Restrictions.in(entry.getKey(), entry.getValue()));
			}
		}
		//分页
		if(pageNum<=1){
		 pageNum=1;//从第一个记录开始
		 c.setFirstResult(pageNum-1);
		}
		if(pageSize<=0){
		pageSize=0;//最少0个返回值
		c.setMaxResults(pageSize);
		}
		//排序
		if(orderWay!=null&&orderWay.equals("desc")){
			if(!StringUtils.isEmpty(orderName)){
				c.addOrder(Order.desc(orderName));			
			}
		}else{
			if(!StringUtils.isEmpty(orderName)){
			c.addOrder(Order.asc(orderName));	
			}
		}
		@SuppressWarnings("unchecked")
		List<T> ts=c.list();
		return ts;
	}
}
