import Router from 'vue-router'
import Home from './views/home.vue'
import Classify from './views/classify.vue'
import Cart from './views/cart.vue'
import Personal from './views/personal.vue'


// 详情路由
import SpecialDetail from './components/special/specialDetail.vue'



Vue.use(Router);

export default new Router({
    routes: [
        {path: '/', redirect: '/home'},
        {path: '/home', name: 'Home', component: Home},
        {path: '/classify', name: 'Classify', component: Classify},
        {path: '/cart', name: 'Cart', component: Cart},
        {path: '/personal', name: 'Personal', component: Personal},
        {path: '/specialDetail', name: 'SpecialDetail', component: SpecialDetail}
    ]
})