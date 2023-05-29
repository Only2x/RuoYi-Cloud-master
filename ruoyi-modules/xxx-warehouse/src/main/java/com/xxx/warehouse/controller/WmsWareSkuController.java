package com.xxx.warehouse.controller;

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
import com.xxx.warehouse.domain.WmsWareSku;
import com.xxx.warehouse.service.IWmsWareSkuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品库存Controller
 * 
 * @author zyf
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/wmsSku")
public class WmsWareSkuController extends BaseController
{
    @Autowired
    private IWmsWareSkuService wmsWareSkuService;

    /**
     * 查询商品库存列表
     */
    @RequiresPermissions("warehouse:wmsSku:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareSku wmsWareSku)
    {
        startPage();
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        return getDataTable(list);
    }

    /**
     * 导出商品库存列表
     */
    @RequiresPermissions("warehouse:wmsSku:export")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareSku wmsWareSku)
    {
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        ExcelUtil<WmsWareSku> util = new ExcelUtil<WmsWareSku>(WmsWareSku.class);
        util.exportExcel(response, list, "商品库存数据");
    }

    /**
     * 获取商品库存详细信息
     */
    @RequiresPermissions("warehouse:wmsSku:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareSkuService.selectWmsWareSkuById(id));
    }

    /**
     * 新增商品库存
     */
    @RequiresPermissions("warehouse:wmsSku:add")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareSku wmsWareSku)
    {
        return toAjax(wmsWareSkuService.insertWmsWareSku(wmsWareSku));
    }

    /**
     * 修改商品库存
     */
    @RequiresPermissions("warehouse:wmsSku:edit")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareSku wmsWareSku)
    {
        return toAjax(wmsWareSkuService.updateWmsWareSku(wmsWareSku));
    }

    /**
     * 删除商品库存
     */
    @RequiresPermissions("warehouse:wmsSku:remove")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareSkuService.deleteWmsWareSkuByIds(ids));
    }
}
