package com.xxx.product.service;

import java.util.List;
import com.xxx.product.domain.PmsAttrGroup;

/**
 * 属性分组Service接口
 * 
 * @author xxx
 * @date 2023-06-02
 */
public interface IPmsAttrGroupService 
{
    /**
     * 查询属性分组
     * 
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    public PmsAttrGroup selectPmsAttrGroupByAttrGroupId(Long attrGroupId);

    /**
     * 查询属性分组列表
     * 
     * @param pmsAttrGroup 属性分组
     * @return 属性分组集合
     */
    public List<PmsAttrGroup> selectPmsAttrGroupList(PmsAttrGroup pmsAttrGroup);

    /**
     * 新增属性分组
     * 
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    public int insertPmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 修改属性分组
     * 
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    public int updatePmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 批量删除属性分组
     * 
     * @param attrGroupIds 需要删除的属性分组主键集合
     * @return 结果
     */
    public int deletePmsAttrGroupByAttrGroupIds(Long[] attrGroupIds);

    /**
     * 删除属性分组信息
     * 
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    public int deletePmsAttrGroupByAttrGroupId(Long attrGroupId);
}
