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
import com.xxx.order.domain.OmsRefundInfo;
import com.xxx.order.service.IOmsRefundInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 退款信息Controller
 * 
 * @author xxx
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/returninfo")
public class OmsRefundInfoController extends BaseController
{
    @Autowired
    private IOmsRefundInfoService omsRefundInfoService;

    /**
     * 查询退款信息列表
     */
    @RequiresPermissions("order:returninfo:list")
    @GetMapping("/list")
    public TableDataInfo list(OmsRefundInfo omsRefundInfo)
    {
        startPage();
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        return getDataTable(list);
    }

    /**
     * 导出退款信息列表
     */
    @RequiresPermissions("order:returninfo:export")
    @Log(title = "退款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsRefundInfo omsRefundInfo)
    {
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        ExcelUtil<OmsRefundInfo> util = new ExcelUtil<OmsRefundInfo>(OmsRefundInfo.class);
        util.exportExcel(response, list, "退款信息数据");
    }

    /**
     * 获取退款信息详细信息
     */
    @RequiresPermissions("order:returninfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsRefundInfoService.selectOmsRefundInfoById(id));
    }

    /**
     * 新增退款信息
     */
    @RequiresPermissions("order:returninfo:add")
    @Log(title = "退款信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsRefundInfo omsRefundInfo)
    {
        return toAjax(omsRefundInfoService.insertOmsRefundInfo(omsRefundInfo));
    }

    /**
     * 修改退款信息
     */
    @RequiresPermissions("order:returninfo:edit")
    @Log(title = "退款信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsRefundInfo omsRefundInfo)
    {
        return toAjax(omsRefundInfoService.updateOmsRefundInfo(omsRefundInfo));
    }

    /**
     * 删除退款信息
     */
    @RequiresPermissions("order:returninfo:remove")
    @Log(title = "退款信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsRefundInfoService.deleteOmsRefundInfoByIds(ids));
    }
}
