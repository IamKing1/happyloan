package com.group8.service.function;

import com.group8.dao.function.FunctionDao;
import com.group8.entity.Permission;
import com.group8.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:FunctionServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 11:53
 */
@Service
@SuppressWarnings("all")
public class FunctionServiceImpl implements FunctionService {
        @Autowired  //依赖注入
        private FunctionDao functionDao;

    @Override
    public List<Map> getList() {
        List<Map> list = functionDao.getList();
        return list;
    }

    @Override
    public List<Map> getListByPid(Integer Pid) {
        List<Map> childrenList = functionDao.getListByPid(Pid);

        return childrenList;
    }

    @Override
    public List<Role> getAllRole(Map map) {
        List<Role> allRole = functionDao.getAllRole(map);

        for (Role role : allRole) {
            List<Permission> permissionListByRole = functionDao.getPermissionByRole(role);
           if(permissionListByRole!=null&&permissionListByRole.size()>0) {
               System.out.println(permissionListByRole);
               role.setPermissionList(permissionListByRole);
           }
        }

        return allRole;
    }

    @Override
    public Integer getAllRoleCount(Map map) {
        Integer allRoleCount = functionDao.getAllRoleCount(map);
        return allRoleCount;
    }
}
