package com.ljj.ceet.controller;

import com.ljj.ceet.entity.EmployeeInf;
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
 * @CLassName EmployeeController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @Autowired
    private HrmService hrmService;


    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 条件查询用户列表
     * @Param [employeeInf , page]
     * @author LeeJack
     * @Date 19:49 2019/4/14/014
     */
    @RequestMapping("/selectEmployee")
    public String selectEmployee(Integer pageIndex ,
                                 Integer job_id , Integer dept_id ,
                                 @ModelAttribute EmployeeInf employee ,
                                 Model model) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        JqGridResult result = hrmService.queryEmployeeList(employee , pageIndex , pageSize);

        List<EmployeeInf> employees = (List<EmployeeInf>) result.getRows();

		/*model.addAttribute("employeename",employee.getEmployeename());
		model.addAttribute("status",employee.getStatus());*/
        model.addAttribute("employees" , employees);
        model.addAttribute("result" , result);
        return "employee/employee";
    }


    /**
     * @param ids
     * @return com.ljj.ceet.util.utils.LeeJSONResult
     * @Description: 删除用户
     * @Param [employeeId]
     * @author LeeJack
     * @Date 20:19 2019/4/14/014
     */
    @RequestMapping("/removeEmployee")
    public ModelAndView removeEmployee(String ids , ModelAndView mv) {
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            hrmService.deleteEmployeeById(Integer.valueOf(id));
        }
        mv.setViewName("redirect:/employee/selectEmployee");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description:
     * @Param [flag , employee, mv]employee flag 标记， 1表示跳转到添加页面，2表示执行添加操作employee要添加用户的对象
     * @author LeeJack
     * @Date 21:53 2019/4/16/016
     */
    @RequestMapping(value = "/addEmployee")
    public ModelAndView addEmployee(
            String flag ,
            EmployeeInf employeeInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("employee/showAddEmployee");
        } else {

            // 执行添加操作
            hrmService.saveEmployee(employeeInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description: 处理修改用户请求
     * @Param [flag , employee, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作employee  要修改用户的对象
     * @author LeeJack
     * @Date 21:47 2019/4/16/016
     */
    @RequestMapping(value = "/updateEmployee")
    public ModelAndView updateDpet(
            String flag ,
            @ModelAttribute EmployeeInf employeeInf ,
            ModelAndView mv , BindingResult bindingResult) {
        if (flag.equals("1")) {
            // 根据id查询用户
            EmployeeInf target = hrmService.queryEmployeeById(employeeInf.getId());
            // 设置Model数据
            mv.addObject("employee" , target);
            // 返回修改员工页面
            mv.setViewName("employee/showUpdateEmployee");
        } else {
            // 执行修改操作
            hrmService.updateEmployee(employeeInf);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;
    }


}
