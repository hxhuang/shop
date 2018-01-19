<template>
    <wxc-tab-bar :tab-titles="tabTitles"
                 :tab-styles="tabStyles"
                 title-type="icon"
                 @wxcTabBarCurrentTabSelected="wxcTabBarCurrentTabSelected">
        <div class="item-container" :style="contentStyle"><home></home></div>
        <div class="item-container" :style="contentStyle"><classify></classify></div>
        <div class="item-container" :style="contentStyle"><cart></cart></div>
        <div class="item-container" :style="contentStyle"><personal></personal></div>
    </wxc-tab-bar>
</template>

<style scoped>
    .item-container {
        width: 750px;
        background-color: #f2f3f4;
    }
</style>
<script>
    import { WxcTabBar, Utils } from 'weex-ui';
    import Config from './config/tabBarConfig'
    import Home from "./views/home.vue";
    import Classify from "./views/classify.vue";
    import Cart from "./views/cart.vue";
    import Personal from "./views/personal.vue";

    export default {
        components: {
            Home,
            Classify,
            Cart,
            Personal,
            WxcTabBar },
        data: () => ({
            tabTitles: Config.tabTitles,
            tabStyles: Config.tabStyles
        }),
        created () {
            const tabPageHeight = Utils.env.getPageHeight();
            const { tabStyles } = this;
            this.contentStyle = { height: (tabPageHeight - tabStyles.height) + 'px' };
        },
        methods: {
            wxcTabBarCurrentTabSelected (e) {
                const index = e.page;
                // console.log(index);
            }
        }
    };
</script>
