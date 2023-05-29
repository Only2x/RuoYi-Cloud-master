package com.xxx.preferentialmarketing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.preferentialmarketing.mapper.SmsCouponSpuRelationMapper;
import com.xxx.preferentialmarketing.domain.SmsCouponSpuRelation;
import com.xxx.preferentialmarketing.service.ISmsCouponSpuRelationService;

/**
 * 优惠券与产品关联Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-02
 */
@Service
public class SmsCouponSpuRelationServiceImpl implements ISmsCouponSpuRelationService 
{
    @Autowired
    private SmsCouponSpuRelationMapper smsCouponSpuRelationMapper;

    /**
     * 查询优惠券与产品关联
     * 
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    @Override
    public SmsCouponSpuRelation selectSmsCouponSpuRelationById(Long id)
    {
        return smsCouponSpuRelationMapper.selectSmsCouponSpuRelationById(id);
    }

    /**
     * 查询优惠券与产品关联列表
     * 
     * @param smsCouponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联
     */
    @Override
    public List<SmsCouponSpuRelation> selectSmsCouponSpuRelationList(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return smsCouponSpuRelationMapper.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
    }

    /**
     * 新增优惠券与产品关联
     * 
     * @param smsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int insertSmsCouponSpuRelation(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return smsCouponSpuRelationMapper.insertSmsCouponSpuRelation(smsCouponSpuRelation);
    }

    /**
     * 修改优惠券与产品关联
     * 
     * @param smsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int updateSmsCouponSpuRelation(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return smsCouponSpuRelationMapper.updateSmsCouponSpuRelation(smsCouponSpuRelation);
    }

    /**
     * 批量删除优惠券与产品关联
     * 
     * @param ids 需要删除的优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsCouponSpuRelationByIds(Long[] ids)
    {
        return smsCouponSpuRelationMapper.deleteSmsCouponSpuRelationByIds(ids);
    }

    /**
     * 删除优惠券与产品关联信息
     * 
     * @param id 优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsCouponSpuRelationById(Long id)
    {
        return smsCouponSpuRelationMapper.deleteSmsCouponSpuRelationById(id);
    }
}
