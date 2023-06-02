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
import com.xxx.preferentialmarketing.domain.SmsCouponHistory;
import com.xxx.preferentialmarketing.service.ISmsCouponHistoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 优惠券领取历史记录Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/history")
public class SmsCouponHistoryController extends BaseController
{
    @Autowired
    private ISmsCouponHistoryService smsCouponHistoryService;

    /**
     * 查询优惠券领取历史记录列表
     */
    @RequiresPermissions("preferentialmarketing:history:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponHistory smsCouponHistory)
    {
        startPage();
        List<SmsCouponHistory> list = smsCouponHistoryService.selectSmsCouponHistoryList(smsCouponHistory);
        return getDataTable(list);
    }

    /**
     * 导出优惠券领取历史记录列表
     */
    @RequiresPermissions("preferentialmarketing:history:export")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponHistory smsCouponHistory)
    {
        List<SmsCouponHistory> list = smsCouponHistoryService.selectSmsCouponHistoryList(smsCouponHistory);
        ExcelUtil<SmsCouponHistory> util = new ExcelUtil<SmsCouponHistory>(SmsCouponHistory.class);
        util.exportExcel(response, list, "优惠券领取历史记录数据");
    }

    /**
     * 获取优惠券领取历史记录详细信息
     */
    @RequiresPermissions("preferentialmarketing:history:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponHistoryService.selectSmsCouponHistoryById(id));
    }

    /**
     * 新增优惠券领取历史记录
     */
    @RequiresPermissions("preferentialmarketing:history:add")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponHistory smsCouponHistory)
    {
        return toAjax(smsCouponHistoryService.insertSmsCouponHistory(smsCouponHistory));
    }

    /**
     * 修改优惠券领取历史记录
     */
    @RequiresPermissions("preferentialmarketing:history:edit")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponHistory smsCouponHistory)
    {
        return toAjax(smsCouponHistoryService.updateSmsCouponHistory(smsCouponHistory));
    }

    /**
     * 删除优惠券领取历史记录
     */
    @RequiresPermissions("preferentialmarketing:history:remove")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponHistoryService.deleteSmsCouponHistoryByIds(ids));
    }
}
