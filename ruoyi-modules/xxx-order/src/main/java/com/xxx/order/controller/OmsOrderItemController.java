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
import com.xxx.order.domain.OmsOrderItem;
import com.xxx.order.service.IOmsOrderItemService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单项信息Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/item")
public class OmsOrderItemController extends BaseController
{
    @Autowired
    private IOmsOrderItemService omsOrderItemService;

    /**
     * 查询订单项信息列表
     */
    @RequiresPermissions("order:item:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderItem omsOrderItem)
    {
        startPage();
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单项信息列表
     */
    @RequiresPermissions("order:item:export")
    @Log(title = "订单项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderItem omsOrderItem)
    {
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        ExcelUtil<OmsOrderItem> util = new ExcelUtil<OmsOrderItem>(OmsOrderItem.class);
        util.exportExcel(response, list, "订单项信息数据");
    }

    /**
     * 获取订单项信息详细信息
     */
    @RequiresPermissions("order:item:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderItemService.selectOmsOrderItemById(id));
    }

    /**
     * 新增订单项信息
     */
    @RequiresPermissions("order:item:add")
    @Log(title = "订单项信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderItem omsOrderItem)
    {
        return toAjax(omsOrderItemService.insertOmsOrderItem(omsOrderItem));
    }

    /**
     * 修改订单项信息
     */
    @RequiresPermissions("order:item:edit")
    @Log(title = "订单项信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderItem omsOrderItem)
    {
        return toAjax(omsOrderItemService.updateOmsOrderItem(omsOrderItem));
    }

    /**
     * 删除订单项信息
     */
    @RequiresPermissions("order:item:remove")
    @Log(title = "订单项信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderItemService.deleteOmsOrderItemByIds(ids));
    }
}
