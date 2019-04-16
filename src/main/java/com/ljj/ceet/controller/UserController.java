package com.ljj.ceet.controller;

import com.ljj.ceet.entity.UserInf;
import com.ljj.ceet.service.HrmService;
import com.ljj.ceet.util.pojo.JqGridResult;
import com.ljj.ceet.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @Autowired
    private HrmService hrmService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description: 处理修改用户请求
     * @Param [flag , user, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作user  要修改用户的对象
     * @author LeeJack
     * @Date 21:47 2019/4/16/016
     */
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(
            String flag ,
            @ModelAttribute UserInf user ,
            ModelAndView mv) {
        if (flag.equals("1")) {
            // 根据id查询用户
            UserInf target = hrmService.queryUserById(user.getId());
            // 设置Model数据
            mv.addObject("user" , target);
            // 返回修改员工页面
            mv.setViewName("user/showUpdateUser");
        } else {
            // 执行修改操作
            hrmService.updateUserById(user.getId());
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 条件查询用户列表
     * @Param [userInf , page]
     * @author LeeJack
     * @Date 19:49 2019/4/14/014
     */
    @RequestMapping("/selectUser")
    public String getUserInfoList(Integer pageIndex ,
                                  @ModelAttribute UserInf userInf ,
                                  Model model) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        JqGridResult result = hrmService.queryUserList(userInf , pageIndex , pageSize);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        List<UserInf> users = (List<UserInf>) result.getRows();

        model.addAttribute("users" , users);
        model.addAttribute("pageModel" , pageModel);
        return "user/user";
    }

    /**
     * @param userId
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @Description: 删除用户
     * @Param [userId]
     * @author LeeJack
     * @Date 20:19 2019/4/14/014
     */
    @RequestMapping("/removeUser")
    public ModelAndView update(Integer userId , ModelAndView mv) {
        hrmService.deleteDeptById(userId);
        mv.setViewName("redirect:/user/selectUser");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description:
     * @Param [flag , user, mv]user flag 标记， 1表示跳转到添加页面，2表示执行添加操作user要添加用户的对象
     * @author LeeJack
     * @Date 21:53 2019/4/16/016
     */
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(
            String flag ,
            @ModelAttribute UserInf user ,
            ModelAndView mv) {
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("user/showAddUser");
        } else {
            // 执行添加操作
            System.out.println(user.getStatus());
            hrmService.saveUser(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }

}
