

package cn.zhou.service;


import cn.zhou.dao.UserDao;
import cn.zhou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;

@Service
public class UserServiceImpl implements UserService {

    public SqlSession getSqlSession() {
        String fileName = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Autowired
    UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }



    @Override
    public User queryByUsername(String username){
        return userDao.queryByUsername(username);
    }

}
