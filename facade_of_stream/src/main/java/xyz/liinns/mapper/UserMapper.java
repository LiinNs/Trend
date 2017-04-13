package xyz.liinns.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import xyz.liinns.entity.User;

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}