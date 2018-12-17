package com.group8.dao.function;

import com.group8.entity.Permission;
import com.group8.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * className:BackstageDao
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 11:16
 */
public interface FunctionDao {

    /**
     * 得到所有的菜单列表
     * @return
     */
    List<Map> getList();

    /**
     * 根据父id查询
     * @param Pid
     * @return
     */
    List<Map> getListByPid(Integer Pid);

    /**
     * 根据角色查询具有的id
     * @param role
     * @return
     */
    List<Permission> getPermissionByRole(Role role);

    /**
     * 得到所有的角色信息
     * @return
     */
    List<Role> getAllRole(Map map);

    /**
     * 得到所有的角色信息的最大数量
     * @return
     */
    Integer getAllRoleCount(Map map);

}
