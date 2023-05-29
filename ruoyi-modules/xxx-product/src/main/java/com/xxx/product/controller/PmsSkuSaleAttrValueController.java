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
import com.xxx.product.domain.PmsSkuSaleAttrValue;
import com.xxx.product.service.IPmsSkuSaleAttrValueService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * sku销售属性&值Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/skuvalue")
public class PmsSkuSaleAttrValueController extends BaseController
{
    @Autowired
    private IPmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @RequiresPermissions("product:skuvalue:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        startPage();
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueList(pmsSkuSaleAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出sku销售属性&值列表
     */
    @RequiresPermissions("product:skuvalue:export")
    @Log(title = "sku销售属性&值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueList(pmsSkuSaleAttrValue);
        ExcelUtil<PmsSkuSaleAttrValue> util = new ExcelUtil<PmsSkuSaleAttrValue>(PmsSkuSaleAttrValue.class);
        util.exportExcel(response, list, "sku销售属性&值数据");
    }

    /**
     * 获取sku销售属性&值详细信息
     */
    @RequiresPermissions("product:skuvalue:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @RequiresPermissions("product:skuvalue:add")
    @Log(title = "sku销售属性&值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        return toAjax(pmsSkuSaleAttrValueService.insertPmsSkuSaleAttrValue(pmsSkuSaleAttrValue));
    }

    /**
     * 修改sku销售属性&值
     */
    @RequiresPermissions("product:skuvalue:edit")
    @Log(title = "sku销售属性&值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        return toAjax(pmsSkuSaleAttrValueService.updatePmsSkuSaleAttrValue(pmsSkuSaleAttrValue));
    }

    /**
     * 删除sku销售属性&值
     */
    @RequiresPermissions("product:skuvalue:remove")
    @Log(title = "sku销售属性&值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsSkuSaleAttrValueService.deletePmsSkuSaleAttrValueByIds(ids));
    }
}
