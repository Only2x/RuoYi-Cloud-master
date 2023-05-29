import request from '@/utils/request'

// 查询spu信息介绍列表
export function listSpudesc(query) {
  return request({
    url: '/product/spudesc/list',
    method: 'get',
    params: query
  })
}

// 查询spu信息介绍详细
export function getSpudesc(spuId) {
  return request({
    url: '/product/spudesc/' + spuId,
    method: 'get'
  })
}

// 新增spu信息介绍
export function addSpudesc(data) {
  return request({
    url: '/product/spudesc',
    method: 'post',
    data: data
  })
}

// 修改spu信息介绍
export function updateSpudesc(data) {
  return request({
    url: '/product/spudesc',
    method: 'put',
    data: data
  })
}

// 删除spu信息介绍
export function delSpudesc(spuId) {
  return request({
    url: '/product/spudesc/' + spuId,
    method: 'delete'
  })
}
