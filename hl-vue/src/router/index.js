import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import { Message } from 'element-ui'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    children: [
      {
        path: '/user',
        name: 'user',
        component: () => import('../views/user/index.vue')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/* 全局前置路由守卫 */
router.beforeEach((to, from, next) => {
  const token = sessionStorage.getItem('token')
  const { path } = to

  if (path === '/login') {
    if (token) { //表示登录状态下访问/login路由
      Message.info('您已登录')
      return next('/')
    } else { //没有登录的情况下访问登录路由,直接跳转到登录路由
      return next()
    }
  } else {
    if (token) { //登录状态下访问其他路由, 直接进入当前路由
      return next ()
    } else { //没有登录的情况下访问其他路由, 跳到登录路由
      Message.info('请登录啊!')
      return next('/login')
    }
  }
})



// 防止连续点击多次路由报错
let routerPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}


export default router
