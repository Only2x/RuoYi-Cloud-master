import request from '@/utils/request'

// 查询sku图片列表
export function listSkuimages(query) {
  return request({
    url: '/product/skuimages/list',
    method: 'get',
    params: query
  })
}

// 查询sku图片详细
export function getSkuimages(id) {
  return request({
    url: '/product/skuimages/' + id,
    method: 'get'
  })
}

// 新增sku图片
export function addSkuimages(data) {
  return request({
    url: '/product/skuimages',
    method: 'post',
    data: data
  })
}

// 修改sku图片
export function updateSkuimages(data) {
  return request({
    url: '/product/skuimages',
    method: 'put',
    data: data
  })
}

// 删除sku图片
export function delSkuimages(id) {
  return request({
    url: '/product/skuimages/' + id,
    method: 'delete'
  })
}
