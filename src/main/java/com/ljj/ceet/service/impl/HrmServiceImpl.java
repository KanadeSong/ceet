package com.ljj.ceet.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljj.ceet.entity.*;
import com.ljj.ceet.mapper.*;
import com.ljj.ceet.service.HrmService;
import com.ljj.ceet.util.pojo.JqGridResult;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CLassName HrmServiceImpl
 * @Description 人事管理系统服务层接口实现类
 * @Author LeeJack
 * @Date 2019/4/13/013 19:45
 * @Version 1.0
 */
@Service
public class HrmServiceImpl implements HrmService {

    @Autowired
    private UserInfMapper userInfMapper;

    @Autowired
    private DeptInfMapper deptInfMapper;

    @Autowired
    private EmployeeInfMapper employeeInfMapper;

    @Autowired
    private JobInfMapper jobInfMapper;

    @Autowired
    private NoticeInfMapper noticeInfMapper;

    @Autowired
    private DocumentInfMapper documentInfMapper;

    @Autowired
    private Sid sid;

    /* 用户服务接口实现 */

    /**
     * @param userId
     * @return com.ljj.ceet.entity.UserInf
     * @Description: 根据id查询用户
     * @Param [id]
     * @author LeeJack
     * @Date 16:43 2019/4/13/013
     */
    @Override
    public UserInf queryUserById(Integer userId) {
        UserInf userInf = userInfMapper.selectByPrimaryKey(userId);
        return userInf;
    }

