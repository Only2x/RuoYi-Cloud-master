import request from '@/utils/request'

// 查询sku销售属性&值列表
export function listSkuvalue(query) {
  return request({
    url: '/product/skuvalue/list',
    method: 'get',
    params: query
  })
}

// 查询sku销售属性&值详细
export function getSkuvalue(id) {
  return request({
    url: '/product/skuvalue/' + id,
    method: 'get'
  })
}

// 新增sku销售属性&值
export function addSkuvalue(data) {
  return request({
    url: '/product/skuvalue',
    method: 'post',
    data: data
  })
}

// 修改sku销售属性&值
export function updateSkuvalue(data) {
  return request({
    url: '/product/skuvalue',
    method: 'put',
    data: data
  })
}

// 删除sku销售属性&值
export function delSkuvalue(id) {
  return request({
    url: '/product/skuvalue/' + id,
    method: 'delete'
  })
}
