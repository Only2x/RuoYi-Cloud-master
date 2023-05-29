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
import com.xxx.preferentialmarketing.domain.SmsSkuLadder;
import com.xxx.preferentialmarketing.service.ISmsSkuLadderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品阶梯价格Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/ladder")
public class SmsSkuLadderController extends BaseController
{
    @Autowired
    private ISmsSkuLadderService smsSkuLadderService;

    /**
     * 查询商品阶梯价格列表
     */
    @RequiresPermissions("preferentialmarketing:ladder:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsSkuLadder smsSkuLadder)
    {
        startPage();
        List<SmsSkuLadder> list = smsSkuLadderService.selectSmsSkuLadderList(smsSkuLadder);
        return getDataTable(list);
    }

    /**
     * 导出商品阶梯价格列表
     */
    @RequiresPermissions("preferentialmarketing:ladder:export")
    @Log(title = "商品阶梯价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSkuLadder smsSkuLadder)
    {
        List<SmsSkuLadder> list = smsSkuLadderService.selectSmsSkuLadderList(smsSkuLadder);
        ExcelUtil<SmsSkuLadder> util = new ExcelUtil<SmsSkuLadder>(SmsSkuLadder.class);
        util.exportExcel(response, list, "商品阶梯价格数据");
    }

    /**
     * 获取商品阶梯价格详细信息
     */
    @RequiresPermissions("preferentialmarketing:ladder:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSkuLadderService.selectSmsSkuLadderById(id));
    }

    /**
     * 新增商品阶梯价格
     */
    @RequiresPermissions("preferentialmarketing:ladder:add")
    @Log(title = "商品阶梯价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSkuLadder smsSkuLadder)
    {
        return toAjax(smsSkuLadderService.insertSmsSkuLadder(smsSkuLadder));
    }

    /**
     * 修改商品阶梯价格
     */
    @RequiresPermissions("preferentialmarketing:ladder:edit")
    @Log(title = "商品阶梯价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSkuLadder smsSkuLadder)
    {
        return toAjax(smsSkuLadderService.updateSmsSkuLadder(smsSkuLadder));
    }

    /**
     * 删除商品阶梯价格
     */
    @RequiresPermissions("preferentialmarketing:ladder:remove")
    @Log(title = "商品阶梯价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSkuLadderService.deleteSmsSkuLadderByIds(ids));
    }
}
