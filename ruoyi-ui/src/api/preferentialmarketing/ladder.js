import request from '@/utils/request'

// 查询商品阶梯价格列表
export function listLadder(query) {
  return request({
    url: '/preferentialmarketing/ladder/list',
    method: 'get',
    params: query
  })
}

// 查询商品阶梯价格详细
export function getLadder(id) {
  return request({
    url: '/preferentialmarketing/ladder/' + id,
    method: 'get'
  })
}

// 新增商品阶梯价格
export function addLadder(data) {
  return request({
    url: '/preferentialmarketing/ladder',
    method: 'post',
    data: data
  })
}

// 修改商品阶梯价格
export function updateLadder(data) {
  return request({
    url: '/preferentialmarketing/ladder',
    method: 'put',
    data: data
  })
}

// 删除商品阶梯价格
export function delLadder(id) {
  return request({
    url: '/preferentialmarketing/ladder/' + id,
    method: 'delete'
  })
}
