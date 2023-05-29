package com.xxx.order.service.impl;

import com.ruoyi.common.core.utils.DateUtils;
import com.xxx.order.domain.OmsOrderOperateHistory;
import com.xxx.order.mapper.OmsOrderOperateHistoryMapper;
import com.xxx.order.service.IOmsOrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单操作历史记录Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-01
 */
@Service
public class OmsOrderOperateHistoryServiceImpl implements IOmsOrderOperateHistoryService 
{
    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;

    /**
     * 查询订单操作历史记录
     * 
     * @param id 订单操作历史记录主键
     * @return 订单操作历史记录
     */
    @Override
    public OmsOrderOperateHistory selectOmsOrderOperateHistoryById(Long id)
    {
        return omsOrderOperateHistoryMapper.selectOmsOrderOperateHistoryById(id);
    }

    /**
     * 查询订单操作历史记录列表
     * 
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录
     */
    @Override
    public List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory)
    {
        return omsOrderOperateHistoryMapper.selectOmsOrderOperateHistoryList(omsOrderOperateHistory);
    }

    /**
     * 新增订单操作历史记录
     * 
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 结果
     */
    @Override
    public int insertOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory)
    {
        omsOrderOperateHistory.setCreateTime(DateUtils.getNowDate());
        return omsOrderOperateHistoryMapper.insertOmsOrderOperateHistory(omsOrderOperateHistory);
    }

    /**
     * 修改订单操作历史记录
     * 
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 结果
     */
    @Override
    public int updateOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory)
    {
        return omsOrderOperateHistoryMapper.updateOmsOrderOperateHistory(omsOrderOperateHistory);
    }

    /**
     * 批量删除订单操作历史记录
     * 
     * @param ids 需要删除的订单操作历史记录主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderOperateHistoryByIds(Long[] ids)
    {
        return omsOrderOperateHistoryMapper.deleteOmsOrderOperateHistoryByIds(ids);
    }

    /**
     * 删除订单操作历史记录信息
     * 
     * @param id 订单操作历史记录主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderOperateHistoryById(Long id)
    {
        return omsOrderOperateHistoryMapper.deleteOmsOrderOperateHistoryById(id);
    }
}
