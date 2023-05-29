import request from '@/utils/request'

// 查询采购单详情列表
export function listWmsPurchaseDetail(query) {
  return request({
    url: '/warehouse/wmsPurchaseDetail/list',
    method: 'get',
    params: query
  })
}

// 查询采购单详情详细
export function getWmsPurchaseDetail(id) {
  return request({
    url: '/warehouse/wmsPurchaseDetail/' + id,
    method: 'get'
  })
}

// 新增采购单详情
export function addWmsPurchaseDetail(data) {
  return request({
    url: '/warehouse/wmsPurchaseDetail',
    method: 'post',
    data: data
  })
}

// 修改采购单详情
export function updateWmsPurchaseDetail(data) {
  return request({
    url: '/warehouse/wmsPurchaseDetail',
    method: 'put',
    data: data
  })
}

// 删除采购单详情
export function delWmsPurchaseDetail(id) {
  return request({
    url: '/warehouse/wmsPurchaseDetail/' + id,
    method: 'delete'
  })
}
