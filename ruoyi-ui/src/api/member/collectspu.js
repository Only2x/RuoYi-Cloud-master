import request from '@/utils/request'

// 查询会员收藏的商品列表
export function listCollectspu(query) {
  return request({
    url: '/member/collectspu/list',
    method: 'get',
    params: query
  })
}

// 查询会员收藏的商品详细
export function getCollectspu(id) {
  return request({
    url: '/member/collectspu/' + id,
    method: 'get'
  })
}

// 新增会员收藏的商品
export function addCollectspu(data) {
  return request({
    url: '/member/collectspu',
    method: 'post',
    data: data
  })
}

// 修改会员收藏的商品
export function updateCollectspu(data) {
  return request({
    url: '/member/collectspu',
    method: 'put',
    data: data
  })
}

// 删除会员收藏的商品
export function delCollectspu(id) {
  return request({
    url: '/member/collectspu/' + id,
    method: 'delete'
  })
}
