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
import com.xxx.product.domain.PmsBrand;
import com.xxx.product.service.IPmsBrandService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController extends BaseController
{
    @Autowired
    private IPmsBrandService pmsBrandService;

    /**
     * 查询品牌列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsBrand pmsBrand)
    {
        startPage();
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @RequiresPermissions("product:brand:export")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsBrand pmsBrand)
    {
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        ExcelUtil<PmsBrand> util = new ExcelUtil<PmsBrand>(PmsBrand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId)
    {
        return success(pmsBrandService.selectPmsBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsBrand pmsBrand)
    {
        return toAjax(pmsBrandService.insertPmsBrand(pmsBrand));
    }

    /**
     * 修改品牌
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsBrand pmsBrand)
    {
        return toAjax(pmsBrandService.updatePmsBrand(pmsBrand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds)
    {
        return toAjax(pmsBrandService.deletePmsBrandByBrandIds(brandIds));
    }
}
