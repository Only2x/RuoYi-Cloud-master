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
import com.xxx.preferentialmarketing.domain.SmsCoupon;
import com.xxx.preferentialmarketing.service.ISmsCouponService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 优惠券信息Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/coupon")
public class SmsCouponController extends BaseController
{
    @Autowired
    private ISmsCouponService smsCouponService;

    /**
     * 查询优惠券信息列表
     */
    @RequiresPermissions("preferentialmarketing:coupon:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsCoupon smsCoupon)
    {
        startPage();
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠券信息列表
     */
    @RequiresPermissions("preferentialmarketing:coupon:export")
    @Log(title = "优惠券信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCoupon smsCoupon)
    {
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        ExcelUtil<SmsCoupon> util = new ExcelUtil<SmsCoupon>(SmsCoupon.class);
        util.exportExcel(response, list, "优惠券信息数据");
    }

    /**
     * 获取优惠券信息详细信息
     */
    @RequiresPermissions("preferentialmarketing:coupon:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponService.selectSmsCouponById(id));
    }

    /**
     * 新增优惠券信息
     */
    @RequiresPermissions("preferentialmarketing:coupon:add")
    @Log(title = "优惠券信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.insertSmsCoupon(smsCoupon));
    }

    /**
     * 修改优惠券信息
     */
    @RequiresPermissions("preferentialmarketing:coupon:edit")
    @Log(title = "优惠券信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.updateSmsCoupon(smsCoupon));
    }

    /**
     * 删除优惠券信息
     */
    @RequiresPermissions("preferentialmarketing:coupon:remove")
    @Log(title = "优惠券信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponService.deleteSmsCouponByIds(ids));
    }
}
