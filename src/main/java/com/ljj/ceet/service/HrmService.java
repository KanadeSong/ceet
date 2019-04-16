package com.ljj.ceet.service;

import com.ljj.ceet.entity.*;
import com.ljj.ceet.util.pojo.JqGridResult;

/**
 * @CLassName HrmService
 * @Description 人事管理服务层接口
 * @Author LeeJack
 * @Date 2019/4/13/013 16:38
 * @Version 1.0
 */
public interface HrmService {



    /**
     *
     * @Description: 根据id查询用户
     * @Param [id]
     * @return com.ljj.ceet.entity.UserInf
     * @author LeeJack
     * @Date 16:43 2019/4/13/013
     * @param userId
     */
    UserInf queryUserById(Integer userId);

    /**
     *
     * @Description: 查询用户列表
     * @Param [userInf, page, pageSize]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 18:50 2019/4/13/013
     */
    JqGridResult queryUserList(UserInf userInf,Integer page,Integer pageSize);

    /**
     *
     * @Description: 根据id删除用户
     * @Param [userId]
     * @return void
     * @author LeeJack
     * @Date 19:20 2019/4/13/013
     * @param userId
     */
    void deleteUserById(Integer userId);

    /**
     *
     * @Description: 保存用户
     * @Param [userInf]
     * @return boolean
     * @author LeeJack
     * @Date 19:22 2019/4/13/013
     */
    void saveUser(UserInf userInf);

    /**
     *
     * @Description: 修改用户
     * @Param [user]
     * @return void
     * @author LeeJack
     * @Date 19:23 2019/4/13/013
     * @param user
     */
    UserInf updateUserById(Integer user);

    /**
     *
     * @Description: 查询所有员工
     * @Param [employee, page, pageSize]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:25 2019/4/13/013
     */
    JqGridResult queryEmployeeList(EmployeeInf employee, Integer page, Integer pageSize);

    /**
     *
     * @Description: 根据id删除员工
     * @Param [id]
     * @return void
     * @author LeeJack
     * @Date 19:27 2019/4/13/013
     */
    void deleteEmployeeById(Integer id);

    /**
     *
     * @Description: 根据id查询员工
     * @Param [id]
     * @return com.ljj.ceet.entity.EmployeeInf
     * @author LeeJack
     * @Date 19:28 2019/4/13/013
     */
    EmployeeInf queryEmployeeById(Integer id);

    /**
     *
     * @Description: 添加员工
     * @Param [employee]
     * @return boolean
     * @author LeeJack
     * @Date 19:29 2019/4/13/013
     */
    void saveEmployee(EmployeeInf employee);

    /**
     *
     * @Description: 修改员工
     * @Param [employee]
     * @return void
     * @author LeeJack
     * @Date 19:30 2019/4/13/013
     */
    void updateEmployee(EmployeeInf employee);

    /**
     *
     * @Description: 获得所有部门，分页查询
     * @Param [dept, page, pageSize]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:31 2019/4/13/013
     */
    JqGridResult queryDeptList(DeptInf dept, Integer page,Integer pageSize);

    /**
     *
     * @Description: 根据id查部门
     * @Param [id]
     * @return com.ljj.ceet.entity.DeptInf
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     */
    DeptInf queryDeptById(Integer id);

    /**
     *
     * @Description: 根据id删除部门
     * @Param [id]
     * @return void
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     * @param id
     */
    public void deleteDeptById(Integer id);

    /**
     *
     * @Description: 添加部门
     * @Param [dept]
     * @return void
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    void saveDept(DeptInf dept);

    /**
     *
     * @Description: 修改部门
     * @Param [dept]
     * @return void
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    void updateDept(DeptInf dept);

    /**
     *
     * @Description: 获得所有职位并分页
     * @Param []
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:35 2019/4/13/013
     */
    JqGridResult queryJobList(JobInf job,Integer page,Integer pageSize);

    /**
     *
     * @Description: 根据id删除职位
     * @Param [id]
     * @return void
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
     void deleteJobById(Integer id);

    /**
     *
     * @Description: 添加职位
     * @Param [job]
     * @return boolean
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
    void saveJob(JobInf job);

    /**
     *
     * @Description: 根据id查询职位
     * @Param [id]
     * @return com.ljj.ceet.entity.JobInf
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    JobInf queryJobById(Integer id);

    /**
     *
     * @Description: 修改职位
     * @Param [job]
     * @return void
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    void updateJob(JobInf job);

    /**
     *
     * @Description: 获得所有公告
     * @Param [notice, page, pageSize]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    JqGridResult queryNoticeList(NoticeInf notice, Integer page,Integer pageSize);

    /**
     *
     * @Description: 根据id查询公告
     * @Param [id]
     * @return com.ljj.ceet.entity.NoticeInf
     * @author LeeJack
     * @Date 19:39 2019/4/13/013
     */
    NoticeInf queryNoticeById(Integer id);

    /**
     *
     * @Description: 根据id删除公告
     * @Param [id]
     * @return void
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    void deleteNoticeById(Integer id);

    /**
     *
     * @Description: 添加公告
     * @Param [notice]
     * @return boolean
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    void saveNotice(NoticeInf notice);

    /**
     *
     * @Description: 修改公告
     * @Param [notice]
     * @return void
     * @author LeeJack
     * @Date 19:41 2019/4/13/013
     */
    void updateNotice(NoticeInf notice);

    /**
     *
     * @Description: 获得所有文档
     * @Param [document, page, pageSize]
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    JqGridResult queryDocumentList(DocumentInf document,Integer page,Integer pageSize);

    /**
     *
     * @Description: 添加文档
     * @Param [document]
     * @return void
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    void saveDocument(DocumentInf document);

    /**
     *
     * @Description: 根据id查询文档
     * @Param [id]
     * @return com.ljj.ceet.entity.DocumentInf
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    DocumentInf queryDocumentById(Integer id);


    /**
     *
     * @Description: 根据id删除文档
     * @Param [id]
     * @return void
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    void deleteDocumentById(Integer id);

    /**
     *
     * @Description: 修改文档
     * @Param [document]
     * @return void
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    void updateDocument(DocumentInf document);
}
