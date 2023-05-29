import request from '@/utils/request'

// 查询sku信息列表
export function listSkuinfo(query) {
  return request({
    url: '/product/skuinfo/list',
    method: 'get',
    params: query
  })
}

// 查询sku信息详细
export function getSkuinfo(skuId) {
  return request({
    url: '/product/skuinfo/' + skuId,
    method: 'get'
  })
}

// 新增sku信息
export function addSkuinfo(data) {
  return request({
    url: '/product/skuinfo',
    method: 'post',
    data: data
  })
}

// 修改sku信息
export function updateSkuinfo(data) {
  return request({
    url: '/product/skuinfo',
    method: 'put',
    data: data
  })
}

// 删除sku信息
export function delSkuinfo(skuId) {
  return request({
    url: '/product/skuinfo/' + skuId,
    method: 'delete'
  })
}
