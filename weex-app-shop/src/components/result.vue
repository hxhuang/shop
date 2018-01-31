<template>
    <div class="app">
        <wxc-result :type="type"
                    padding-top="232"
                    :custom-set="customSet"
                    @wxcResultButtonClicked="resultButtonClick"
                    :show="show"></wxc-result>
    </div>
</template>

<style scoped>
    .app {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        padding-bottom: 5px;
        background-color: #F0F0F0;
    }
</style>

<script>

    import {WxcResult} from 'weex-ui'

    const modal = weex.requireModule('modal');

    export default {
        components: {WxcResult},
        data() {
            return {
                show: true,
                type: 'error',
                customSet: {
                    errorPage: {
                        button: '立即反馈',
                        content: '亲，出错了',
                        pic: 'https://gw.alicdn.com/tfs/TB1lgzNfBHH8KJjy0FbXXcqlpXa-320-320.png'
                    }
                }
            }
        },
        methods: {
            resultButtonClick(e) {
                modal.toast({
                    'message': `你点击了按钮`,
                    'duration': 1
                })
            }
        }
    }
</script>