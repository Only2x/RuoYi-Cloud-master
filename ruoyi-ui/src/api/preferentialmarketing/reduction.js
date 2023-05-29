import request from '@/utils/request'

// 查询商品满减信息列表
export function listReduction(query) {
  return request({
    url: '/preferentialmarketing/reduction/list',
    method: 'get',
    params: query
  })
}

// 查询商品满减信息详细
export function getReduction(id) {
  return request({
    url: '/preferentialmarketing/reduction/' + id,
    method: 'get'
  })
}

// 新增商品满减信息
export function addReduction(data) {
  return request({
    url: '/preferentialmarketing/reduction',
    method: 'post',
    data: data
  })
}

// 修改商品满减信息
export function updateReduction(data) {
  return request({
    url: '/preferentialmarketing/reduction',
    method: 'put',
    data: data
  })
}

// 删除商品满减信息
export function delReduction(id) {
  return request({
    url: '/preferentialmarketing/reduction/' + id,
    method: 'delete'
  })
}
