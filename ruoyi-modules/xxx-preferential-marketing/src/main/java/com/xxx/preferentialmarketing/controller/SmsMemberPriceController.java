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
import com.xxx.preferentialmarketing.domain.SmsMemberPrice;
import com.xxx.preferentialmarketing.service.ISmsMemberPriceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品会员价格Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/price")
public class SmsMemberPriceController extends BaseController
{
    @Autowired
    private ISmsMemberPriceService smsMemberPriceService;

    /**
     * 查询商品会员价格列表
     */
    @RequiresPermissions("preferentialmarketing:price:list")
    @GetMapping("/list")
    public TableDataInfo list(SmsMemberPrice smsMemberPrice)
    {
        startPage();
        List<SmsMemberPrice> list = smsMemberPriceService.selectSmsMemberPriceList(smsMemberPrice);
        return getDataTable(list);
    }

    /**
     * 导出商品会员价格列表
     */
    @RequiresPermissions("preferentialmarketing:price:export")
    @Log(title = "商品会员价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsMemberPrice smsMemberPrice)
    {
        List<SmsMemberPrice> list = smsMemberPriceService.selectSmsMemberPriceList(smsMemberPrice);
        ExcelUtil<SmsMemberPrice> util = new ExcelUtil<SmsMemberPrice>(SmsMemberPrice.class);
        util.exportExcel(response, list, "商品会员价格数据");
    }

    /**
     * 获取商品会员价格详细信息
     */
    @RequiresPermissions("preferentialmarketing:price:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsMemberPriceService.selectSmsMemberPriceById(id));
    }

    /**
     * 新增商品会员价格
     */
    @RequiresPermissions("preferentialmarketing:price:add")
    @Log(title = "商品会员价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsMemberPrice smsMemberPrice)
    {
        return toAjax(smsMemberPriceService.insertSmsMemberPrice(smsMemberPrice));
    }

    /**
     * 修改商品会员价格
     */
    @RequiresPermissions("preferentialmarketing:price:edit")
    @Log(title = "商品会员价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsMemberPrice smsMemberPrice)
    {
        return toAjax(smsMemberPriceService.updateSmsMemberPrice(smsMemberPrice));
    }

    /**
     * 删除商品会员价格
     */
    @RequiresPermissions("preferentialmarketing:price:remove")
    @Log(title = "商品会员价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsMemberPriceService.deleteSmsMemberPriceByIds(ids));
    }
}
