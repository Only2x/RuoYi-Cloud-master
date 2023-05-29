package com.xxx.warehouse.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.xxx.warehouse.domain.WmsWareInfo;
import com.xxx.warehouse.service.IWmsWareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 仓库管理信息Controller
 * 
 * @author zyf
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/wmsInfoDesc")
public class WmsWareInfoController extends BaseController
{
    @Autowired
    private IWmsWareInfoService wmsWareInfoService;

    /**
     * 查询仓库管理信息列表
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareInfo wmsWareInfo)
    {
        startPage();
        List<WmsWareInfo> list = wmsWareInfoService.selectWmsWareInfoList(wmsWareInfo);
        return getDataTable(list);
    }

    /**
     * 导出仓库管理信息列表
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:export")
    @Log(title = "仓库管理信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareInfo wmsWareInfo)
    {
        List<WmsWareInfo> list = wmsWareInfoService.selectWmsWareInfoList(wmsWareInfo);
        ExcelUtil<WmsWareInfo> util = new ExcelUtil<WmsWareInfo>(WmsWareInfo.class);
        util.exportExcel(response, list, "仓库管理信息数据");
    }

    /**
     * 获取仓库管理信息详细信息
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareInfoService.selectWmsWareInfoById(id));
    }

    /**
     * 新增仓库管理信息
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:add")
    @Log(title = "仓库管理信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareInfo wmsWareInfo)
    {
        return toAjax(wmsWareInfoService.insertWmsWareInfo(wmsWareInfo));
    }

    /**
     * 修改仓库管理信息
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:edit")
    @Log(title = "仓库管理信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareInfo wmsWareInfo)
    {
        return toAjax(wmsWareInfoService.updateWmsWareInfo(wmsWareInfo));
    }

    /**
     * 删除仓库管理信息
     */
    @RequiresPermissions("warehouse:wmsInfoDesc:remove")
    @Log(title = "仓库管理信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareInfoService.deleteWmsWareInfoByIds(ids));
    }
}
