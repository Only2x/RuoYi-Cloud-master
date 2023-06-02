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
import com.xxx.order.domain.OmsOrderReturnReason;
import com.xxx.order.service.IOmsOrderReturnReasonService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 退货原因Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/reason")
public class OmsOrderReturnReasonController extends BaseController
{
    @Autowired
    private IOmsOrderReturnReasonService omsOrderReturnReasonService;

    /**
     * 查询退货原因列表
     */
    @RequiresPermissions("order:reason:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderReturnReason omsOrderReturnReason)
    {
        startPage();
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        return getDataTable(list);
    }

    /**
     * 导出退货原因列表
     */
    @RequiresPermissions("order:reason:export")
    @Log(title = "退货原因", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderReturnReason omsOrderReturnReason)
    {
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        ExcelUtil<OmsOrderReturnReason> util = new ExcelUtil<OmsOrderReturnReason>(OmsOrderReturnReason.class);
        util.exportExcel(response, list, "退货原因数据");
    }

    /**
     * 获取退货原因详细信息
     */
    @RequiresPermissions("order:reason:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderReturnReasonService.selectOmsOrderReturnReasonById(id));
    }

    /**
     * 新增退货原因
     */
    @RequiresPermissions("order:reason:add")
    @Log(title = "退货原因", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderReturnReason omsOrderReturnReason)
    {
        return toAjax(omsOrderReturnReasonService.insertOmsOrderReturnReason(omsOrderReturnReason));
    }

    /**
     * 修改退货原因
     */
    @RequiresPermissions("order:reason:edit")
    @Log(title = "退货原因", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderReturnReason omsOrderReturnReason)
    {
        return toAjax(omsOrderReturnReasonService.updateOmsOrderReturnReason(omsOrderReturnReason));
    }

    /**
     * 删除退货原因
     */
    @RequiresPermissions("order:reason:remove")
    @Log(title = "退货原因", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderReturnReasonService.deleteOmsOrderReturnReasonByIds(ids));
    }
}
