package com.xxx.order.controller;

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
import com.xxx.order.domain.OmsOrderReturnApply;
import com.xxx.order.service.IOmsOrderReturnApplyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单退货申请Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/apply")
public class OmsOrderReturnApplyController extends BaseController
{
    @Autowired
    private IOmsOrderReturnApplyService omsOrderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
    @RequiresPermissions("order:apply:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderReturnApply omsOrderReturnApply)
    {
        startPage();
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        return getDataTable(list);
    }

    /**
     * 导出订单退货申请列表
     */
    @RequiresPermissions("order:apply:export")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderReturnApply omsOrderReturnApply)
    {
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        ExcelUtil<OmsOrderReturnApply> util = new ExcelUtil<OmsOrderReturnApply>(OmsOrderReturnApply.class);
        util.exportExcel(response, list, "订单退货申请数据");
    }

    /**
     * 获取订单退货申请详细信息
     */
    @RequiresPermissions("order:apply:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderReturnApplyService.selectOmsOrderReturnApplyById(id));
    }

    /**
     * 新增订单退货申请
     */
    @RequiresPermissions("order:apply:add")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderReturnApply omsOrderReturnApply)
    {
        return toAjax(omsOrderReturnApplyService.insertOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 修改订单退货申请
     */
    @RequiresPermissions("order:apply:edit")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderReturnApply omsOrderReturnApply)
    {
        return toAjax(omsOrderReturnApplyService.updateOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 删除订单退货申请
     */
    @RequiresPermissions("order:apply:remove")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderReturnApplyService.deleteOmsOrderReturnApplyByIds(ids));
    }
}
