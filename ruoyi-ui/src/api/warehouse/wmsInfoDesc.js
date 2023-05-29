import request from '@/utils/request'

// 查询仓库管理信息列表
export function listWmsInfoDesc(query) {
  return request({
    url: '/warehouse/wmsInfoDesc/list',
    method: 'get',
    params: query
  })
}

// 查询仓库管理信息详细
export function getWmsInfoDesc(id) {
  return request({
    url: '/warehouse/wmsInfoDesc/' + id,
    method: 'get'
  })
}

// 新增仓库管理信息
export function addWmsInfoDesc(data) {
  return request({
    url: '/warehouse/wmsInfoDesc',
    method: 'post',
    data: data
  })
}

// 修改仓库管理信息
export function updateWmsInfoDesc(data) {
  return request({
    url: '/warehouse/wmsInfoDesc',
    method: 'put',
    data: data
  })
}

// 删除仓库管理信息
export function delWmsInfoDesc(id) {
  return request({
    url: '/warehouse/wmsInfoDesc/' + id,
    method: 'delete'
  })
}
