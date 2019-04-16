package com.ljj.ceet.controller;

import com.ljj.ceet.entity.UserInf;
import com.ljj.ceet.service.HrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @CLassName CenterController
 * @Description 登录页面管理
 * @Author LeeJack
 * @Date 2019/4/15/015 18:11
 * @Version 1.0
 */
@Controller
public class CenterController {
    final static Logger log = LoggerFactory.getLogger(CenterController.class);

    @Autowired
    private HrmService hrmService;

    //@Autowired
    //private ItzixiCaptcha itzixiCaptcha;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("loginname") String loginname ,
                              @RequestParam("password") String password ,
                              HttpSession session ,
                              ModelAndView mv) {
        // 调用业务逻辑组件判断用户是否可以登录
        UserInf user = new UserInf();
        user.setLoginname(loginname);
        user.setPassword(password);
        if (loginname.equals("admin") && password.equals("123456")) {
            // 将用户保存到HttpSession当中
            //session.setAttribute(HrmConstants.USER_SESSION, user);
            // 客户端跳转到main页面
            mv.setViewName("main");

            // mv.setViewName("test.html");
        } else {
            // 设置登录失败提示信息
            mv.addObject("message" , "登录名或密码错误!请重新输入");
            // 服务器内部跳转到登录页面
            mv.setViewName("loginForm");
        }
        return mv;
    }

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String test(){
        return "a";
    }

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public String testb(){
        return "b";
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test1(){
        return "main";
    }



    /*@RequestMapping("/center")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("center");

        return modelAndView;
    }

    //	@GetMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doGetlogin() {
        // 判断当前的subjec用户是否存在，并且是登录状态，如果是，那就跳转到首页，如果不是，那就跳转到登录页面
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    //	@PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LeeJSONResult doPostlogin(String username, String password, String captcha, @RequestParam(value="isRememberMe", defaultValue="0") Integer isRememberMe, HttpServletRequest request, HttpServletResponse response) {

        if (StringUtils.isBlank(username)) {
            return LeeJSONResult.errorMsg("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return LeeJSONResult.errorMsg("密码不能为空");
        }
        if (!itzixiCaptcha.validate(request, response, captcha)) {
            return LeeJSONResult.errorMsg("验证码错误, 请重新输入...");
        }
        Subject user = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if (isRememberMe == 1) {
            token.setRememberMe(true);
        }

        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            return LeeJSONResult.errorMsg("账号不存在");
        } catch (DisabledAccountException e) {
            return LeeJSONResult.errorMsg("账号未启用");
        } catch (IncorrectCredentialsException e) {
            return LeeJSONResult.errorMsg("密码错误");
        } catch (RuntimeException e) {
            return LeeJSONResult.errorMsg("未知错误,请联系管理员");
        }

        return LeeJSONResult.ok();
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 登录的时候生成验证码
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年11月7日 下午8:35:00
     * @version V1.0
     *//*
    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        itzixiCaptcha.generate(request, response);
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 用户退出
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年10月19日 下午10:06:21
     * @version V1.0
     *//*
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        // 主体用户退出
        subject.logout();

        return "redirect:/login.action";
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 注册用户
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年10月20日 下午8:36:38
     * @version V1.0
     *//*
    @PostMapping("/regist")
    @ResponseBody
    public LeeJSONResult regist(String username, String password, HttpServletRequest request, HttpServletResponse response) {

        SysUser user = new SysUser();
        user.setUsername(username);

        // 生成4位随机组合字符作为权限的盐
        String authSalt = NumberUtil.getStringRandom(4);

        user.setPassword(ShiroPasswordUtil.getShiroPassword(password, authSalt, 2));
        user.setAuthSalt(authSalt);
        user.setNickname(username);

        // 验证一致，先注册用户
        boolean registFlag = userService.saveUser(user);
        if (!registFlag) {
            return LeeJSONResult.errorMsg("注册失败！请返回首页重新注册.");
        }

        // 为了让用户在注册成功，直接访问首页，所以在注册超成功后，需要手动执行登陆
        Subject userShiro = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        userShiro.login(token);

        return LeeJSONResult.ok();
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 测试cookie - 存入cookie的值
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年10月31日 下午8:38:47
     * @version V1.0
     *//*
    @RequestMapping(value = "/setCookie")
    @ResponseBody
    public LeeJSONResult setCookie(HttpServletRequest request, HttpServletResponse response) {
        // 1. 构建购物车对象
        // 2. 封装这个对象为json字符串（json对象）
        // 3. 对这个json对象进行base64加密
        // 4. 把这个加密后的base64字符串，存入cookie中
        CookieUtils.setCookie(request, response, "leecxBuyShop", "cart-bean-json-value", 7*24*60*60);

        return LeeJSONResult.ok("设置cookie成功");
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 测试cookie - 获取cookie中的值
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年10月31日 下午8:39:03
     * @version V1.0
     *//*
    @RequestMapping(value = "/getCookie")
    @ResponseBody
    public LeeJSONResult getCookie(HttpServletRequest request, HttpServletResponse response) {

        String cookieValue = CookieUtils.getCookieValue(request, "leecxBuyShop");

        return LeeJSONResult.ok("获取cookie成功，值为：" + cookieValue);
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 测试redisTemplate - 设置redis的值
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年11月2日 下午9:13:56
     * @version V1.0
     *//*
    @RequestMapping(value = "/setRedis")
    @ResponseBody
    public LeeJSONResult setRedis(HttpServletRequest request, HttpServletResponse response) {

        jedis.set("redisTemplateTest", "hello redis template~~~", 5000);

        return LeeJSONResult.ok("设置redis成功");
    }

    *//**
     *
     * @Title: CenterController.java
     * @Package com.itzixi.web.controller
     * @Description: 测试redisTemplate - 获取redis的值
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年10月31日 下午8:39:03
     * @version V1.0
     *//*
    @RequestMapping(value = "/getRedisValue")
    @ResponseBody
    public LeeJSONResult getRedisValue(HttpServletRequest request, HttpServletResponse response) {

        String redisValue = jedis.get("redisTemplateTest");
        long ttl = jedis.ttl("redisTemplateTest");

        return LeeJSONResult.ok("获取redis成功，值为：" + redisValue + ", 剩余时间ttl为：" + ttl);
    }*/
}
