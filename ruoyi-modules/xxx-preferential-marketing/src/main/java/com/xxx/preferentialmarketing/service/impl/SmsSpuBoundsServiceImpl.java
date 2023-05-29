package com.xxx.preferentialmarketing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.preferentialmarketing.mapper.SmsSpuBoundsMapper;
import com.xxx.preferentialmarketing.domain.SmsSpuBounds;
import com.xxx.preferentialmarketing.service.ISmsSpuBoundsService;

/**
 * 商品spu积分设置Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-02
 */
@Service
public class SmsSpuBoundsServiceImpl implements ISmsSpuBoundsService 
{
    @Autowired
    private SmsSpuBoundsMapper smsSpuBoundsMapper;

    /**
     * 查询商品spu积分设置
     * 
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    @Override
    public SmsSpuBounds selectSmsSpuBoundsById(Long id)
    {
        return smsSpuBoundsMapper.selectSmsSpuBoundsById(id);
    }

    /**
     * 查询商品spu积分设置列表
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 商品spu积分设置
     */
    @Override
    public List<SmsSpuBounds> selectSmsSpuBoundsList(SmsSpuBounds smsSpuBounds)
    {
        return smsSpuBoundsMapper.selectSmsSpuBoundsList(smsSpuBounds);
    }

    /**
     * 新增商品spu积分设置
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int insertSmsSpuBounds(SmsSpuBounds smsSpuBounds)
    {
        return smsSpuBoundsMapper.insertSmsSpuBounds(smsSpuBounds);
    }

    /**
     * 修改商品spu积分设置
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int updateSmsSpuBounds(SmsSpuBounds smsSpuBounds)
    {
        return smsSpuBoundsMapper.updateSmsSpuBounds(smsSpuBounds);
    }

    /**
     * 批量删除商品spu积分设置
     * 
     * @param ids 需要删除的商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteSmsSpuBoundsByIds(Long[] ids)
    {
        return smsSpuBoundsMapper.deleteSmsSpuBoundsByIds(ids);
    }

    /**
     * 删除商品spu积分设置信息
     * 
     * @param id 商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteSmsSpuBoundsById(Long id)
    {
        return smsSpuBoundsMapper.deleteSmsSpuBoundsById(id);
    }
}
