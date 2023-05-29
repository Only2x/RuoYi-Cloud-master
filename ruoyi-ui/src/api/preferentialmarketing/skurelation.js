import request from '@/utils/request'

// 查询秒杀活动商品关联列表
export function listSkurelation(query) {
  return request({
    url: '/preferentialmarketing/skurelation/list',
    method: 'get',
    params: query
  })
}

// 查询秒杀活动商品关联详细
export function getSkurelation(id) {
  return request({
    url: '/preferentialmarketing/skurelation/' + id,
    method: 'get'
  })
}

// 新增秒杀活动商品关联
export function addSkurelation(data) {
  return request({
    url: '/preferentialmarketing/skurelation',
    method: 'post',
    data: data
  })
}

// 修改秒杀活动商品关联
export function updateSkurelation(data) {
  return request({
    url: '/preferentialmarketing/skurelation',
    method: 'put',
    data: data
  })
}

// 删除秒杀活动商品关联
export function delSkurelation(id) {
  return request({
    url: '/preferentialmarketing/skurelation/' + id,
    method: 'delete'
  })
}
