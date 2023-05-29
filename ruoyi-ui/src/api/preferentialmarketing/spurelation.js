import request from '@/utils/request'

// 查询优惠券与产品关联列表
export function listSpurelation(query) {
  return request({
    url: '/preferentialmarketing/spurelation/list',
    method: 'get',
    params: query
  })
}

// 查询优惠券与产品关联详细
export function getSpurelation(id) {
  return request({
    url: '/preferentialmarketing/spurelation/' + id,
    method: 'get'
  })
}

// 新增优惠券与产品关联
export function addSpurelation(data) {
  return request({
    url: '/preferentialmarketing/spurelation',
    method: 'post',
    data: data
  })
}

// 修改优惠券与产品关联
export function updateSpurelation(data) {
  return request({
    url: '/preferentialmarketing/spurelation',
    method: 'put',
    data: data
  })
}

// 删除优惠券与产品关联
export function delSpurelation(id) {
  return request({
    url: '/preferentialmarketing/spurelation/' + id,
    method: 'delete'
  })
}
