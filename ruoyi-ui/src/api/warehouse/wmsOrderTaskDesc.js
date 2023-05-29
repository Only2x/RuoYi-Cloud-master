import request from '@/utils/request'

// 查询库存工作单列表
export function listWmsOrderTaskDesc(query) {
  return request({
    url: '/warehouse/wmsOrderTaskDesc/list',
    method: 'get',
    params: query
  })
}

// 查询库存工作单详细
export function getWmsOrderTaskDesc(id) {
  return request({
    url: '/warehouse/wmsOrderTaskDesc/' + id,
    method: 'get'
  })
}

// 新增库存工作单
export function addWmsOrderTaskDesc(data) {
  return request({
    url: '/warehouse/wmsOrderTaskDesc',
    method: 'post',
    data: data
  })
}

// 修改库存工作单
export function updateWmsOrderTaskDesc(data) {
  return request({
    url: '/warehouse/wmsOrderTaskDesc',
    method: 'put',
    data: data
  })
}

// 删除库存工作单
export function delWmsOrderTaskDesc(id) {
  return request({
    url: '/warehouse/wmsOrderTaskDesc/' + id,
    method: 'delete'
  })
}
