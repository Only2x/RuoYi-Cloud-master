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
import com.xxx.order.domain.OmsOrder;
import com.xxx.order.service.IOmsOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/order")
public class OmsOrderController extends BaseController
{
    @Autowired
    private IOmsOrderService omsOrderService;

    /**
     * 查询订单列表
     */
    @RequiresPermissions("order:order:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrder omsOrder)
    {
        startPage();
        List<OmsOrder> list = omsOrderService.selectOmsOrderList(omsOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("order:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrder omsOrder)
    {
        List<OmsOrder> list = omsOrderService.selectOmsOrderList(omsOrder);
        ExcelUtil<OmsOrder> util = new ExcelUtil<OmsOrder>(OmsOrder.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @RequiresPermissions("order:order:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderService.selectOmsOrderById(id));
    }

    /**
     * 新增订单
     */
    @RequiresPermissions("order:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrder omsOrder)
    {
        return toAjax(omsOrderService.insertOmsOrder(omsOrder));
    }

    /**
     * 修改订单
     */
    @RequiresPermissions("order:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrder omsOrder)
    {
        return toAjax(omsOrderService.updateOmsOrder(omsOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("order:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderService.deleteOmsOrderByIds(ids));
    }
}
