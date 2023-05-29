import request from '@/utils/request'

// 查询spu信息列表
export function listSpuinfo(query) {
  return request({
    url: '/product/spuinfo/list',
    method: 'get',
    params: query
  })
}

// 查询spu信息详细
export function getSpuinfo(id) {
  return request({
    url: '/product/spuinfo/' + id,
    method: 'get'
  })
}

// 新增spu信息
export function addSpuinfo(data) {
  return request({
    url: '/product/spuinfo',
    method: 'post',
    data: data
  })
}

// 修改spu信息
export function updateSpuinfo(data) {
  return request({
    url: '/product/spuinfo',
    method: 'put',
    data: data
  })
}

// 删除spu信息
export function delSpuinfo(id) {
  return request({
    url: '/product/spuinfo/' + id,
    method: 'delete'
  })
}
