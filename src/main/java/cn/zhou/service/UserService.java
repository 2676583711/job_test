package cn.zhou.service;


import cn.zhou.pojo.User;

public interface UserService {

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

