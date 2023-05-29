package com.xxx.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.product.mapper.PmsBrandMapper;
import com.xxx.product.domain.PmsBrand;
import com.xxx.product.service.IPmsBrandService;

/**
 * 品牌Service业务层处理
 * 
 * @author xxx
 * @date 2023-06-02
 */
@Service
public class PmsBrandServiceImpl implements IPmsBrandService 
{
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    @Override
    public PmsBrand selectPmsBrandByBrandId(Long brandId)
    {
        return pmsBrandMapper.selectPmsBrandByBrandId(brandId);
    }

    /**
     * 查询品牌列表
     * 
     * @param pmsBrand 品牌
     * @return 品牌
     */
    @Override
    public List<PmsBrand> selectPmsBrandList(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.selectPmsBrandList(pmsBrand);
    }

    /**
     * 新增品牌
     * 
     * @param pmsBrand 品牌
     * @return 结果
     */
    @Override
    public int insertPmsBrand(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.insertPmsBrand(pmsBrand);
    }

    /**
     * 修改品牌
     * 
     * @param pmsBrand 品牌
     * @return 结果
     */
    @Override
    public int updatePmsBrand(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.updatePmsBrand(pmsBrand);
    }

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deletePmsBrandByBrandIds(Long[] brandIds)
    {
        return pmsBrandMapper.deletePmsBrandByBrandIds(brandIds);
    }

    /**
     * 删除品牌信息
     * 
     * @param brandId 品牌主键
     * @return 结果
     */
    @Override
    public int deletePmsBrandByBrandId(Long brandId)
    {
        return pmsBrandMapper.deletePmsBrandByBrandId(brandId);
    }
}
