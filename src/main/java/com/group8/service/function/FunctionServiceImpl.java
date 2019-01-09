package com.group8.service.function;

import com.group8.dao.function.FunctionDao;
import com.group8.entity.Permission;
import com.group8.entity.Role;
import com.group8.entity.TreePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        //查询所有的角色
        List<Role> allRole = functionDao.getAllRole(map);

        for (Role role : allRole) {
            //查询次校色有的
          //  System.out.println(role.getRoleId());
            List<Permission> permissionListByRole = functionDao.getPermissionByRole(role);

           if(permissionListByRole!=null&&permissionListByRole.size()>0) {

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


    @Override
    public List<TreePermission> getAllPermission() {
        List<TreePermission> allPermission = functionDao.getAllPermission();
        for (TreePermission treePermission : allPermission) {
            treePermission.setChildren(functionDao.getAllPermissionByPid(treePermission.getId()));
        }
        return allPermission;
    }


    @Override
    public Integer saveNewPermission(Map map) {

        if(map.get("roleId")!=null){
            functionDao.deleteOldPermission(Integer.valueOf(map.get("roleId").toString()));
            if(map.get("ids")!=null){
                String[] ids = map.get("ids").toString().split(",");
                for (String id : ids) {
                    if(id!=null) {
                        Map map1 = new HashMap();
                        map1.put("roleId", map.get("roleId"));
                        map1.put("permissionId", id);
                        functionDao.saveNewPermission(map1);
                    }
                }
                return 1;
            }
            return -1;
        }
        return -1;
    }

}
