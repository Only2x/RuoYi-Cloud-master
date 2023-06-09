package com.xxx.order.service;

import com.xxx.order.domain.OmsOrderReturnReason;

import java.util.List;

/**
 * 退货原因Service接口
 * 
 * @author xxx
 * @date 2023-06-01
 */
public interface IOmsOrderReturnReasonService 
{
    /**
     * 查询退货原因
     * 
     * @param id 退货原因主键
     * @return 退货原因
     */
    public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id);

    /**
     * 查询退货原因列表
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    public List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 新增退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    public int insertOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 修改退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    public int updateOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 批量删除退货原因
     * 
     * @param ids 需要删除的退货原因主键集合
     * @return 结果
     */
    public int deleteOmsOrderReturnReasonByIds(Long[] ids);

    /**
     * 删除退货原因信息
     * 
     * @param id 退货原因主键
     * @return 结果
     */
    public int deleteOmsOrderReturnReasonById(Long id);
}
