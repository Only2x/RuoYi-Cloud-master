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
import com.xxx.product.domain.PmsSkuImages;
import com.xxx.product.service.IPmsSkuImagesService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * sku图片Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/skuimages")
public class PmsSkuImagesController extends BaseController
{
    @Autowired
    private IPmsSkuImagesService pmsSkuImagesService;

    /**
     * 查询sku图片列表
     */
    @RequiresPermissions("product:skuimages:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSkuImages pmsSkuImages)
    {
        startPage();
        List<PmsSkuImages> list = pmsSkuImagesService.selectPmsSkuImagesList(pmsSkuImages);
        return getDataTable(list);
    }

    /**
     * 导出sku图片列表
     */
    @RequiresPermissions("product:skuimages:export")
    @Log(title = "sku图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSkuImages pmsSkuImages)
    {
        List<PmsSkuImages> list = pmsSkuImagesService.selectPmsSkuImagesList(pmsSkuImages);
        ExcelUtil<PmsSkuImages> util = new ExcelUtil<PmsSkuImages>(PmsSkuImages.class);
        util.exportExcel(response, list, "sku图片数据");
    }

    /**
     * 获取sku图片详细信息
     */
    @RequiresPermissions("product:skuimages:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsSkuImagesService.selectPmsSkuImagesById(id));
    }

    /**
     * 新增sku图片
     */
    @RequiresPermissions("product:skuimages:add")
    @Log(title = "sku图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSkuImages pmsSkuImages)
    {
        return toAjax(pmsSkuImagesService.insertPmsSkuImages(pmsSkuImages));
    }

    /**
     * 修改sku图片
     */
    @RequiresPermissions("product:skuimages:edit")
    @Log(title = "sku图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSkuImages pmsSkuImages)
    {
        return toAjax(pmsSkuImagesService.updatePmsSkuImages(pmsSkuImages));
    }

    /**
     * 删除sku图片
     */
    @RequiresPermissions("product:skuimages:remove")
    @Log(title = "sku图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsSkuImagesService.deletePmsSkuImagesByIds(ids));
    }
}
