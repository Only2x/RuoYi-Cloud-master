import request from '@/utils/request'

// 查询spu图片列表
export function listSpuimages(query) {
  return request({
    url: '/product/spuimages/list',
    method: 'get',
    params: query
  })
}

// 查询spu图片详细
export function getSpuimages(id) {
  return request({
    url: '/product/spuimages/' + id,
    method: 'get'
  })
}

// 新增spu图片
export function addSpuimages(data) {
  return request({
    url: '/product/spuimages',
    method: 'post',
    data: data
  })
}

// 修改spu图片
export function updateSpuimages(data) {
  return request({
    url: '/product/spuimages',
    method: 'put',
    data: data
  })
}

// 删除spu图片
export function delSpuimages(id) {
  return request({
    url: '/product/spuimages/' + id,
    method: 'delete'
  })
}
