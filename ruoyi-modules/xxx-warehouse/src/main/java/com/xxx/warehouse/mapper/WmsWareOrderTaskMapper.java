package com.xxx.warehouse.mapper;

import com.xxx.warehouse.domain.WmsWareOrderTask;

import java.util.List;

/**
 * 库存工作单Mapper接口
 * 
 * @author zyf
 * @date 2023-06-01
 */
public interface WmsWareOrderTaskMapper 
{
    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    public WmsWareOrderTask selectWmsWareOrderTaskById(Long id);

    /**
     * 查询库存工作单列表
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 库存工作单集合
     */
    public List<WmsWareOrderTask> selectWmsWareOrderTaskList(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 新增库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    public int insertWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 修改库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    public int updateWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 删除库存工作单
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    public int deleteWmsWareOrderTaskById(Long id);

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWareOrderTaskByIds(Long[] ids);
}
