package com.xxx.warehouse.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.warehouse.mapper.WmsWareInfoMapper;
import com.xxx.warehouse.domain.WmsWareInfo;
import com.xxx.warehouse.service.IWmsWareInfoService;

/**
 * 仓库管理信息Service业务层处理
 * 
 * @author zyf
 * @date 2023-05-31
 */
@Service
public class WmsWareInfoServiceImpl implements IWmsWareInfoService 
{
    @Autowired
    private WmsWareInfoMapper wmsWareInfoMapper;

    /**
     * 查询仓库管理信息
     * 
     * @param id 仓库管理信息主键
     * @return 仓库管理信息
     */
    @Override
    public WmsWareInfo selectWmsWareInfoById(Long id)
    {
        return wmsWareInfoMapper.selectWmsWareInfoById(id);
    }

    /**
     * 查询仓库管理信息列表
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 仓库管理信息
     */
    @Override
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo)
    {
        return wmsWareInfoMapper.selectWmsWareInfoList(wmsWareInfo);
    }

    /**
     * 新增仓库管理信息
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 结果
     */
    @Override
    public int insertWmsWareInfo(WmsWareInfo wmsWareInfo)
    {
        return wmsWareInfoMapper.insertWmsWareInfo(wmsWareInfo);
    }

    /**
     * 修改仓库管理信息
     * 
     * @param wmsWareInfo 仓库管理信息
     * @return 结果
     */
    @Override
    public int updateWmsWareInfo(WmsWareInfo wmsWareInfo)
    {
        return wmsWareInfoMapper.updateWmsWareInfo(wmsWareInfo);
    }

    /**
     * 批量删除仓库管理信息
     * 
     * @param ids 需要删除的仓库管理信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareInfoByIds(Long[] ids)
    {
        return wmsWareInfoMapper.deleteWmsWareInfoByIds(ids);
    }

    /**
     * 删除仓库管理信息信息
     * 
     * @param id 仓库管理信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareInfoById(Long id)
    {
        return wmsWareInfoMapper.deleteWmsWareInfoById(id);
    }
}
