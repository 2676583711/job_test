package cn.zhou.controller;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;
import cn.zhou.utils.CheckToken;
import cn.zhou.utils.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;


    //用户登陆
//    @RequestMapping(value = "/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        try {
//            userService.add(user);
            modelAndView.setViewName("index.jsp");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //失败，返回登陆页面
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(User user) {
        System.out.println("----------------------------register------------");

        System.out.println("----User----" + user);

        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.add(user);
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("message", "注册成功去登录");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //注册失败，返回注册页面
        modelAndView.setViewName("register.jsp");
        modelAndView.addObject("message", "注册失败");
        return modelAndView;
    }

    ///*************************************************/////

    @CheckToken
    @RequestMapping(value = "/add")
    public ModelAndView add(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        try {
            userService.add(user);
            modelAndView.addObject("message", "添加成功");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        modelAndView.addObject("message", "删除失败,网络异常");
        return modelAndView;
    }

    @CheckToken
    @RequestMapping(value = "/delete")
    public ModelAndView delete(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        try {
            userService.delete(id);
            modelAndView.addObject("message", "删除成功");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        modelAndView.addObject("message", "删除失败,网络异常");
        return modelAndView;
    }

    @CheckToken
    @RequestMapping(value = "/update")
    public ModelAndView update(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        try {
            userService.update(user);
            modelAndView.addObject("message", "修改成功");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        modelAndView.addObject("message", "修改失败,网络异常");
        return modelAndView;
    }

    //查询
    @CheckToken
    @RequestMapping(value = "/query")
    public ModelAndView query(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");

        if (id == null || id.equals("")) {
            modelAndView.addObject("message", "id不能为空");
            return modelAndView;
        }
        try {
            modelAndView.addObject("message", "查询成功");
            modelAndView.addObject("user", userService.queryById(id));
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        modelAndView.addObject("message", "查询失败,网络异常");
        return modelAndView;
    }
}


/*
/home/zhou/workspace/program/Java/Tomcat/apache-tomcat-9.0.14/webapps


create table test_user(id int auto_increment primary key,
username varchar(100) unique key,
password varchar(100),
email varchar(200),
sex char(10));

 */