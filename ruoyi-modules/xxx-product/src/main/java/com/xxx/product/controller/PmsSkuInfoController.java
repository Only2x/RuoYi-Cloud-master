package com.xxx.product.controller;

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
import com.xxx.product.domain.PmsSkuInfo;
import com.xxx.product.service.IPmsSkuInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * sku信息Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/skuinfo")
public class PmsSkuInfoController extends BaseController
{
    @Autowired
    private IPmsSkuInfoService pmsSkuInfoService;

    /**
     * 查询sku信息列表
     */
    @RequiresPermissions("product:skuinfo:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSkuInfo pmsSkuInfo)
    {
        startPage();
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        return getDataTable(list);
    }

    /**
     * 导出sku信息列表
     */
    @RequiresPermissions("product:skuinfo:export")
    @Log(title = "sku信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSkuInfo pmsSkuInfo)
    {
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        ExcelUtil<PmsSkuInfo> util = new ExcelUtil<PmsSkuInfo>(PmsSkuInfo.class);
        util.exportExcel(response, list, "sku信息数据");
    }

    /**
     * 获取sku信息详细信息
     */
    @RequiresPermissions("product:skuinfo:query")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId)
    {
        return success(pmsSkuInfoService.selectPmsSkuInfoBySkuId(skuId));
    }

    /**
     * 新增sku信息
     */
    @RequiresPermissions("product:skuinfo:add")
    @Log(title = "sku信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSkuInfo pmsSkuInfo)
    {
        return toAjax(pmsSkuInfoService.insertPmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 修改sku信息
     */
    @RequiresPermissions("product:skuinfo:edit")
    @Log(title = "sku信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSkuInfo pmsSkuInfo)
    {
        return toAjax(pmsSkuInfoService.updatePmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 删除sku信息
     */
    @RequiresPermissions("product:skuinfo:remove")
    @Log(title = "sku信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds)
    {
        return toAjax(pmsSkuInfoService.deletePmsSkuInfoBySkuIds(skuIds));
    }
}
