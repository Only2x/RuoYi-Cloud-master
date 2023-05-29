import request from '@/utils/request'

// 查询优惠券信息列表
export function listCoupon(query) {
  return request({
    url: '/preferentialmarketing/coupon/list',
    method: 'get',
    params: query
  })
}

// 查询优惠券信息详细
export function getCoupon(id) {
  return request({
    url: '/preferentialmarketing/coupon/' + id,
    method: 'get'
  })
}

// 新增优惠券信息
export function addCoupon(data) {
  return request({
    url: '/preferentialmarketing/coupon',
    method: 'post',
    data: data
  })
}

// 修改优惠券信息
export function updateCoupon(data) {
  return request({
    url: '/preferentialmarketing/coupon',
    method: 'put',
    data: data
  })
}

// 删除优惠券信息
export function delCoupon(id) {
  return request({
    url: '/preferentialmarketing/coupon/' + id,
    method: 'delete'
  })
}
