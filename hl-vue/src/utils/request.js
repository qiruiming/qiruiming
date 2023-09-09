import axios from 'axios'
import router from '@/router'
import { Message } from 'element-ui'

const request = axios.create({
    baseURL:process.env.VUE_APP_BASE_URL
})

const white_list = ['/user/login', '/code']
request.interceptors.request.use(config => {
    const { url } = config
    if (white_list.indexOf(url) >= 0){
        return config
    } 
    const token = sessionStorage.getItem('token')
    config.headers['Authorization'] = token
    return config
}, e => {
    return Promise.reject(e)
})

// axios 响应拦截器
request.interceptors.response.use(resp => {
    // resp = {data: { code, message, data }, xxx}
    // const data = resp.data
    const { data } = resp
    const { code, message } = data
    if (code === 401) {
        sessionStorage.clear()
        Message.error(message)
        router.push('/login')
        return Promise.reject(message)
    }
    return data
}, e => {
    return Promise.reject
})

export default request