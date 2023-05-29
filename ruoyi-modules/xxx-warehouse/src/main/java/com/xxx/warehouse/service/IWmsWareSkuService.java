package com.xxx.warehouse.service;

import com.xxx.warehouse.domain.WmsWareSku;

import java.util.List;

/**
 * 商品库存Service接口
 * 
 * @author zyf
 * @date 2023-06-01
 */
public interface IWmsWareSkuService 
{
    /**
     * 查询商品库存
     * 
     * @param id 商品库存主键
     * @return 商品库存
     */
    public WmsWareSku selectWmsWareSkuById(Long id);

    /**
     * 查询商品库存列表
     * 
     * @param wmsWareSku 商品库存
     * @return 商品库存集合
     */
    public List<WmsWareSku> selectWmsWareSkuList(WmsWareSku wmsWareSku);

    /**
     * 新增商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    public int insertWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 修改商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    public int updateWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键集合
     * @return 结果
     */
    public int deleteWmsWareSkuByIds(Long[] ids);

    /**
     * 删除商品库存信息
     * 
     * @param id 商品库存主键
     * @return 结果
     */
    public int deleteWmsWareSkuById(Long id);
}
