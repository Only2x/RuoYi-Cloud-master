package com.xxx.product.service;

import java.util.List;
import com.xxx.product.domain.PmsAttr;

/**
 * 商品属性Service接口
 * 
 * @author xxx
 * @date 2023-06-02
 */
public interface IPmsAttrService 
{
    /**
     * 查询商品属性
     * 
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    public PmsAttr selectPmsAttrByAttrId(Long attrId);

    /**
     * 查询商品属性列表
     * 
     * @param pmsAttr 商品属性
     * @return 商品属性集合
     */
    public List<PmsAttr> selectPmsAttrList(PmsAttr pmsAttr);

    /**
     * 新增商品属性
     * 
     * @param pmsAttr 商品属性
     * @return 结果
     */
    public int insertPmsAttr(PmsAttr pmsAttr);

    /**
     * 修改商品属性
     * 
     * @param pmsAttr 商品属性
     * @return 结果
     */
    public int updatePmsAttr(PmsAttr pmsAttr);

    /**
     * 批量删除商品属性
     * 
     * @param attrIds 需要删除的商品属性主键集合
     * @return 结果
     */
    public int deletePmsAttrByAttrIds(Long[] attrIds);

    /**
     * 删除商品属性信息
     * 
     * @param attrId 商品属性主键
     * @return 结果
     */
    public int deletePmsAttrByAttrId(Long attrId);
}
