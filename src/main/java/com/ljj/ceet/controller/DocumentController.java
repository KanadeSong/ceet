package com.ljj.ceet.controller;

import com.ljj.ceet.entity.DocumentInf;
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
 * @CLassName DocumentController
 * @Description 处理用户请求控制器
 * @Author LeeJack
 * @Date 2019/4/14/014 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/document")
public class DocumentController extends BaseController {

	@Autowired
	private HrmService hrmService;


	/**
	 * @return com.ljj.ceet.util.pojo.JqGridResult
	 * @Description: 条件查询用户列表
	 * @Param [documentInf , page]
	 * @author LeeJack
	 * @Date 19:49 2019/4/14/014
	 */
	@RequestMapping("/selectDocument")
	public String selectDocument(Model model , Integer pageIndex ,
							@ModelAttribute DocumentInf document) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		JqGridResult result = hrmService.queryDocumentList(document , pageIndex , pageSize);

		List<DocumentInf> documents = (List<DocumentInf>) result.getRows();

		model.addAttribute("title",document.getTitle());
		model.addAttribute("documents" , documents);
		model.addAttribute("result" , result);
		return "document/document";
	}


	/**
	 * @param ids
	 * @return com.ljj.ceet.util.utils.LeeJSONResult
	 * @Description: 删除用户
	 * @Param [documentId]
	 * @author LeeJack
	 * @Date 20:19 2019/4/14/014
	 */
	@RequestMapping("/removeDocument")
	public ModelAndView removeDocument(String ids , ModelAndView mv) {
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			hrmService.deleteDocumentById(Integer.valueOf(id));
		}
		mv.setViewName("redirect:/document/selectDocument");
		return mv;
	}

	/**
	 * @return org.springframework.web.servlet.ModelAndView
	 * @Description:
	 * @Param [flag , document, mv]document flag 标记， 1表示跳转到添加页面，2表示执行添加操作document要添加用户的对象
	 * @author LeeJack
	 * @Date 21:53 2019/4/16/016
	 */
	@RequestMapping(value = "/addDocument")
	public ModelAndView addDocument(
			String flag ,
			DocumentInf documentInf ,
			ModelAndView mv , BindingResult bindingResult) {
		if (flag.equals("1")) {
			// 设置跳转到添加页面
			mv.setViewName("document/showAddDocument");
		} else {

			// 执行添加操作
			hrmService.saveDocument(documentInf);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/document/selectDocument");
		}
		// 返回
		return mv;
	}

	/**
	 * @return org.springframework.web.servlet.ModelAndView
	 * @Description: 处理修改用户请求
	 * @Param [flag , document, mv]flag 标记，1表示跳转到修改页面，2表示执行修改操作document  要修改用户的对象
	 * @author LeeJack
	 * @Date 21:47 2019/4/16/016
	 */
	@RequestMapping(value = "/updateDocument")
	public ModelAndView updateDpet(
			String flag ,
			@ModelAttribute DocumentInf documentInf ,
			ModelAndView mv , BindingResult bindingResult) {
		if (flag.equals("1")) {
			// 根据id查询用户
			DocumentInf target = hrmService.queryDocumentById(documentInf.getId());
			// 设置Model数据
			mv.addObject("document" , target);
			// 返回修改员工页面
			mv.setViewName("document/showUpdateDocument");
		} else {
			// 执行修改操作
			hrmService.updateDocument(documentInf);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/document/selectDocument");
		}
		// 返回
		return mv;
	}


}
