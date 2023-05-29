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
import com.xxx.member.domain.UmsIntegrationChangeHistory;
import com.xxx.member.service.IUmsIntegrationChangeHistoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 积分变化历史记录Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/integrationhistory")
public class UmsIntegrationChangeHistoryController extends BaseController
{
    @Autowired
    private IUmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 查询积分变化历史记录列表
     */
    @RequiresPermissions("member:integrationhistory:list")
    @GetMapping("/list")
    public TableDataInfo list(UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        startPage();
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出积分变化历史记录列表
     */
    @RequiresPermissions("member:integrationhistory:export")
    @Log(title = "积分变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        ExcelUtil<UmsIntegrationChangeHistory> util = new ExcelUtil<UmsIntegrationChangeHistory>(UmsIntegrationChangeHistory.class);
        util.exportExcel(response, list, "积分变化历史记录数据");
    }

    /**
     * 获取积分变化历史记录详细信息
     */
    @RequiresPermissions("member:integrationhistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryById(id));
    }

    /**
     * 新增积分变化历史记录
     */
    @RequiresPermissions("member:integrationhistory:add")
    @Log(title = "积分变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return toAjax(umsIntegrationChangeHistoryService.insertUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     */
    @RequiresPermissions("member:integrationhistory:edit")
    @Log(title = "积分变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return toAjax(umsIntegrationChangeHistoryService.updateUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 删除积分变化历史记录
     */
    @RequiresPermissions("member:integrationhistory:remove")
    @Log(title = "积分变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsIntegrationChangeHistoryService.deleteUmsIntegrationChangeHistoryByIds(ids));
    }
}
