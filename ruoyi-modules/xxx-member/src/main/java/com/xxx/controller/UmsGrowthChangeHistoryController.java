package com.xxx.member.controller;

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
import com.xxx.member.domain.UmsGrowthChangeHistory;
import com.xxx.member.service.IUmsGrowthChangeHistoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 成长值变化历史记录Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/growthhistory")
public class UmsGrowthChangeHistoryController extends BaseController
{
    @Autowired
    private IUmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
     * 查询成长值变化历史记录列表
     */
    @RequiresPermissions("member:growthhistory:list")
    @GetMapping("/list")
    public TableDataInfo list(UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        startPage();
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出成长值变化历史记录列表
     */
    @RequiresPermissions("member:growthhistory:export")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
        ExcelUtil<UmsGrowthChangeHistory> util = new ExcelUtil<UmsGrowthChangeHistory>(UmsGrowthChangeHistory.class);
        util.exportExcel(response, list, "成长值变化历史记录数据");
    }

    /**
     * 获取成长值变化历史记录详细信息
     */
    @RequiresPermissions("member:growthhistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryById(id));
    }

    /**
     * 新增成长值变化历史记录
     */
    @RequiresPermissions("member:growthhistory:add")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        return toAjax(umsGrowthChangeHistoryService.insertUmsGrowthChangeHistory(umsGrowthChangeHistory));
    }

    /**
     * 修改成长值变化历史记录
     */
    @RequiresPermissions("member:growthhistory:edit")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        return toAjax(umsGrowthChangeHistoryService.updateUmsGrowthChangeHistory(umsGrowthChangeHistory));
    }

    /**
     * 删除成长值变化历史记录
     */
    @RequiresPermissions("member:growthhistory:remove")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsGrowthChangeHistoryService.deleteUmsGrowthChangeHistoryByIds(ids));
    }
}
