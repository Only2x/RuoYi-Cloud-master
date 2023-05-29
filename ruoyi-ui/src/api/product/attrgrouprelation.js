import request from '@/utils/request'

// 查询属性&属性分组关联列表
export function listAttrgrouprelation(query) {
  return request({
    url: '/product/attrgrouprelation/list',
    method: 'get',
    params: query
  })
}

// 查询属性&属性分组关联详细
export function getAttrgrouprelation(id) {
  return request({
    url: '/product/attrgrouprelation/' + id,
    method: 'get'
  })
}

// 新增属性&属性分组关联
export function addAttrgrouprelation(data) {
  return request({
    url: '/product/attrgrouprelation',
    method: 'post',
    data: data
  })
}

// 修改属性&属性分组关联
export function updateAttrgrouprelation(data) {
  return request({
    url: '/product/attrgrouprelation',
    method: 'put',
    data: data
  })
}

// 删除属性&属性分组关联
export function delAttrgrouprelation(id) {
  return request({
    url: '/product/attrgrouprelation/' + id,
    method: 'delete'
  })
}
