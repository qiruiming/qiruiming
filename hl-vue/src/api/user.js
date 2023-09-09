import request from "@/utils/request";
import qs from 'qs'

export function addUser(data) {
    return request({
        url:'/test/insertUser',
        method:'post',
        data : data
    })
}

// 查询列表
export function getList(pageNumber, pageSize, queryForm) {
    return request({
        url: `/test/selectUser?pageNumber=${pageNumber}&pageSize=${pageSize}`,
        data: queryForm,
        method: 'post'
    })
}

export function updateUser(queryForm) {
    return request({
        url: `/test/updateUser`,
        data: queryForm,
        method: 'post'
    })
}

export function deleteUser(id) {
    return request({
        url: `/test/deleteUser?id=${id}`,
        method: 'post'
    })
}