<template>
    <div class="container">
        <div class="demo demo1">
            <wxc-searchbar
                    placeholder="搜索目的地"
                    mod="hasDep"
                    dep-name="上海"
                    @wxcSearchbarCancelClicked="wxcSearchbarCancelClicked"
                    @wxcSearchbarInputReturned="wxcSearchbarInputReturned"
                    @wxcSearchbarInputOnInput="wxcSearchbarInputOnInput"
                    @wxcSearchbarInputOnFocus="wxcSearchbarInputOnFocus"
                    @wxcSearchbarInputOnBlur="wxcSearchbarInputOnBlur"></wxc-searchbar>
            <text class="value-text">{{value}}</text>
        </div>
    </div>
</template>
<script>

    import {WxcSearchbar} from 'weex-ui'

    export default {
        name: 'search',
        components: {WxcSearchbar},
        data: () => ({
            value: ''
        }),
        methods: {
            wxcSearchbarInputOnFocus() {
            },
            wxcSearchbarInputOnBlur() {
            },
            wxcSearchbarInputReturned() {
            },
            wxcSearchbarInputOnInput(e) {
                this.value = e.value;
            },
            wxcSearchbarCancelClicked() {
            }
        }
    };
</script>