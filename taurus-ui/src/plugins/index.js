import auth from './auth'

export default {
  install(Vue) {
    // 认证对象
    Vue.prototype.$auth = auth
  }
}
