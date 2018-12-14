package com.group8.dao.auditing;

import java.util.List;
import java.util.Map;

/**
 * className:Release
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-06 20:41
 */
public interface ReleaseDao {

    /**
     * 招标信息
     * @param map
     * @return
     */
 List<Map> getReleaseMessage(Map map);

    /**
     * 最大数量  分页数据
     * @param map
     * @return
     */
 int getReleaseMessageCount(Map map);

    /**
     * 确认招标信息
     * @param map
     * @return
     */
 int confirmationInformation(Map map);

    /**
     * 确认之后更改借款状态
     * @param map
     * @return
     */
    int updateConfirmationInformationStuts(Map map);


    /**
     * 得到招标信息列表
     * @return
     */
    List<Map> getConfirmationInformationList();

    /**
     * 根据id查询借款人的详细资料
     * @param tendingId
     * @return
     */
    List<Map> selectAllMseege(Integer tendingId);

}
