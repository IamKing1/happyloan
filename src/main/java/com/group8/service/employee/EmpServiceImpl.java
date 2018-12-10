package com.group8.service.employee;


import com.group8.dao.employee.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:empServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-11-24 19:17
 */
@Service
@SuppressWarnings("all")
public class EmpServiceImpl implements EmpService {

    @Autowired  //依赖注入
    private EmpDao empdao;


    /**
     * 查询分页
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        List<Map> list = empdao.getList(map);
        return list;
    }

    /**
     * 分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return empdao.getPageCount(map);
    }

    /**
     * 部门
     * @param
     * @return
     */
    @Override
    public List<Map> getDept() {
        return empdao.getDept();
    }

    /**
     * 职位
     * @param
     * @return
     */
    @Override
    public List<Map> getDuty() {
        return empdao.getDuty();
    }

    /**
     *更新
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return empdao.update(map);
    }

    @Override
    public int add(Map map) {
        return empdao.add(map);
    }

    /**
     * 删除
     * @param empid
     * @return
     */
    @Override
    public int delete(int empid) {
        return empdao.delete(empid);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchDelete(String ids) {
        boolean isAdd=true;
        if(ids!=null&&!"".equals(ids)){
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                int i= empdao.delete(Integer.valueOf(id));
                if(i<1) isAdd=false;
            }
        }
        if(isAdd) return 1;
        else  return 0;
    }
}
