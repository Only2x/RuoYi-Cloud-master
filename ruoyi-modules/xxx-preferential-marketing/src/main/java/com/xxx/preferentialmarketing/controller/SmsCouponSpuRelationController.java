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
import com.xxx.preferentialmarketing.domain.SmsCouponSpuRelation;
import com.xxx.preferentialmarketing.service.ISmsCouponSpuRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 优惠券与产品关联Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/spurelation")
public class SmsCouponSpuRelationController extends BaseController
{
    @Autowired
    private ISmsCouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 查询优惠券与产品关联列表
     */
    @RequiresPermissions("preferentialmarketing:spurelation:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        startPage();
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券与产品关联列表
     */
    @RequiresPermissions("preferentialmarketing:spurelation:export")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponSpuRelation smsCouponSpuRelation)
    {
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        ExcelUtil<SmsCouponSpuRelation> util = new ExcelUtil<SmsCouponSpuRelation>(SmsCouponSpuRelation.class);
        util.exportExcel(response, list, "优惠券与产品关联数据");
    }

    /**
     * 获取优惠券与产品关联详细信息
     */
    @RequiresPermissions("preferentialmarketing:spurelation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponSpuRelationService.selectSmsCouponSpuRelationById(id));
    }

    /**
     * 新增优惠券与产品关联
     */
    @RequiresPermissions("preferentialmarketing:spurelation:add")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.insertSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     */
    @RequiresPermissions("preferentialmarketing:spurelation:edit")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.updateSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 删除优惠券与产品关联
     */
    @RequiresPermissions("preferentialmarketing:spurelation:remove")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponSpuRelationService.deleteSmsCouponSpuRelationByIds(ids));
    }
}
