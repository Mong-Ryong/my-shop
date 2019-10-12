package com.ml.my.shop.web.admin.web.controller;

import com.ml.my.shop.commons.constant.ConstantUtils;
import com.ml.my.shop.domain.TbUser;
import com.ml.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    /*自动注入*/
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, Model model) {

        TbUser tbUser = tbUserService.login(email, password);


        //登录失败
        if (tbUser==null){
            model.addAttribute("message","用户名或者密码错误请重新输入");
            return login();
        }

        //登录成功
        else {
            //将用户登录信息放入session
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            return "redirect:/main";
        }
        /*User user = userService.login(email, password);
        //登录失败
        if (user == null) {
            return login();
        }

        //登录失败
        else {
            //将登陆信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }*/

    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}

