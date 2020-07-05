package cn.zhou.dao;


import cn.zhou.pojo.User;
import org.apache.ibatis.annotations.Mapper;

//用户 dao
@Mapper
public interface UserDao {

    //增
    public void add(User user);

    //删
    public void delete(Integer id);

    //改
    public void update(User user);

    //查
    public User queryById(Integer id);

    public User queryByUsername(String username);

}
