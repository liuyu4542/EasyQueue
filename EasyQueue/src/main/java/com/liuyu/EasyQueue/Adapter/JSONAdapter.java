package com.liuyu.EasyQueue.Adapter;
import java.util.HashMap;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
/**类型转换器*/
public class JSONAdapter {
	public static List<HashMap<String, Object>> getListType(String message){
		return  JSON.parseObject(message,new TypeReference<List<HashMap<String,Object>>>(){});
	}
	public static String parseListType(List<HashMap<String, Object>> list){
		return  JSON.toJSONString(list);
	}
	public static HashMap<String, Object> getHashMapType(String message){
		return  JSON.parseObject(message,new TypeReference<HashMap<String,Object>>(){});
	}
	public static String parseHashMapType(HashMap<String, Object> map){
		return  JSON.toJSONString(map);
	}
}
