import request from '@/utils/request'

// 查询spu属性值列表
export function listSpuvalue(query) {
  return request({
    url: '/product/spuvalue/list',
    method: 'get',
    params: query
  })
}

// 查询spu属性值详细
export function getSpuvalue(id) {
  return request({
    url: '/product/spuvalue/' + id,
    method: 'get'
  })
}

// 新增spu属性值
export function addSpuvalue(data) {
  return request({
    url: '/product/spuvalue',
    method: 'post',
    data: data
  })
}

// 修改spu属性值
export function updateSpuvalue(data) {
  return request({
    url: '/product/spuvalue',
    method: 'put',
    data: data
  })
}

// 删除spu属性值
export function delSpuvalue(id) {
  return request({
    url: '/product/spuvalue/' + id,
    method: 'delete'
  })
}
