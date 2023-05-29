import request from '@/utils/request'

// 查询退货原因列表
export function listReason(query) {
  return request({
    url: '/order/reason/list',
    method: 'get',
    params: query
  })
}

// 查询退货原因详细
export function getReason(id) {
  return request({
    url: '/order/reason/' + id,
    method: 'get'
  })
}

// 新增退货原因
export function addReason(data) {
  return request({
    url: '/order/reason',
    method: 'post',
    data: data
  })
}

// 修改退货原因
export function updateReason(data) {
  return request({
    url: '/order/reason',
    method: 'put',
    data: data
  })
}

// 删除退货原因
export function delReason(id) {
  return request({
    url: '/order/reason/' + id,
    method: 'delete'
  })
}
