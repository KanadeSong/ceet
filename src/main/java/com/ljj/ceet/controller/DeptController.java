package com.ljj.ceet.controller;

import com.ljj.ceet.entity.DeptInf;
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
 * @CLassName UserController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

	@Autowired
	private HrmService hrmService;


	/**
	 * @return com.ljj.ceet.util.pojo.JqGridResult
	 * @Description: 条件查询用户列表
	 * @Param [deptInf , page]
	 * @author LeeJack
	 * @Date 19:49 2019/4/14/014
	 */
	@RequestMapping("/selectDept")
	public String selectDept( Integer pageIndex,
							 @ModelAttribute DeptInf dept,Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		JqGridResult result = hrmService.queryDeptList(dept , pageIndex , pageSize);

		List<DeptInf> depts = (List<DeptInf>) result.getRows();

		model.addAttribute("name",dept.getName());

		model.addAttribute("depts" , depts);
		model.addAttribute("result" , result);
		return "dept/dept";
	}


	/**
	 * @param ids
	 * @return com.ljj.ceet.util.utils.LeeJSONResult
	 * @Description: 删除用户
	 * @Param [deptId]
	 * @author LeeJack
	 * @Date 20:19 2019/4/14/014
	 */
	@RequestMapping("/removeDept")
	public ModelAndView removeDept(String ids , ModelAndView mv) {
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			hrmService.deleteDeptById(Integer.valueOf(id));
		}
		mv.setViewName("redirect:/dept/selectDept");
		return mv;
	}

	/**
	 * @return org.springframework.web.servlet.ModelAndView
	 * @Description:
	 * @Param [flag , dept, mv]dept flag 标记， 1表示跳转到添加页面，2表示执行添加操作dept要添加用户的对象
	 * @author LeeJack
	 * @Date 21:53 2019/4/16/016
	 */
	@RequestMapping(value = "/addDept")
	public ModelAndView addDept(
			String flag ,
			DeptInf deptInf ,
			ModelAndView mv , BindingResult bindingResult) {
		if (flag.equals("1")) {
			// 设置跳转到添加页面
			mv.setViewName("dept/showAddDept");
		} else {

			// 执行添加操作
			hrmService.saveDept(deptInf);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}

	/**
	 * @return org.springframework.web.servlet.ModelAndView
	 * @Description: 处理修改用户请求
	 * @Param [flag , dept, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作dept  要修改用户的对象
	 * @author LeeJack
	 * @Date 21:47 2019/4/16/016
	 */
	@RequestMapping(value = "/updateDept")
	public ModelAndView updateDpet(
			String flag ,
			@ModelAttribute DeptInf deptInf ,
			ModelAndView mv, BindingResult bindingResult) {
		if (flag.equals("1")) {
			// 根据id查询用户
			DeptInf target = hrmService.queryDeptById(deptInf.getId());
			// 设置Model数据
			mv.addObject("dept" , target);
			// 返回修改员工页面
			mv.setViewName("dept/showUpdateDept");
		} else {
			// 执行修改操作
			hrmService.updateDept(deptInf);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}




}
