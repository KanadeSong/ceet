package com.ljj.ceet.controller;

import com.ljj.ceet.entity.UserInf;
import com.ljj.ceet.service.HrmService;
import com.ljj.ceet.util.pojo.JqGridResult;
import com.ljj.ceet.util.utils.LeeJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @CLassName UserController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private HrmService hrmService;


    /**
     *
     * @Description: 创建或更新用户
     * @Param [userInf]
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @author LeeJack
     * @Date 20:16 2019/4/14/014
     */
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public LeeJSONResult saveOrUpdate(UserInf userInf){
        String userId = userInf.getId();
        if (StringUtils.isEmpty(userId)){
            hrmService.saveUser(userInf);
        }else {
            hrmService.updateUserById(userId);
        }
        return LeeJSONResult.ok();
    }

    /**
     * @return java.lang.String
     * @Description: 显示用户信息列表页面
     * @Param [request]
     * @author LeeJack
     * @Date 19:44 2019/4/14/014
     */
    @RequestMapping(value = "/selectUser")
    public String selectUser(HttpServletRequest request) {
        return "user/userInfoList";
    }

    /**
     *
     * @Description: 条件查询用户列表
     * @Param [userInf, page]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:49 2019/4/14/014
     */
    @RequestMapping("/getUserInfoList")
    @ResponseBody
    public JqGridResult getUserInfoList(UserInf userInf , Integer page) {
        if (page == null) {
            page = 1;
        }
        JqGridResult result = hrmService.queryUserList(userInf , page , pageSize);
        return result;
    }

    /**
     *
     * @Description: 查询用户详情
     * @Param [id, request]
     * @return org.springframework.web.servlet.ModelAndView
     * @author LeeJack
     * @Date 19:53 2019/4/14/014
     */
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(Integer id, HttpServletRequest request){

        UserInf userInf = hrmService.queryUserById(id);

        ModelAndView mav = new ModelAndView("user/userDetail");
        mav.addObject("userInfo",userInf);
        //mav.addObject("num",12500);

        return mav;
    }

    /**
     *
     * @Description: 跳转搭配修改用户页面
     * @Param [id, request]
     * @return org.springframework.web.servlet.ModelAndView
     * @author LeeJack
     * @Date 20:18 2019/4/14/014
     */
    @RequestMapping("/modifyUser")
    public ModelAndView showModifyUser(String id,HttpServletRequest request){

        UserInf userInf = hrmService.updateUserById(id);

        ModelAndView mav = new ModelAndView("");

        return mav;
    }

    /**
     *
     * @Description: 删除用户
     * @Param [userId]
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @author LeeJack
     * @Date 20:19 2019/4/14/014
     * @param userId
     */
    @RequestMapping("/delete")
    @ResponseBody
    public LeeJSONResult update(Integer userId){
        hrmService.deleteDeptById(userId);
        return LeeJSONResult.ok();
    }






























}
