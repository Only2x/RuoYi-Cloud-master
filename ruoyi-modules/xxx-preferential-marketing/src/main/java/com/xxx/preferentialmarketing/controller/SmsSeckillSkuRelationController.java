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
import com.xxx.preferentialmarketing.domain.SmsSeckillSkuRelation;
import com.xxx.preferentialmarketing.service.ISmsSeckillSkuRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 秒杀活动商品关联Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/skurelation")
public class SmsSeckillSkuRelationController extends BaseController
{
    @Autowired
    private ISmsSeckillSkuRelationService smsSeckillSkuRelationService;

    /**
     * 查询秒杀活动商品关联列表
     */
    @RequiresPermissions("preferentialmarketing:skurelation:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        startPage();
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.selectSmsSeckillSkuRelationList(smsSeckillSkuRelation);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动商品关联列表
     */
    @RequiresPermissions("preferentialmarketing:skurelation:export")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.selectSmsSeckillSkuRelationList(smsSeckillSkuRelation);
        ExcelUtil<SmsSeckillSkuRelation> util = new ExcelUtil<SmsSeckillSkuRelation>(SmsSeckillSkuRelation.class);
        util.exportExcel(response, list, "秒杀活动商品关联数据");
    }

    /**
     * 获取秒杀活动商品关联详细信息
     */
    @RequiresPermissions("preferentialmarketing:skurelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillSkuRelationService.selectSmsSeckillSkuRelationById(id));
    }

    /**
     * 新增秒杀活动商品关联
     */
    @RequiresPermissions("preferentialmarketing:skurelation:add")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return toAjax(smsSeckillSkuRelationService.insertSmsSeckillSkuRelation(smsSeckillSkuRelation));
    }

    /**
     * 修改秒杀活动商品关联
     */
    @RequiresPermissions("preferentialmarketing:skurelation:edit")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return toAjax(smsSeckillSkuRelationService.updateSmsSeckillSkuRelation(smsSeckillSkuRelation));
    }

    /**
     * 删除秒杀活动商品关联
     */
    @RequiresPermissions("preferentialmarketing:skurelation:remove")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillSkuRelationService.deleteSmsSeckillSkuRelationByIds(ids));
    }
}
