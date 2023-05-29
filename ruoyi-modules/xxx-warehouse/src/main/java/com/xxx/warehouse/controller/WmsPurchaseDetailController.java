package com.xxx.warehouse.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.xxx.warehouse.domain.WmsPurchaseDetail;
import com.xxx.warehouse.service.IWmsPurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 采购单详情Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/wmsPurchaseDetail")
public class WmsPurchaseDetailController extends BaseController
{
    @Autowired
    private IWmsPurchaseDetailService wmsPurchaseDetailService;

    /**
     * 查询采购单详情列表
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsPurchaseDetail wmsPurchaseDetail)
    {
        startPage();
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购单详情列表
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:export")
    @Log(title = "采购单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsPurchaseDetail wmsPurchaseDetail)
    {
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        ExcelUtil<WmsPurchaseDetail> util = new ExcelUtil<WmsPurchaseDetail>(WmsPurchaseDetail.class);
        util.exportExcel(response, list, "采购单详情数据");
    }

    /**
     * 获取采购单详情详细信息
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsPurchaseDetailService.selectWmsPurchaseDetailById(id));
    }

    /**
     * 新增采购单详情
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:add")
    @Log(title = "采购单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsPurchaseDetail wmsPurchaseDetail)
    {
        return toAjax(wmsPurchaseDetailService.insertWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 修改采购单详情
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:edit")
    @Log(title = "采购单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsPurchaseDetail wmsPurchaseDetail)
    {
        return toAjax(wmsPurchaseDetailService.updateWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 删除采购单详情
     */
    @RequiresPermissions("warehouse:wmsPurchaseDetail:remove")
    @Log(title = "采购单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsPurchaseDetailService.deleteWmsPurchaseDetailByIds(ids));
    }
}
