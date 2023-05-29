package com.xxx.warehouse.mapper;

import java.util.List;
import com.xxx.warehouse.domain.WmsWareInfo;

/**
 * 仓库管理信息Mapper接口
 * 
 * @author zyf
 * @date 2023-05-31
 */
public interface WmsWareInfoMapper 
{
    /**
     * 查询仓库管理信息
     * 
     * @param id 仓库管理信息主键
     * @return 仓库管理信息
     */
    public WmsWareInfo selectWmsWareInfoById(Long id);

    /**
     * 查询仓库管理信息列表
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 仓库管理信息集合
     */
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

    /**
     * 新增仓库管理信息
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 结果
     */
    public int insertWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 修改仓库管理信息
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 结果
     */
    public int updateWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 删除仓库管理信息
     * 
     * @param id 仓库管理信息主键
     * @return 结果
     */
    public int deleteWmsWareInfoById(Long id);

    /**
     * 批量删除仓库管理信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWareInfoByIds(Long[] ids);
}