    /**
     * @param userInf
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 查询用户列表
     * @Param [userInf , page, pageSize]
     * @author LeeJack
     * @Date 18:50 2019/4/13/013
     */
    @Override
    public JqGridResult queryUserList(UserInf userInf , Integer page , Integer pageSize) {
        PageHelper.startPage(page , pageSize);

        UserInfExample ue = new UserInfExample();
        UserInfExample.Criteria uc = ue.createCriteria();

        if (StringUtils.isNotEmpty(userInf.getUsername())) {
            uc.andUsernameLike("%" + userInf.getUsername() + "%");
        }

        if (StringUtils.isNotEmpty(userInf.getLoginname())) {
            uc.andUsernameLike("%" + userInf.getLoginname() + "%");
        }

        if (userInf.getStatus() != null) {
            uc.andStatusEqualTo(userInf.getStatus());
        }

        List<UserInf> userInfList = userInfMapper.selectByExample(ue);

        PageInfo<UserInf> pageList = new PageInfo<>(userInfList);

        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(userInfList);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param userId
     * @return void
     * @Description: 根据id删除用户
     * @Param [userId]
     * @author LeeJack
     * @Date 19:20 2019/4/13/013
     */
    @Override
    public void deleteUserById(Integer userId) {
        userInfMapper.updateByPrimaryKeySelective(userId);
    }

    /**
     * @param userInf
     * @return boolean
     * @Description: 保存用户
     * @Param [userInf]
     * @author LeeJack
     * @Date 19:22 2019/4/13/013
     */
    @Override
    public void saveUser(UserInf userInf) {

        int result = userInfMapper.insert(userInf);

    }

    /**
     * @param user
     * @return void
     * @Description: 修改用户
     * @Param [user]
     * @author LeeJack
     * @Date 19:23 2019/4/13/013
     */
    @Override
    public UserInf updateUserById(Integer user) {
        userInfMapper.updateByPrimaryKeySelective(user);
        return null;
    }

    /**
     * @param employee
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 查询所有员工
     * @Param [employee , page, pageSize]
     * @author LeeJack
     * @Date 19:25 2019/4/13/013
     */
    @Override
    public JqGridResult queryEmployeeList(EmployeeInf employee , Integer page , Integer pageSize) {

        PageHelper.startPage(page , pageSize);

        EmployeeInfExample ee = new EmployeeInfExample();

        //EmployeeInfExample.Criteria ec = ee.createCriteria();

        List<EmployeeInf> result = employeeInfMapper.selectByExample(ee);

        PageInfo<EmployeeInf> pageList = new PageInfo<>(result);

        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param id
     * @return void
     * @Description: 根据id删除员工
     * @Param [id]
     * @author LeeJack
     * @Date 19:27 2019/4/13/013
     */
    @Override
    public void deleteEmployeeById(Integer id) {
        employeeInfMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param id
     * @return com.ljj.ceet.entity.EmployeeInf
     * @Description: 根据id查询员工
     * @Param [id]
     * @author LeeJack
     * @Date 19:28 2019/4/13/013
     */
    @Override
    public EmployeeInf queryEmployeeById(Integer id) {

        EmployeeInf employeeInf = employeeInfMapper.selectByPrimaryKey(id);
        return employeeInf;
    }

    /**
     * @param employee
     * @return boolean
     * @Description: 添加员工
     * @Param [employee]
     * @author LeeJack
     * @Date 19:29 2019/4/13/013
     */
    @Override
    public void saveEmployee(EmployeeInf employee) {
        String employeeId = sid.nextShort();
        employee.setId(employeeId);

        employeeInfMapper.insert(employee);
    }

    /**
     * @param employee
     * @return void
     * @Description: 修改员工
     * @Param [employee]
     * @author LeeJack
     * @Date 19:30 2019/4/13/013
     */
    @Override
    public void updateEmployee(EmployeeInf employee) {
        employeeInfMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * @param dept
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有部门，分页查询
     * @Param [dept , page, pageSize]
     * @author LeeJack
     * @Date 19:31 2019/4/13/013
     */
    @Override
    public JqGridResult queryDeptList(DeptInf dept , Integer page , Integer pageSize) {

        PageHelper.startPage(page , pageSize);

        DeptInfExample deptInfExample = new DeptInfExample();

        List<DeptInf> result = deptInfMapper.selectByExample(deptInfExample);

        PageInfo<DeptInf> pageList = new PageInfo<>(result);

        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param id
     * @return com.ljj.ceet.entity.DeptInf
     * @Description: 根据id查部门
     * @Param [id]
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     */
    @Override
    public DeptInf queryDeptById(Integer id) {
        DeptInf deptInf = new DeptInf();
        deptInf = deptInfMapper.selectByPrimaryKey(id);
        return deptInf;
    }

    /**
     * @param id
     * @return void
     * @Description: 根据id删除部门
     * @Param [id]
     * @author LeeJack
     * @Date 19:33 2019/4/13/013
     */
    @Override
    public void deleteDeptById(Integer id) {
        deptInfMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param dept
     * @return void
     * @Description: 添加部门
     * @Param [dept]
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    @Override
    public void saveDept(DeptInf dept) {
        String deptId = sid.nextShort();
        dept.setId(deptId);
        deptInfMapper.insert(dept);
    }

    /**
     * @param dept
     * @return void
     * @Description: 修改部门
     * @Param [dept]
     * @author LeeJack
     * @Date 19:34 2019/4/13/013
     */
    @Override
    public void updateDept(DeptInf dept) {
        deptInfMapper.updateByPrimaryKeySelective(dept);
    }

    /**
     * @param job
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有职位并分页
     * @Param []
     * @author LeeJack
     * @Date 19:35 2019/4/13/013
     */
    @Override
    public JqGridResult queryJobList(JobInf job , Integer page , Integer pageSize) {

        PageHelper.startPage(page , pageSize);

        JobInfExample jobInfExample = new JobInfExample();

        List<JobInf> result = jobInfMapper.selectByExample(jobInfExample);

        PageInfo<JobInf> pageList = new PageInfo<>(result);

        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param id
     * @return void
     * @Description: 根据id删除职位
     * @Param [id]
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
    @Override
    public void deleteJobById(Integer id) {
        jobInfMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param job
     * @return boolean
     * @Description: 添加职位
     * @Param [job]
     * @author LeeJack
     * @Date 19:37 2019/4/13/013
     */
    @Override
    public void saveJob(JobInf job) {
        String jobId = sid.nextShort();
        job.setId(jobId);
        jobInfMapper.insert(job);
    }

    /**
     * @param id
     * @return com.ljj.ceet.entity.JobInf
     * @Description: 根据id查询职位
     * @Param [id]
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    @Override
    public JobInf queryJobById(Integer id) {
        JobInf jobInf = new JobInf();
        jobInf = jobInfMapper.selectByPrimaryKey(id);
        return jobInf;
    }

    /**
     * @param job
     * @return void
     * @Description: 修改职位
     * @Param [job]
     * @author LeeJack
     * @Date 19:38 2019/4/13/013
     */
    @Override
    public void updateJob(JobInf job) {
        jobInfMapper.updateByPrimaryKeySelective(job);
    }

    /**
     * @param notice
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有公告
     * @Param [notice , page, pageSize]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    @Override
    public JqGridResult queryNoticeList(NoticeInf notice , Integer page , Integer pageSize) {

        PageHelper.startPage(page , pageSize);

        NoticeInfExample noticeInfExample = new NoticeInfExample();

        List<NoticeInf> result = noticeInfMapper.selectByExample(noticeInfExample);

        PageInfo<NoticeInf> pageList = new PageInfo<>(result);

        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param id
     * @return com.ljj.ceet.entity.NoticeInf
     * @Description: 根据id查询公告
     * @Param [id]
     * @author LeeJack
     * @Date 19:39 2019/4/13/013
     */
    @Override
    public NoticeInf queryNoticeById(Integer id) {
        NoticeInf noticeInf = new NoticeInf();
        noticeInf = noticeInfMapper.selectByPrimaryKey(id);
        return noticeInf;
    }

    /**
     * @param id
     * @return void
     * @Description: 根据id删除公告
     * @Param [id]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    @Override
    public void deleteNoticeById(Integer id) {
        noticeInfMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param notice
     * @return boolean
     * @Description: 添加公告
     * @Param [notice]
     * @author LeeJack
     * @Date 19:40 2019/4/13/013
     */
    @Override
    public void saveNotice(NoticeInf notice) {
        String noticeId = sid.nextShort();
        notice.setId(noticeId);
        noticeInfMapper.insert(notice);
    }

    /**
     * @param notice
     * @return void
     * @Description: 修改公告
     * @Param [notice]
     * @author LeeJack
     * @Date 19:41 2019/4/13/013
     */
    @Override
    public void updateNotice(NoticeInf notice) {
        noticeInfMapper.updateByPrimaryKeySelective(notice);
    }

    /**
     * @param document
     * @param page
     * @param pageSize
     * @return com.ljj.ceet.util.pojo.JqGridResult
     * @Description: 获得所有文档
     * @Param [document , page, pageSize]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    @Override
    public JqGridResult queryDocumentList(DocumentInf document , Integer page , Integer pageSize) {
        PageHelper.startPage(page , pageSize);

        DocumentInfExample documentInfExample = new DocumentInfExample();

        List<DocumentInf> result = documentInfMapper.selectByExample(documentInfExample);

        PageInfo<DocumentInf> pageList = new PageInfo<>(result);
        JqGridResult grid = new JqGridResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    /**
     * @param document
     * @return void
     * @Description: 添加文档
     * @Param [document]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    @Override
    public void saveDocument(DocumentInf document) {
        String documentId = sid.nextShort();
        document.setId(documentId);
        documentInfMapper.insert(document);
    }

    /**
     * @param id
     * @return com.ljj.ceet.entity.DocumentInf
     * @Description: 根据id查询文档
     * @Param [id]
     * @author LeeJack
     * @Date 19:42 2019/4/13/013
     */
    @Override
    public DocumentInf queryDocumentById(Integer id) {
        DocumentInf documentInf = new DocumentInf();
        documentInf = documentInfMapper.selectByPrimaryKey(id);
        return documentInf;
    }

    /**
     * @param id
     * @return void
     * @Description: 根据id删除文档
     * @Param [id]
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    @Override
    public void deleteDocumentById(Integer id) {
        documentInfMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param document
     * @return void
     * @Description: 修改文档
     * @Param [document]
     * @author LeeJack
     * @Date 19:43 2019/4/13/013
     */
    @Override
    public void updateDocument(DocumentInf document) {
        documentInfMapper.updateByPrimaryKeySelective(document);
    }

}
