package com.xxx.member.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.member.mapper.UmsIntegrationChangeHistoryMapper;
import com.xxx.member.domain.UmsIntegrationChangeHistory;
import com.xxx.member.service.IUmsIntegrationChangeHistoryService;

/**
 * 积分变化历史记录Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-02
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl implements IUmsIntegrationChangeHistoryService 
{
    @Autowired
    private UmsIntegrationChangeHistoryMapper umsIntegrationChangeHistoryMapper;

    /**
     * 查询积分变化历史记录
     * 
     * @param id 积分变化历史记录主键
     * @return 积分变化历史记录
     */
    @Override
    public UmsIntegrationChangeHistory selectUmsIntegrationChangeHistoryById(Long id)
    {
        return umsIntegrationChangeHistoryMapper.selectUmsIntegrationChangeHistoryById(id);
    }

    /**
     * 查询积分变化历史记录列表
     * 
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录
     */
    @Override
    public List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return umsIntegrationChangeHistoryMapper.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
    }

    /**
     * 新增积分变化历史记录
     * 
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    @Override
    public int insertUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        umsIntegrationChangeHistory.setCreateTime(DateUtils.getNowDate());
        return umsIntegrationChangeHistoryMapper.insertUmsIntegrationChangeHistory(umsIntegrationChangeHistory);
    }

    /**
     * 修改积分变化历史记录
     * 
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    @Override
    public int updateUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return umsIntegrationChangeHistoryMapper.updateUmsIntegrationChangeHistory(umsIntegrationChangeHistory);
    }

    /**
     * 批量删除积分变化历史记录
     * 
     * @param ids 需要删除的积分变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsIntegrationChangeHistoryByIds(Long[] ids)
    {
        return umsIntegrationChangeHistoryMapper.deleteUmsIntegrationChangeHistoryByIds(ids);
    }

    /**
     * 删除积分变化历史记录信息
     * 
     * @param id 积分变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsIntegrationChangeHistoryById(Long id)
    {
        return umsIntegrationChangeHistoryMapper.deleteUmsIntegrationChangeHistoryById(id);
    }
}
