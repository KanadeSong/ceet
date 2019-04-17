package com.ljj.ceet.controller;

import com.ljj.ceet.entity.NoticeInf;
import com.ljj.ceet.service.HrmService;
import com.ljj.ceet.util.pojo.JqGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @CLassName NoticeController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    @Autowired
    private HrmService hrmService;


    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 条件查询用户列表
     * @Param [noticeInf , page]
     * @author LeeJack
     * @Date 19:49 2019/4/14/014
     */
    @RequestMapping("/selectNotice")
    public String selectNotice(Model model , Integer pageIndex ,
                            @ModelAttribute NoticeInf notice) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        JqGridResult result = hrmService.queryNoticeList(notice , pageIndex , pageSize);

        List<NoticeInf> notices = (List<NoticeInf>) result.getRows();

		model.addAttribute("title",notice.getTitle());
		model.addAttribute("content",notice.getContent());
        model.addAttribute("notices" , notices);
        model.addAttribute("result" , result);
        return "notice/notice";
    }


    /**
     * @param ids
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @Description: 删除用户
     * @Param [noticeId]
     * @author LeeJack
     * @Date 20:19 2019/4/14/014
     */
    @RequestMapping("/removeNotice")
    public ModelAndView removeNotice(String ids , ModelAndView mv) {
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            hrmService.deleteNoticeById(Integer.valueOf(id));
        }
        mv.setViewName("redirect:/notice/selectNotice");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description:
     * @Param [flag , notice, mv]notice flag 标记， 1表示跳转到添加页面，2表示执行添加操作notice要添加用户的对象
     * @author LeeJack
     * @Date 21:53 2019/4/16/016
     */
    @RequestMapping(value = "/addNotice")
    public ModelAndView addNotice(
            String flag ,
            NoticeInf noticeInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("notice/showAddNotice");
        } else {

            // 执行添加操作
            hrmService.saveNotice(noticeInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/notice/selectNotice");
        }
        // 返回
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description: 处理修改用户请求
     * @Param [flag , notice, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作notice  要修改用户的对象
     * @author LeeJack
     * @Date 21:47 2019/4/16/016
     */
    @RequestMapping(value = "/updateNotice")
    public ModelAndView updateDpet(
            String flag ,
            @ModelAttribute NoticeInf noticeInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 根据id查询用户
            NoticeInf target = hrmService.queryNoticeById(noticeInf.getId());
            // 设置Model数据
            mv.addObject("notice" , target);
            // 返回修改员工页面
            mv.setViewName("notice/showUpdateNotice");
        } else {
            // 执行修改操作
            hrmService.updateNotice(noticeInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/notice/selectNotice");
        }
        // 返回
        return mv;
    }


}
