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
	    
}
}

class Test2 extends Test<Account>{
	
}