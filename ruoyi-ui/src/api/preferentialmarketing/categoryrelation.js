import request from '@/utils/request'

// 查询优惠券分类关联列表
export function listCategoryrelation(query) {
  return request({
    url: '/preferentialmarketing/categoryrelation/list',
    method: 'get',
    params: query
  })
}

// 查询优惠券分类关联详细
export function getCategoryrelation(id) {
  return request({
    url: '/preferentialmarketing/categoryrelation/' + id,
    method: 'get'
  })
}

// 新增优惠券分类关联
export function addCategoryrelation(data) {
  return request({
    url: '/preferentialmarketing/categoryrelation',
    method: 'post',
    data: data
  })
}

// 修改优惠券分类关联
export function updateCategoryrelation(data) {
  return request({
    url: '/preferentialmarketing/categoryrelation',
    method: 'put',
    data: data
  })
}

// 删除优惠券分类关联
export function delCategoryrelation(id) {
  return request({
    url: '/preferentialmarketing/categoryrelation/' + id,
    method: 'delete'
  })
}
