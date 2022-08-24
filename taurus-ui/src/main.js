import Vue from "vue";

/* 引入element-ui */
import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css

import App from './App'
import router from './router'





import './assets/icons' // icon图标

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  /*store,*/
  render: h => h(App)
})
