import request from '@/utils/request'

// 查询商品库存列表
export function listWmsSku(query) {
  return request({
    url: '/warehouse/wmsSku/list',
    method: 'get',
    params: query
  })
}

// 查询商品库存详细
export function getWmsSku(id) {
  return request({
    url: '/warehouse/wmsSku/' + id,
    method: 'get'
  })
}

// 新增商品库存
export function addWmsSku(data) {
  return request({
    url: '/warehouse/wmsSku',
    method: 'post',
    data: data
  })
}

// 修改商品库存
export function updateWmsSku(data) {
  return request({
    url: '/warehouse/wmsSku',
    method: 'put',
    data: data
  })
}

// 删除商品库存
export function delWmsSku(id) {
  return request({
    url: '/warehouse/wmsSku/' + id,
    method: 'delete'
  })
}
