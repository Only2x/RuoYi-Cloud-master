package com.xxx.order.service.impl;

import com.ruoyi.common.core.utils.DateUtils;
import com.xxx.order.domain.OmsOrderReturnApply;
import com.xxx.order.mapper.OmsOrderReturnApplyMapper;
import com.xxx.order.service.IOmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单退货申请Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-01
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements IOmsOrderReturnApplyService 
{
    @Autowired
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;

    /**
     * 查询订单退货申请
     * 
     * @param id 订单退货申请主键
     * @return 订单退货申请
     */
    @Override
    public OmsOrderReturnApply selectOmsOrderReturnApplyById(Long id)
    {
        return omsOrderReturnApplyMapper.selectOmsOrderReturnApplyById(id);
    }

    /**
     * 查询订单退货申请列表
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 订单退货申请
     */
    @Override
    public List<OmsOrderReturnApply> selectOmsOrderReturnApplyList(OmsOrderReturnApply omsOrderReturnApply)
    {
        return omsOrderReturnApplyMapper.selectOmsOrderReturnApplyList(omsOrderReturnApply);
    }

    /**
     * 新增订单退货申请
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 结果
     */
    @Override
    public int insertOmsOrderReturnApply(OmsOrderReturnApply omsOrderReturnApply)
    {
        omsOrderReturnApply.setCreateTime(DateUtils.getNowDate());
        return omsOrderReturnApplyMapper.insertOmsOrderReturnApply(omsOrderReturnApply);
    }

    /**
     * 修改订单退货申请
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 结果
     */
    @Override
    public int updateOmsOrderReturnApply(OmsOrderReturnApply omsOrderReturnApply)
    {
        return omsOrderReturnApplyMapper.updateOmsOrderReturnApply(omsOrderReturnApply);
    }

    /**
     * 批量删除订单退货申请
     * 
     * @param ids 需要删除的订单退货申请主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnApplyByIds(Long[] ids)
    {
        return omsOrderReturnApplyMapper.deleteOmsOrderReturnApplyByIds(ids);
    }

    /**
     * 删除订单退货申请信息
     * 
     * @param id 订单退货申请主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnApplyById(Long id)
    {
        return omsOrderReturnApplyMapper.deleteOmsOrderReturnApplyById(id);
    }
}
