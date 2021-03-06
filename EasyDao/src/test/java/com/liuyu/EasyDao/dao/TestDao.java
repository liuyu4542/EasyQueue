package com.liuyu.EasyDao.dao;

import java.util.List;
import java.util.Map;
import com.liuyu.EasyDao.annotation.Conditions;
import com.liuyu.EasyDao.annotation.EasyDao;
import com.liuyu.EasyDao.annotation.Params;
import com.liuyu.EasyDao.annotation.Statement;
import com.liuyu.EasyDao.annotation.executeSql;
@EasyDao
public interface TestDao {
	@executeSql("select count(*) from demo")
	Integer getCount();
	@Params({"id","username"})
	@executeSql("insert into user_info (id, username) values (:id, :username)")
	public int insertUserInfo(String id,String username);
	@Params({"id","username"})
	@executeSql("update user_info set username=:username where id=:id")
	public int updateUserInfo(String id,String username);
	@executeSql("select * from demo")
	public List<Map<String,Object>> queryAll();
	@Params("id")
	@Statement("select2")
	public List<Map<String,Object>> queryStatement(String id);
	@Conditions({"id","name"})
	@Params({"id","name"})
	@executeSql("select * from demo")
	public List<Map<String,Object>> queryCondition(String id,String name);
}
