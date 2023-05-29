import request from '@/utils/request'

// 查询成长值变化历史记录列表
export function listGrowthhistory(query) {
  return request({
    url: '/member/growthhistory/list',
    method: 'get',
    params: query
  })
}

// 查询成长值变化历史记录详细
export function getGrowthhistory(id) {
  return request({
    url: '/member/growthhistory/' + id,
    method: 'get'
  })
}

// 新增成长值变化历史记录
export function addGrowthhistory(data) {
  return request({
    url: '/member/growthhistory',
    method: 'post',
    data: data
  })
}

// 修改成长值变化历史记录
export function updateGrowthhistory(data) {
  return request({
    url: '/member/growthhistory',
    method: 'put',
    data: data
  })
}

// 删除成长值变化历史记录
export function delGrowthhistory(id) {
  return request({
    url: '/member/growthhistory/' + id,
    method: 'delete'
  })
}
