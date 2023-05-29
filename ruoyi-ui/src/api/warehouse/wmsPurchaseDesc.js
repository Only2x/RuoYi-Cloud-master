import request from '@/utils/request'

// 查询采购信息列表
export function listWmsPurchaseDesc(query) {
  return request({
    url: '/warehouse/wmsPurchaseDesc/list',
    method: 'get',
    params: query
  })
}

// 查询采购信息详细
export function getWmsPurchaseDesc(id) {
  return request({
    url: '/warehouse/wmsPurchaseDesc/' + id,
    method: 'get'
  })
}

// 新增采购信息
export function addWmsPurchaseDesc(data) {
  return request({
    url: '/warehouse/wmsPurchaseDesc',
    method: 'post',
    data: data
  })
}

// 修改采购信息
export function updateWmsPurchaseDesc(data) {
  return request({
    url: '/warehouse/wmsPurchaseDesc',
    method: 'put',
    data: data
  })
}

// 删除采购信息
export function delWmsPurchaseDesc(id) {
  return request({
    url: '/warehouse/wmsPurchaseDesc/' + id,
    method: 'delete'
  })
}
