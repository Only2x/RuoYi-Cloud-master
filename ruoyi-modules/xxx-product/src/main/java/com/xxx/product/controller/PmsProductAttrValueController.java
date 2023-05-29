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
import com.xxx.product.domain.PmsProductAttrValue;
import com.xxx.product.service.IPmsProductAttrValueService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * spu属性值Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/spuvalue")
public class PmsProductAttrValueController extends BaseController
{
    @Autowired
    private IPmsProductAttrValueService pmsProductAttrValueService;

    /**
     * 查询spu属性值列表
     */
    @RequiresPermissions("product:spuvalue:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductAttrValue pmsProductAttrValue)
    {
        startPage();
        List<PmsProductAttrValue> list = pmsProductAttrValueService.selectPmsProductAttrValueList(pmsProductAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出spu属性值列表
     */
    @RequiresPermissions("product:spuvalue:export")
    @Log(title = "spu属性值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductAttrValue pmsProductAttrValue)
    {
        List<PmsProductAttrValue> list = pmsProductAttrValueService.selectPmsProductAttrValueList(pmsProductAttrValue);
        ExcelUtil<PmsProductAttrValue> util = new ExcelUtil<PmsProductAttrValue>(PmsProductAttrValue.class);
        util.exportExcel(response, list, "spu属性值数据");
    }

    /**
     * 获取spu属性值详细信息
     */
    @RequiresPermissions("product:spuvalue:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsProductAttrValueService.selectPmsProductAttrValueById(id));
    }

    /**
     * 新增spu属性值
     */
    @RequiresPermissions("product:spuvalue:add")
    @Log(title = "spu属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductAttrValue pmsProductAttrValue)
    {
        return toAjax(pmsProductAttrValueService.insertPmsProductAttrValue(pmsProductAttrValue));
    }

    /**
     * 修改spu属性值
     */
    @RequiresPermissions("product:spuvalue:edit")
    @Log(title = "spu属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductAttrValue pmsProductAttrValue)
    {
        return toAjax(pmsProductAttrValueService.updatePmsProductAttrValue(pmsProductAttrValue));
    }

    /**
     * 删除spu属性值
     */
    @RequiresPermissions("product:spuvalue:remove")
    @Log(title = "spu属性值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsProductAttrValueService.deletePmsProductAttrValueByIds(ids));
    }
}
