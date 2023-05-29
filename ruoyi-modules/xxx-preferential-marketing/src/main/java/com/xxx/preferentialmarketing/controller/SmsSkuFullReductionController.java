package com.xxx.preferentialmarketing.controller;

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
import com.xxx.preferentialmarketing.domain.SmsSkuFullReduction;
import com.xxx.preferentialmarketing.service.ISmsSkuFullReductionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品满减信息Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/reduction")
public class SmsSkuFullReductionController extends BaseController
{
    @Autowired
    private ISmsSkuFullReductionService smsSkuFullReductionService;

    /**
     * 查询商品满减信息列表
     */
    @RequiresPermissions("preferentialmarketing:reduction:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsSkuFullReduction smsSkuFullReduction)
    {
        startPage();
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.selectSmsSkuFullReductionList(smsSkuFullReduction);
        return getDataTable(list);
    }

    /**
     * 导出商品满减信息列表
     */
    @RequiresPermissions("preferentialmarketing:reduction:export")
    @Log(title = "商品满减信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSkuFullReduction smsSkuFullReduction)
    {
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.selectSmsSkuFullReductionList(smsSkuFullReduction);
        ExcelUtil<SmsSkuFullReduction> util = new ExcelUtil<SmsSkuFullReduction>(SmsSkuFullReduction.class);
        util.exportExcel(response, list, "商品满减信息数据");
    }

    /**
     * 获取商品满减信息详细信息
     */
    @RequiresPermissions("preferentialmarketing:reduction:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSkuFullReductionService.selectSmsSkuFullReductionById(id));
    }

    /**
     * 新增商品满减信息
     */
    @RequiresPermissions("preferentialmarketing:reduction:add")
    @Log(title = "商品满减信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSkuFullReduction smsSkuFullReduction)
    {
        return toAjax(smsSkuFullReductionService.insertSmsSkuFullReduction(smsSkuFullReduction));
    }

    /**
     * 修改商品满减信息
     */
    @RequiresPermissions("preferentialmarketing:reduction:edit")
    @Log(title = "商品满减信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSkuFullReduction smsSkuFullReduction)
    {
        return toAjax(smsSkuFullReductionService.updateSmsSkuFullReduction(smsSkuFullReduction));
    }

    /**
     * 删除商品满减信息
     */
    @RequiresPermissions("preferentialmarketing:reduction:remove")
    @Log(title = "商品满减信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSkuFullReductionService.deleteSmsSkuFullReductionByIds(ids));
    }
}
