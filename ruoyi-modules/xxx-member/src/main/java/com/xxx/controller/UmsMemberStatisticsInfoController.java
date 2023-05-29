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
import com.xxx.member.domain.UmsMemberStatisticsInfo;
import com.xxx.member.service.IUmsMemberStatisticsInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 会员统计信息Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/info")
public class UmsMemberStatisticsInfoController extends BaseController
{
    @Autowired
    private IUmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /**
     * 查询会员统计信息列表
     */
    @RequiresPermissions("member:info:list")
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        startPage();
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员统计信息列表
     */
    @RequiresPermissions("member:info:export")
    @Log(title = "会员统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        ExcelUtil<UmsMemberStatisticsInfo> util = new ExcelUtil<UmsMemberStatisticsInfo>(UmsMemberStatisticsInfo.class);
        util.exportExcel(response, list, "会员统计信息数据");
    }

    /**
     * 获取会员统计信息详细信息
     */
    @RequiresPermissions("member:info:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoById(id));
    }

    /**
     * 新增会员统计信息
     */
    @RequiresPermissions("member:info:add")
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return toAjax(umsMemberStatisticsInfoService.insertUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    @RequiresPermissions("member:info:edit")
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return toAjax(umsMemberStatisticsInfoService.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    @RequiresPermissions("member:info:remove")
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberStatisticsInfoService.deleteUmsMemberStatisticsInfoByIds(ids));
    }
}
