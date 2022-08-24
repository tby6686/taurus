import Vue from 'vue'
import SvgIcon from '@/components/SvgIcon'// svg component

// register globally
Vue.component('svg-icon', SvgIcon)

const req = require.context('./svg', false, /\.svg$/)
//定义一个加载目录的函数
const requireAll = requireContext => requireContext.keys().map(requireContext)
//加载目录下的所有的 svg 文件
requireAll(req)
