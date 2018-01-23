<template>
    <div class="app-container">
        <scroller class="scroller">
            <div class="minibar">
                <wxc-minibar title="登录"
                             background-color="#00BB00"
                             @wxcMinibaBBrLeftButtonClicked="minibarLeftButtonClick"></wxc-minibar>
            </div>
            <div class="app-login-container">
                <div class="login-telephone-input">
                    <input type="text" value="" placeholder="请输入手机号（无需注册）" @change="getTelephone"/>
                </div>
                <div class="login-verify-input">
                    <input type="text" value="" placeholder="请输入短信验证码" @change="getLoginVerifyCode"/>
                    <div class="app-login-verify">
                        <wxc-button text="获取手机验证码" type="normal" :style="verifyCodeBtn"
                                    @wxcButtonClicked="login"></wxc-button>
                    </div>
                </div>
                <div class="app-login">
                    <wxc-button text="获取手机验证码" type="normal"
                                @wxcButtonClicked="login"></wxc-button>
                </div>

            </div>
        </scroller>
    </div>
</template>

<style scoped>
    .app-container {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: #FFFFFF;
        justify-content: center;
        align-items: center;
    }

    .scroller {
        flex: 1;
    }

    .minibar {
        width: 750px;
        height: 180px;
        align-items: flex-start;
    }

    .app-login-container {
        padding-left: 24px;
    }

    .login-telephone {
        margin: 36px 0;
    }

    .login-verify {

    }

    .app-login-btn {
        padding-top: 100px;
    }

</style>

<script>
    import {WxcMinibar, WxcButton} from 'weex-ui';


    const modal = weex.requireModule('modal');
    export default {
        components: {WxcMinibar, WxcButton},
        data: () => ({
            verifyCodeBtn: {
                color:red
            }
        }),
        created() {
        },
        methods: {
            minibarLeftButtonClick() {
                modal.toast({'message': 'click rightButton!', 'duration': 1});
            },
            getTelephone(event) {
                console.log(event.value)
            },
            getLoginVerifyCode(event) {

            },
            login() {

            }
        }
    };
</script>