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
import com.xxx.preferentialmarketing.domain.SmsCouponSpuCategoryRelation;
import com.xxx.preferentialmarketing.service.ISmsCouponSpuCategoryRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 优惠券分类关联Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/categoryrelation")
public class SmsCouponSpuCategoryRelationController extends BaseController
{
    @Autowired
    private ISmsCouponSpuCategoryRelationService smsCouponSpuCategoryRelationService;

    /**
     * 查询优惠券分类关联列表
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        startPage();
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationList(smsCouponSpuCategoryRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券分类关联列表
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:export")
    @Log(title = "优惠券分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationList(smsCouponSpuCategoryRelation);
        ExcelUtil<SmsCouponSpuCategoryRelation> util = new ExcelUtil<SmsCouponSpuCategoryRelation>(SmsCouponSpuCategoryRelation.class);
        util.exportExcel(response, list, "优惠券分类关联数据");
    }

    /**
     * 获取优惠券分类关联详细信息
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationById(id));
    }

    /**
     * 新增优惠券分类关联
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:add")
    @Log(title = "优惠券分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return toAjax(smsCouponSpuCategoryRelationService.insertSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation));
    }

    /**
     * 修改优惠券分类关联
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:edit")
    @Log(title = "优惠券分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return toAjax(smsCouponSpuCategoryRelationService.updateSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation));
    }

    /**
     * 删除优惠券分类关联
     */
    @RequiresPermissions("preferentialmarketing:categoryrelation:remove")
    @Log(title = "优惠券分类关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponSpuCategoryRelationService.deleteSmsCouponSpuCategoryRelationByIds(ids));
    }
}
