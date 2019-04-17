package com.ljj.ceet.controller;

import com.ljj.ceet.entity.JobInf;
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
 * @CLassName JobController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/job")
public class JobController extends BaseController {

    @Autowired
    private HrmService hrmService;


    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 条件查询用户列表
     * @Param [jobInf , page]
     * @author LeeJack
     * @Date 19:49 2019/4/14/014
     */
    @RequestMapping("/selectJob")
    public String selectJob(Model model , Integer pageIndex ,
                            @ModelAttribute JobInf job) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        JqGridResult result = hrmService.queryJobList(job , pageIndex , pageSize);

        List<JobInf> jobs = (List<JobInf>) result.getRows();

		/*model.addAttribute("jobname",job.getJobname());
		model.addAttribute("status",job.getStatus());*/
        model.addAttribute("jobs" , jobs);
        model.addAttribute("result" , result);
        return "job/job";
    }


    /**
     * @param ids
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @Description: 删除用户
     * @Param [jobId]
     * @author LeeJack
     * @Date 20:19 2019/4/14/014
     */
    @RequestMapping("/removeJob")
    public ModelAndView removeJob(String ids , ModelAndView mv) {
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            hrmService.deleteJobById(Integer.valueOf(id));
        }
        mv.setViewName("redirect:/job/selectJob");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description:
     * @Param [flag , job, mv]job flag 标记， 1表示跳转到添加页面，2表示执行添加操作job要添加用户的对象
     * @author LeeJack
     * @Date 21:53 2019/4/16/016
     */
    @RequestMapping(value = "/addJob")
    public ModelAndView addJob(
            String flag ,
            JobInf jobInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("job/showAddJob");
        } else {

            // 执行添加操作
            hrmService.saveJob(jobInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/job/selectJob");
        }
        // 返回
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description: 处理修改用户请求
     * @Param [flag , job, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作job  要修改用户的对象
     * @author LeeJack
     * @Date 21:47 2019/4/16/016
     */
    @RequestMapping(value = "/updateJob")
    public ModelAndView updateDpet(
            String flag ,
            @ModelAttribute JobInf jobInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 根据id查询用户
            JobInf target = hrmService.queryJobById(jobInf.getId());
            // 设置Model数据
            mv.addObject("job" , target);
            // 返回修改员工页面
            mv.setViewName("job/showUpdateJob");
        } else {
            // 执行修改操作
            hrmService.updateJob(jobInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/job/selectJob");
        }
        // 返回
        return mv;
    }


}
