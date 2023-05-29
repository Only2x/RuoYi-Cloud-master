import request from '@/utils/request'

// 查询积分变化历史记录列表
export function listIntegrationhistory(query) {
  return request({
    url: '/member/integrationhistory/list',
    method: 'get',
    params: query
  })
}

// 查询积分变化历史记录详细
export function getIntegrationhistory(id) {
  return request({
    url: '/member/integrationhistory/' + id,
    method: 'get'
  })
}

// 新增积分变化历史记录
export function addIntegrationhistory(data) {
  return request({
    url: '/member/integrationhistory',
    method: 'post',
    data: data
  })
}

// 修改积分变化历史记录
export function updateIntegrationhistory(data) {
  return request({
    url: '/member/integrationhistory',
    method: 'put',
    data: data
  })
}

// 删除积分变化历史记录
export function delIntegrationhistory(id) {
  return request({
    url: '/member/integrationhistory/' + id,
    method: 'delete'
  })
}
