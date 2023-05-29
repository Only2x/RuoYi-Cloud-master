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
import com.xxx.preferentialmarketing.domain.SmsSpuBounds;
import com.xxx.preferentialmarketing.service.ISmsSpuBoundsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品spu积分设置Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/bounds")
public class SmsSpuBoundsController extends BaseController
{
    @Autowired
    private ISmsSpuBoundsService smsSpuBoundsService;

    /**
     * 查询商品spu积分设置列表
     */
    @RequiresPermissions("preferentialmarketing:bounds:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsSpuBounds smsSpuBounds)
    {
        startPage();
        List<SmsSpuBounds> list = smsSpuBoundsService.selectSmsSpuBoundsList(smsSpuBounds);
        return getDataTable(list);
    }

    /**
     * 导出商品spu积分设置列表
     */
    @RequiresPermissions("preferentialmarketing:bounds:export")
    @Log(title = "商品spu积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSpuBounds smsSpuBounds)
    {
        List<SmsSpuBounds> list = smsSpuBoundsService.selectSmsSpuBoundsList(smsSpuBounds);
        ExcelUtil<SmsSpuBounds> util = new ExcelUtil<SmsSpuBounds>(SmsSpuBounds.class);
        util.exportExcel(response, list, "商品spu积分设置数据");
    }

    /**
     * 获取商品spu积分设置详细信息
     */
    @RequiresPermissions("preferentialmarketing:bounds:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSpuBoundsService.selectSmsSpuBoundsById(id));
    }

    /**
     * 新增商品spu积分设置
     */
    @RequiresPermissions("preferentialmarketing:bounds:add")
    @Log(title = "商品spu积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSpuBounds smsSpuBounds)
    {
        return toAjax(smsSpuBoundsService.insertSmsSpuBounds(smsSpuBounds));
    }

    /**
     * 修改商品spu积分设置
     */
    @RequiresPermissions("preferentialmarketing:bounds:edit")
    @Log(title = "商品spu积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSpuBounds smsSpuBounds)
    {
        return toAjax(smsSpuBoundsService.updateSmsSpuBounds(smsSpuBounds));
    }

    /**
     * 删除商品spu积分设置
     */
    @RequiresPermissions("preferentialmarketing:bounds:remove")
    @Log(title = "商品spu积分设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSpuBoundsService.deleteSmsSpuBoundsByIds(ids));
    }
}
