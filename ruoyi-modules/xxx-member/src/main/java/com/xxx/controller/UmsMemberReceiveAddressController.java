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
import com.xxx.member.domain.UmsMemberReceiveAddress;
import com.xxx.member.service.IUmsMemberReceiveAddressService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 会员收货地址Controller
 * 
 * @author xxx
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/address")
public class UmsMemberReceiveAddressController extends BaseController
{
    @Autowired
    private IUmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 查询会员收货地址列表
     */
    @RequiresPermissions("member:address:list")
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        startPage();
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        return getDataTable(list);
    }

    /**
     * 导出会员收货地址列表
     */
    @RequiresPermissions("member:address:export")
    @Log(title = "会员收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        ExcelUtil<UmsMemberReceiveAddress> util = new ExcelUtil<UmsMemberReceiveAddress>(UmsMemberReceiveAddress.class);
        util.exportExcel(response, list, "会员收货地址数据");
    }

    /**
     * 获取会员收货地址详细信息
     */
    @RequiresPermissions("member:address:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberReceiveAddressService.selectUmsMemberReceiveAddressById(id));
    }

    /**
     * 新增会员收货地址
     */
    @RequiresPermissions("member:address:add")
    @Log(title = "会员收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        return toAjax(umsMemberReceiveAddressService.insertUmsMemberReceiveAddress(umsMemberReceiveAddress));
    }

    /**
     * 修改会员收货地址
     */
    @RequiresPermissions("member:address:edit")
    @Log(title = "会员收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        return toAjax(umsMemberReceiveAddressService.updateUmsMemberReceiveAddress(umsMemberReceiveAddress));
    }

    /**
     * 删除会员收货地址
     */
    @RequiresPermissions("member:address:remove")
    @Log(title = "会员收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberReceiveAddressService.deleteUmsMemberReceiveAddressByIds(ids));
    }
}
