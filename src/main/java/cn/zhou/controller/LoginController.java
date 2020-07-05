package cn.zhou.controller;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;
import cn.zhou.utils.JwtUtils;
import cn.zhou.utils.LoginToken;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserService userService;

    //登录
//    @PostMapping("/login")
    //@RequestBody @Valid User user,
    @LoginToken
    @RequestMapping("/login")
    public Object login(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (username == null || username.equals("") || password == null || password.equals("")) {
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("message", "用户名或密码不能为空");
            return modelAndView;
        }

        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.queryByUsername(user.getUsername());

        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
//            modelAndView.setViewName("login.jsp");
//            modelAndView.addObject("message", jsonObject);
//            return modelAndView;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
//                modelAndView.setViewName("login.jsp");
//                modelAndView.addObject("message", jsonObject);
//                return modelAndView;
            } else {
                System.out.println("-----////登录//////userForBase/////////////////---login-----userForBase---" + userForBase);

                ///登录成功
//                String token = JwtUtils.createJWT(6000000, userForBase);
//                jsonObject.put("token", token);
//                jsonObject.put("user", userForBase);
//                System.out.println("-----/////////////token//////////////---login-----user---"+token);

//                return jsonObject;
                return "<meta http-equiv='refresh' content=0;URL='/index.jsp'>";

//                modelAndView.setViewName("login.jsp");
//                modelAndView.addObject("message", jsonObject);
//                return modelAndView;
            }
        }
    }

    //登录成功，进入主页面
    public ModelAndView getMessage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        modelAndView.addObject("message", "登录成功");
        return modelAndView;
    }

}
