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
import com.xxx.product.domain.PmsSpuInfo;
import com.xxx.product.service.IPmsSpuInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * spu信息Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/spuinfo")
public class PmsSpuInfoController extends BaseController
{
    @Autowired
    private IPmsSpuInfoService pmsSpuInfoService;

    /**
     * 查询spu信息列表
     */
    @RequiresPermissions("product:spuinfo:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSpuInfo pmsSpuInfo)
    {
        startPage();
        List<PmsSpuInfo> list = pmsSpuInfoService.selectPmsSpuInfoList(pmsSpuInfo);
        return getDataTable(list);
    }

    /**
     * 导出spu信息列表
     */
    @RequiresPermissions("product:spuinfo:export")
    @Log(title = "spu信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSpuInfo pmsSpuInfo)
    {
        List<PmsSpuInfo> list = pmsSpuInfoService.selectPmsSpuInfoList(pmsSpuInfo);
        ExcelUtil<PmsSpuInfo> util = new ExcelUtil<PmsSpuInfo>(PmsSpuInfo.class);
        util.exportExcel(response, list, "spu信息数据");
    }

    /**
     * 获取spu信息详细信息
     */
    @RequiresPermissions("product:spuinfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsSpuInfoService.selectPmsSpuInfoById(id));
    }

    /**
     * 新增spu信息
     */
    @RequiresPermissions("product:spuinfo:add")
    @Log(title = "spu信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSpuInfo pmsSpuInfo)
    {
        return toAjax(pmsSpuInfoService.insertPmsSpuInfo(pmsSpuInfo));
    }

    /**
     * 修改spu信息
     */
    @RequiresPermissions("product:spuinfo:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSpuInfo pmsSpuInfo)
    {
        return toAjax(pmsSpuInfoService.updatePmsSpuInfo(pmsSpuInfo));
    }

    /**
     * 删除spu信息
     */
    @RequiresPermissions("product:spuinfo:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsSpuInfoService.deletePmsSpuInfoByIds(ids));
    }
}
