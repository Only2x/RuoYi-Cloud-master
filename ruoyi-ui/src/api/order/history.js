import request from '@/utils/request'

// 查询订单操作历史记录列表
export function listHistory(query) {
  return request({
    url: '/order/history/list',
    method: 'get',
    params: query
  })
}

// 查询订单操作历史记录详细
export function getHistory(id) {
  return request({
    url: '/order/history/' + id,
    method: 'get'
  })
}

// 新增订单操作历史记录
export function addHistory(data) {
  return request({
    url: '/order/history',
    method: 'post',
    data: data
  })
}

// 修改订单操作历史记录
export function updateHistory(data) {
  return request({
    url: '/order/history',
    method: 'put',
    data: data
  })
}

// 删除订单操作历史记录
export function delHistory(id) {
  return request({
    url: '/order/history/' + id,
    method: 'delete'
  })
}
