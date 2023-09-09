import request from "@/utils/request"
import qs from "qs"


export function login(loginForm) {
    return request({
        url: '/login/login',
        data: qs.stringify(loginForm),
        method: 'post'
    })
}