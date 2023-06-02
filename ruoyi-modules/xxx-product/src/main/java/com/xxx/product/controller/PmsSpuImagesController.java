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
import com.xxx.product.domain.PmsSpuImages;
import com.xxx.product.service.IPmsSpuImagesService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * spu图片Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/spuimages")
public class PmsSpuImagesController extends BaseController
{
    @Autowired
    private IPmsSpuImagesService pmsSpuImagesService;

    /**
     * 查询spu图片列表
     */
    @RequiresPermissions("product:spuimages:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSpuImages pmsSpuImages)
    {
        startPage();
        List<PmsSpuImages> list = pmsSpuImagesService.selectPmsSpuImagesList(pmsSpuImages);
        return getDataTable(list);
    }

    /**
     * 导出spu图片列表
     */
    @RequiresPermissions("product:spuimages:export")
    @Log(title = "spu图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSpuImages pmsSpuImages)
    {
        List<PmsSpuImages> list = pmsSpuImagesService.selectPmsSpuImagesList(pmsSpuImages);
        ExcelUtil<PmsSpuImages> util = new ExcelUtil<PmsSpuImages>(PmsSpuImages.class);
        util.exportExcel(response, list, "spu图片数据");
    }

    /**
     * 获取spu图片详细信息
     */
    @RequiresPermissions("product:spuimages:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsSpuImagesService.selectPmsSpuImagesById(id));
    }

    /**
     * 新增spu图片
     */
    @RequiresPermissions("product:spuimages:add")
    @Log(title = "spu图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSpuImages pmsSpuImages)
    {
        return toAjax(pmsSpuImagesService.insertPmsSpuImages(pmsSpuImages));
    }

    /**
     * 修改spu图片
     */
    @RequiresPermissions("product:spuimages:edit")
    @Log(title = "spu图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSpuImages pmsSpuImages)
    {
        return toAjax(pmsSpuImagesService.updatePmsSpuImages(pmsSpuImages));
    }

    /**
     * 删除spu图片
     */
    @RequiresPermissions("product:spuimages:remove")
    @Log(title = "spu图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsSpuImagesService.deletePmsSpuImagesByIds(ids));
    }
}
