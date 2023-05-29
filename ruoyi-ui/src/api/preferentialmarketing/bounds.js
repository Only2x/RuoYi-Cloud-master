import request from '@/utils/request'

// 查询商品spu积分设置列表
export function listBounds(query) {
  return request({
    url: '/preferentialmarketing/bounds/list',
    method: 'get',
    params: query
  })
}

// 查询商品spu积分设置详细
export function getBounds(id) {
  return request({
    url: '/preferentialmarketing/bounds/' + id,
    method: 'get'
  })
}

// 新增商品spu积分设置
export function addBounds(data) {
  return request({
    url: '/preferentialmarketing/bounds',
    method: 'post',
    data: data
  })
}

// 修改商品spu积分设置
export function updateBounds(data) {
  return request({
    url: '/preferentialmarketing/bounds',
    method: 'put',
    data: data
  })
}

// 删除商品spu积分设置
export function delBounds(id) {
  return request({
    url: '/preferentialmarketing/bounds/' + id,
    method: 'delete'
  })
}
