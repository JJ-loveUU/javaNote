package testmybatis.test;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yh
 * @Date 2021/1/10 15:37
 */
public interface UserMapper {

  Integer deleteUserById(@Param("blacklistIds") List<String> blacklistIds);
}