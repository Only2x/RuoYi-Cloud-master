import request from '@/utils/request'

// 查询退款信息列表
export function listReturninfo(query) {
  return request({
    url: '/order/returninfo/list',
    method: 'get',
    params: query
  })
}

// 查询退款信息详细
export function getReturninfo(id) {
  return request({
    url: '/order/returninfo/' + id,
    method: 'get'
  })
}

// 新增退款信息
export function addReturninfo(data) {
  return request({
    url: '/order/returninfo',
    method: 'post',
    data: data
  })
}

// 修改退款信息
export function updateReturninfo(data) {
  return request({
    url: '/order/returninfo',
    method: 'put',
    data: data
  })
}

// 删除退款信息
export function delReturninfo(id) {
  return request({
    url: '/order/returninfo/' + id,
    method: 'delete'
  })
}
