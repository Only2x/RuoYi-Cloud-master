import request from '@/utils/request'

// 查询品牌分类关联列表
export function listBrandrelation(query) {
  return request({
    url: '/product/brandrelation/list',
    method: 'get',
    params: query
  })
}

// 查询品牌分类关联详细
export function getBrandrelation(id) {
  return request({
    url: '/product/brandrelation/' + id,
    method: 'get'
  })
}

// 新增品牌分类关联
export function addBrandrelation(data) {
  return request({
    url: '/product/brandrelation',
    method: 'post',
    data: data
  })
}

// 修改品牌分类关联
export function updateBrandrelation(data) {
  return request({
    url: '/product/brandrelation',
    method: 'put',
    data: data
  })
}

// 删除品牌分类关联
export function delBrandrelation(id) {
  return request({
    url: '/product/brandrelation/' + id,
    method: 'delete'
  })
}
