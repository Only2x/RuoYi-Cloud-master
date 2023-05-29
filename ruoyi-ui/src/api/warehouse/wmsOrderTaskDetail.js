import request from '@/utils/request'

// 查询库存工作单详情列表
export function listWmsOrderTaskDetail(query) {
  return request({
    url: '/warehouse/wmsOrderTaskDetail/list',
    method: 'get',
    params: query
  })
}

// 查询库存工作单详情详细
export function getWmsOrderTaskDetail(id) {
  return request({
    url: '/warehouse/wmsOrderTaskDetail/' + id,
    method: 'get'
  })
}

// 新增库存工作单详情
export function addWmsOrderTaskDetail(data) {
  return request({
    url: '/warehouse/wmsOrderTaskDetail',
    method: 'post',
    data: data
  })
}

// 修改库存工作单详情
export function updateWmsOrderTaskDetail(data) {
  return request({
    url: '/warehouse/wmsOrderTaskDetail',
    method: 'put',
    data: data
  })
}

// 删除库存工作单详情
export function delWmsOrderTaskDetail(id) {
  return request({
    url: '/warehouse/wmsOrderTaskDetail/' + id,
    method: 'delete'
  })
}
