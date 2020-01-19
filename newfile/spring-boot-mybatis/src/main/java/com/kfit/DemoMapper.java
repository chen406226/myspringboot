package com.kfit;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
//@Mapper已经使用Mapperscan所以不需要单独注入
public interface DemoMapper {
	//#{name}参数站位符
	@Select("select * from Demo where name = #{name}")
	public List<Demo> likeName(String name);
	
	@Select("select * from Demo where id = #{id}")
	public String getById(long id);
	
	@Select("select name from Demo where id = #{id}")
	public String getNameById(long id);
	
	/*保存数据*/
	@Insert("insert into Demo(name) values(#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")//返回主键id
	public void save(Demo demo); 
	//形参里面用@param获取异常
	/*获取自增长id
	 * @insert("insert into Demo(name,password) values(#{name},#{password})")
	 * public long save(Demo name)
	 * @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	 * */
	
	@Update("update demo set name=#{name} where id =#{id}")
	public int update(Demo demo);
	
	@Delete("delete from demo where id=#{id}")
	public int delete(int id);
	
	@Select("select * from demo")
	public List<Demo> selectAll();
	
	@Select("select * from demo where id = #{id}")
//	@Results({
//		@Result(property="updateTime",column="update_time"),
//		@Result(property="sexEnum",column="sex_enum",javaType=SexEnum.class)
//	})
	public Demo selectById(int id);
	
	@Select("select * from demo where name=#{name} and email=#{email}")
	public List<Demo> select1(@Param("name")String name,@Param("email")String email);
	//http://localhost:8080/select1?name=ck&email=12@163.com
	//多参需要@param注解
	/* #{} 与${}区别  #是转变成字符串 $是变量形式    
	 * ep:  select * from ${tableName} order by${id}
	 * 如果传入 table1,$  id则语句为select * from table1 order by id
	 * 如果#{}则变成select * from 'table1' order by 'id'这样就不对了 name='${name}'才能用
	 * 查询name或者id降序的时候用${}因为没有指定是什么
	 * */
	//动态修改sql语句
	//8080/select6什么都不穿就1=1所有都取得sq:select *from demo where 1=1
	//8080/select6?name=ck 传什么就以为么为条件sq: Preparing:select *from demo where 1=1 and name=?  parameters:ck(String)
	//第一种方式script  第二种@Provider
	@Select("<script>select * from demo where "
			+"1=1 "
			+"<if test='name!=null'>and name=#{name}</if>"
			+"<if test='email!=null'>and email=#{email}</if>"
			+"name=#{name} "
			+"and email=#{email} " 
			+"</script>")
	public List<Demo> select6(Demo demo);

}
/* 查询Demo类id=x的记录
 * @Select("select * from demo where id=#{id}")
 * public Demo select3(int id);
 * 
 * 查询Demo类并赞找指定字段id或者name降序排列
 * @Select("select * from demo order by ${orderField}")//原样替换
 * public Demo select4(String orderField);
 * 如果使用#的话解析为select * from demo order by 'id'
 * 
 * 查询Demo表的数据，并且按照指定字段id或者name圣墟或者降序排列
 * @Select("select * from demo order by ${orderField} ${ascOrDesc}")
 * public Demo select3(@Param("orderField")String orderField,@Param("ascOrDesc")String ascOrDesc);
 * 
 * 
 * */
/* @Result修饰返回的结果集，关联实体类属性和数据库字段--对应，如果实体类属性和数据库属性名保持一致就不需要此修饰
 * 
 * 
 * 
 * 
 */