package cn.zhou.controller;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;


    //用户登陆
    @RequestMapping(value = "/login")
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
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.add(user);
            modelAndView.setViewName("login.jsp");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //失败，返回登陆页面
        modelAndView.setViewName("register.jsp");
        return modelAndView;
    }

    ///*************************************************/////
    @RequestMapping(value = "/add")
    public String  add(User user) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.add(user);
            return "添加成功";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "添加失败";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.delete(id);
            return "删除成功";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "删除失败";
    }

    @RequestMapping(value = "/update")
    public String update(User user) {
        try {
            userService.add(user);
            return "修改成功";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "修改失败";
    }

    //查询
    @RequestMapping(value = "/queryById")
    public Object query(Integer id) {
        try {
            return "查询成功\t"+ userService.queryById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "查询失败,异常";
    }
}
