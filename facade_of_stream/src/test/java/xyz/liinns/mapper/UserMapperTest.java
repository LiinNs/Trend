package xyz.liinns.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.liinns.entity.User;

/**
 * Description:
 * Created by LiinNs on 2017-4-13 0013.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @Rollback
    public void findByName() throws Exception {
        User u = new User();
        u.setAge(20);
        u.setName("AA");
        userMapper.insert(u);
        userMapper.selectOne(u);
        Assert.assertEquals(20, u.getAge().intValue());
    }

}