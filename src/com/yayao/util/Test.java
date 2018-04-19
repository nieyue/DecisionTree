package com.yayao.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.yayao.bean.Account;

public class Test<T> {
	Class<T> getClass1(){
		Type genType =this. getClass().getGenericSuperclass();  
	     Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	     Class<T> entityClass = (Class<T>) params[0];  
	     return entityClass;
	}
	
	public static void main(String[] args) {
		Test2 t=new Test2();
		 System.out.println(((ParameterizedType)new Test2().getClass().getGenericSuperclass()));  
	    System.out.println((t.getClass1().getSimpleName()));
	    Map<Object,Object> maps=new HashMap<>();
	    maps.put(23, 213);
	    System.out.println(maps.get(23));
	    System.out.println(MapUtils.isEmpty(maps));
	    //System.out.println(maps.size());
	    	Test3 test3=new Test4();
			try {
				System.out.println(Test4.class.newInstance().equals(new Test4()));
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}
}

class Test2 extends Test<Account>{
	
}
 interface Test3{

}
 class Test4 implements Test3{
	 int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test4 other = (Test4) obj;
		if (a != other.a)
			return false;
		return true;
	}
	 
 }