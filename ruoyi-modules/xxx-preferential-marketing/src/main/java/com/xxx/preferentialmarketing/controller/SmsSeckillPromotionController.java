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
import com.xxx.preferentialmarketing.domain.SmsSeckillPromotion;
import com.xxx.preferentialmarketing.service.ISmsSeckillPromotionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 秒杀活动Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/promotion")
public class SmsSeckillPromotionController extends BaseController
{
    @Autowired
    private ISmsSeckillPromotionService smsSeckillPromotionService;

    /**
     * 查询秒杀活动列表
     */
    @RequiresPermissions("preferentialmarketing:promotion:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillPromotion smsSeckillPromotion)
    {
        startPage();
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.selectSmsSeckillPromotionList(smsSeckillPromotion);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动列表
     */
    @RequiresPermissions("preferentialmarketing:promotion:export")
    @Log(title = "秒杀活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillPromotion smsSeckillPromotion)
    {
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.selectSmsSeckillPromotionList(smsSeckillPromotion);
        ExcelUtil<SmsSeckillPromotion> util = new ExcelUtil<SmsSeckillPromotion>(SmsSeckillPromotion.class);
        util.exportExcel(response, list, "秒杀活动数据");
    }

    /**
     * 获取秒杀活动详细信息
     */
    @RequiresPermissions("preferentialmarketing:promotion:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillPromotionService.selectSmsSeckillPromotionById(id));
    }

    /**
     * 新增秒杀活动
     */
    @RequiresPermissions("preferentialmarketing:promotion:add")
    @Log(title = "秒杀活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillPromotion smsSeckillPromotion)
    {
        return toAjax(smsSeckillPromotionService.insertSmsSeckillPromotion(smsSeckillPromotion));
    }

    /**
     * 修改秒杀活动
     */
    @RequiresPermissions("preferentialmarketing:promotion:edit")
    @Log(title = "秒杀活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillPromotion smsSeckillPromotion)
    {
        return toAjax(smsSeckillPromotionService.updateSmsSeckillPromotion(smsSeckillPromotion));
    }

    /**
     * 删除秒杀活动
     */
    @RequiresPermissions("preferentialmarketing:promotion:remove")
    @Log(title = "秒杀活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillPromotionService.deleteSmsSeckillPromotionByIds(ids));
    }
}
