package testmybatis.test;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author yh
 * @Date 2021/1/10 14:30
 */
public interface UserMapper2 {
  @Select("select * from blacklist")
  List<BlackList> getAllUsers();

  @Select("select phone from blacklist")
  List<String> getPhones();


  @Insert({"insert into blacklist(phone) values(#{phone})"})
  Integer addUser(String phone);


  @Delete("delete from blacklist where phone in #{id}")
  Integer deleteUserById(Integer id);
}
