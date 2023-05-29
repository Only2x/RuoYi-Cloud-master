package com.xxx.order.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.xxx.order.domain.OmsPaymentInfo;
import com.xxx.order.service.IOmsPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 支付信息Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/info")
public class OmsPaymentInfoController extends BaseController
{
    @Autowired
    private IOmsPaymentInfoService omsPaymentInfoService;

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("order:info:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsPaymentInfo omsPaymentInfo)
    {
        startPage();
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("order:info:export")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsPaymentInfo omsPaymentInfo)
    {
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        ExcelUtil<OmsPaymentInfo> util = new ExcelUtil<OmsPaymentInfo>(OmsPaymentInfo.class);
        util.exportExcel(response, list, "支付信息数据");
    }

    /**
     * 获取支付信息详细信息
     */
    @RequiresPermissions("order:info:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsPaymentInfoService.selectOmsPaymentInfoById(id));
    }

    /**
     * 新增支付信息
     */
    @RequiresPermissions("order:info:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsPaymentInfo omsPaymentInfo)
    {
        return toAjax(omsPaymentInfoService.insertOmsPaymentInfo(omsPaymentInfo));
    }

    /**
     * 修改支付信息
     */
    @RequiresPermissions("order:info:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsPaymentInfo omsPaymentInfo)
    {
        return toAjax(omsPaymentInfoService.updateOmsPaymentInfo(omsPaymentInfo));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("order:info:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsPaymentInfoService.deleteOmsPaymentInfoByIds(ids));
    }
}
