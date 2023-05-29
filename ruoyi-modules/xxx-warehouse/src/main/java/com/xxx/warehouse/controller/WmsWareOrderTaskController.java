package com.xxx.warehouse.controller;

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
import com.xxx.warehouse.domain.WmsWareOrderTask;
import com.xxx.warehouse.service.IWmsWareOrderTaskService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 库存工作单Controller
 * 
 * @author zyf
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/wmsOrderTaskDesc")
public class WmsWareOrderTaskController extends BaseController
{
    @Autowired
    private IWmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 查询库存工作单列表
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareOrderTask wmsWareOrderTask)
    {
        startPage();
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.selectWmsWareOrderTaskList(wmsWareOrderTask);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单列表
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:export")
    @Log(title = "库存工作单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareOrderTask wmsWareOrderTask)
    {
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.selectWmsWareOrderTaskList(wmsWareOrderTask);
        ExcelUtil<WmsWareOrderTask> util = new ExcelUtil<WmsWareOrderTask>(WmsWareOrderTask.class);
        util.exportExcel(response, list, "库存工作单数据");
    }

    /**
     * 获取库存工作单详细信息
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareOrderTaskService.selectWmsWareOrderTaskById(id));
    }

    /**
     * 新增库存工作单
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:add")
    @Log(title = "库存工作单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareOrderTask wmsWareOrderTask)
    {
        return toAjax(wmsWareOrderTaskService.insertWmsWareOrderTask(wmsWareOrderTask));
    }

    /**
     * 修改库存工作单
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:edit")
    @Log(title = "库存工作单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareOrderTask wmsWareOrderTask)
    {
        return toAjax(wmsWareOrderTaskService.updateWmsWareOrderTask(wmsWareOrderTask));
    }

    /**
     * 删除库存工作单
     */
    @RequiresPermissions("warehouse:wmsOrderTaskDesc:remove")
    @Log(title = "库存工作单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareOrderTaskService.deleteWmsWareOrderTaskByIds(ids));
    }
}
