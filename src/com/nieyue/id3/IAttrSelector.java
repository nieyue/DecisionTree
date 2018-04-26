package com.nieyue.id3;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;  
  
/** 
 * 最佳分裂点属性选择算法接口
 */  
public interface IAttrSelector<T> {  
    public Field select(List<T> records, Set<Field> atrrs);  
} 