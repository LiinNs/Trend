package xyz.liinns.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import xyz.liinns.entity.User;

@CacheConfig(cacheNames = "users")
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

    @Cacheable
    User findByName(@Param("name") String name);
}