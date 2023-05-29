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
import com.xxx.preferentialmarketing.domain.SmsHomeAdv;
import com.xxx.preferentialmarketing.service.ISmsHomeAdvService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 首页轮播广告Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/adv")
public class SmsHomeAdvController extends BaseController
{
    @Autowired
    private ISmsHomeAdvService smsHomeAdvService;

    /**
     * 查询首页轮播广告列表
     */
    @RequiresPermissions("preferentialmarketing:adv:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsHomeAdv smsHomeAdv)
    {
        startPage();
        List<SmsHomeAdv> list = smsHomeAdvService.selectSmsHomeAdvList(smsHomeAdv);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播广告列表
     */
    @RequiresPermissions("preferentialmarketing:adv:export")
    @Log(title = "首页轮播广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsHomeAdv smsHomeAdv)
    {
        List<SmsHomeAdv> list = smsHomeAdvService.selectSmsHomeAdvList(smsHomeAdv);
        ExcelUtil<SmsHomeAdv> util = new ExcelUtil<SmsHomeAdv>(SmsHomeAdv.class);
        util.exportExcel(response, list, "首页轮播广告数据");
    }

    /**
     * 获取首页轮播广告详细信息
     */
    @RequiresPermissions("preferentialmarketing:adv:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsHomeAdvService.selectSmsHomeAdvById(id));
    }

    /**
     * 新增首页轮播广告
     */
    @RequiresPermissions("preferentialmarketing:adv:add")
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsHomeAdv smsHomeAdv)
    {
        return toAjax(smsHomeAdvService.insertSmsHomeAdv(smsHomeAdv));
    }

    /**
     * 修改首页轮播广告
     */
    @RequiresPermissions("preferentialmarketing:adv:edit")
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsHomeAdv smsHomeAdv)
    {
        return toAjax(smsHomeAdvService.updateSmsHomeAdv(smsHomeAdv));
    }

    /**
     * 删除首页轮播广告
     */
    @RequiresPermissions("preferentialmarketing:adv:remove")
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsHomeAdvService.deleteSmsHomeAdvByIds(ids));
    }
}
