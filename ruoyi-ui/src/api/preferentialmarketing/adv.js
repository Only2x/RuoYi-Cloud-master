import request from '@/utils/request'

// 查询首页轮播广告列表
export function listAdv(query) {
  return request({
    url: '/preferentialmarketing/adv/list',
    method: 'get',
    params: query
  })
}

// 查询首页轮播广告详细
export function getAdv(id) {
  return request({
    url: '/preferentialmarketing/adv/' + id,
    method: 'get'
  })
}

// 新增首页轮播广告
export function addAdv(data) {
  return request({
    url: '/preferentialmarketing/adv',
    method: 'post',
    data: data
  })
}

// 修改首页轮播广告
export function updateAdv(data) {
  return request({
    url: '/preferentialmarketing/adv',
    method: 'put',
    data: data
  })
}

// 删除首页轮播广告
export function delAdv(id) {
  return request({
    url: '/preferentialmarketing/adv/' + id,
    method: 'delete'
  })
}
