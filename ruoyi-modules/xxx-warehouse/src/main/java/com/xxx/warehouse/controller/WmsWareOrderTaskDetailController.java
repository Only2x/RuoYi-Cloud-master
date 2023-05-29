package com.xxx.warehouse.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.xxx.warehouse.domain.WmsWareOrderTaskDetail;
import com.xxx.warehouse.service.IWmsWareOrderTaskDetailService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 库存工作单详情Controller
 * 
 * @author zyf
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/wmsOrderTaskDetail")
public class WmsWareOrderTaskDetailController extends BaseController
{
    @Autowired
    private IWmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 查询库存工作单详情列表
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        startPage();
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单详情列表
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:export")
    @Log(title = "库存工作单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        ExcelUtil<WmsWareOrderTaskDetail> util = new ExcelUtil<WmsWareOrderTaskDetail>(WmsWareOrderTaskDetail.class);
        util.exportExcel(response, list, "库存工作单详情数据");
    }

    /**
     * 获取库存工作单详情详细信息
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailById(id));
    }

    /**
     * 新增库存工作单详情
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:add")
    @Log(title = "库存工作单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return toAjax(wmsWareOrderTaskDetailService.insertWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 修改库存工作单详情
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:edit")
    @Log(title = "库存工作单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return toAjax(wmsWareOrderTaskDetailService.updateWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 删除库存工作单详情
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDetail:remove")
    @Log(title = "库存工作单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareOrderTaskDetailService.deleteWmsWareOrderTaskDetailByIds(ids));
    }
}
