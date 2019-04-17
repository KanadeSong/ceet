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
     * @param userId
     * @return com.ljj.ceet.entity.UserInf
     * @Description: 根据id查询用户
     * @Param [id]
     * @author LeeJack
     * @Date 16:43 2019/4/13/013
     */
    UserInf queryUserById(Integer userId);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 查询用户列表
     * @Param [userInf , page, pageSize]
     * @author LeeJack
     * @Date 18:50 2019/4/13/013
     */
    JqGridResult queryUserList(UserInf userInf , Integer page , Integer pageSize);

    /**
     * @param userId
     * @return void
     * @Description: 根据id删除用户
     * @Param [userId]
     * @author LeeJack
     * @Date 19:20 2019/4/13/013
     */

    void deleteUserById(Integer userId);

    /**
     * @return void
     * @Description: 根据复数id删除用户
     * @Param [ids]
     * @author LeeJack
     * @Date 11:34 2019/4/17/017
     */
    public void deleteUserByIds(String ids);

    /**
     * @return boolean
     * @Description: 保存用户
     * @Param [userInf]
     * @author LeeJack
     * @Date 19:22 2019/4/13/013
     */
    void saveUser(UserInf userInf);

    /**
     * @param user
     * @return void
     * @Description: 修改用户
     * @Param [user]
     * @author LeeJack
     * @Date 19:23 2019/4/13/013
     */
    UserInf updateUserById(UserInf user);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 查询所有员工
     * @Param [employee , page, pageSize]
     * @author LeeJack
     * @Date 19:25 2019/4/13/013
     */
    JqGridResult queryEmployeeList(EmployeeInf employee , Integer page , Integer pageSize);

    /**
     * @return void
     * @Description: 根据id删除员工
     * @Param [id]
     * @author LeeJack
     * @Date 19:27 2019/4/13/013
     */
    void deleteEmployeeById(Integer id);

    /**
     * @return com.ljj.ceet.entity.EmployeeInf
     * @Description: 根据id查询员工
     * @Param [id]
     * @author LeeJack
     * @Date 19:28 2019/4/13/013
     */
    EmployeeInf queryEmployeeById(Integer id);

    /**
     * @return boolean
     * @Description: 添加员工
     * @Param [employee]
     * @author LeeJack
     * @Date 19:29 2019/4/13/013
     */
    void saveEmployee(EmployeeInf employee);

    /**
     * @return void
     * @Description: 修改员工
     * @Param [employee]
     * @author LeeJack
     * @Date 19:30 2019/4/13/013
     */
    void updateEmployee(EmployeeInf employee);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有部门，分页查询
     * @Param [dept , page, pageSize]
     * @author LeeJack
     * @Date 19:31 2019/4/13/013
     */
    JqGridResult queryDeptList(DeptInf dept , Integer page , Integer pageSize);

    /**
     * @return com.ljj.ceet.entity.DeptInf
     * @Description: 根据id查部门
     * @Param [id]
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     */
    DeptInf queryDeptById(Integer id);

    /**
     * @param id
     * @return void
     * @Description: 根据id删除部门
     * @Param [id]
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     */
    public void deleteDeptById(Integer id);


    /**
     * @return void
     * @Description: 添加部门
     * @Param [dept]
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    void saveDept(DeptInf dept);

    /**
     * @return void
     * @Description: 修改部门
     * @Param [dept]
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    void updateDept(DeptInf dept);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有职位并分页
     * @Param []
     * @author LeeJack
     * @Date 19:35 2019/4/13/013
     */
    JqGridResult queryJobList(JobInf job , Integer page , Integer pageSize);

    /**
     * @return void
     * @Description: 根据id删除职位
     * @Param [id]
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
    void deleteJobById(Integer id);

    /**
     * @return boolean
     * @Description: 添加职位
     * @Param [job]
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
    void saveJob(JobInf job);

    /**
     * @return com.ljj.ceet.entity.JobInf
     * @Description: 根据id查询职位
     * @Param [id]
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    JobInf queryJobById(Integer id);

    /**
     * @return void
     * @Description: 修改职位
     * @Param [job]
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    void updateJob(JobInf job);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有公告
     * @Param [notice , page, pageSize]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    JqGridResult queryNoticeList(NoticeInf notice , Integer page , Integer pageSize);

    /**
     * @return com.ljj.ceet.entity.NoticeInf
     * @Description: 根据id查询公告
     * @Param [id]
     * @author LeeJack
     * @Date 19:39 2019/4/13/013
     */
    NoticeInf queryNoticeById(Integer id);

    /**
     * @return void
     * @Description: 根据id删除公告
     * @Param [id]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    void deleteNoticeById(Integer id);

    /**
     * @return boolean
     * @Description: 添加公告
     * @Param [notice]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    void saveNotice(NoticeInf notice);

    /**
     * @return void
     * @Description: 修改公告
     * @Param [notice]
     * @author LeeJack
     * @Date 19:41 2019/4/13/013
     */
    void updateNotice(NoticeInf notice);

    /**
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有文档
     * @Param [document , page, pageSize]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    JqGridResult queryDocumentList(DocumentInf document , Integer page , Integer pageSize);

    /**
     * @return void
     * @Description: 添加文档
     * @Param [document]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    void saveDocument(DocumentInf document);

    /**
     * @return com.ljj.ceet.entity.DocumentInf
     * @Description: 根据id查询文档
     * @Param [id]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    DocumentInf queryDocumentById(Integer id);


    /**
     * @return void
     * @Description: 根据id删除文档
     * @Param [id]
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    void deleteDocumentById(Integer id);

    /**
     * @return void
     * @Description: 修改文档
     * @Param [document]
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    void updateDocument(DocumentInf document);
}
