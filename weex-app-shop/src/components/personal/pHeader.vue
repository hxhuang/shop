<template>
    <div class="header-bar">
        <div class="header-content">
            <div class="box" @click="jumpSettings">
                <image :src="settings" class="header-image"></image>
            </div>
            <div class="box">
                <div class="scan" @click="openScan">
                    <image :src="scan" class="header-image"></image>
                </div>
                <div class="ring" @click="openRing">
                    <image :src="remind" class="header-image"></image>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "p-header",
        data() {
            return {
                settings: 'http://192.168.199.101:8080/resources/images/icon/settings.png',
                scan: 'http://192.168.199.101:8080/resources/images/icon/qr_code.png',
                remind: 'http://192.168.199.101:8080/resources/images/icon/remind.png'
            }
        },
        methods: {
            jumpSettings(event) {
                console.log(event)
            },
            openScan(event) {
                console.log(event)
            },
            openRing(event) {
                console.log(event)
            }
        }
    }
</script>

<style scoped>
    .header-bar {
        position: absolute;
        top: 0;
        right: 0;
        left: 0;
        height: 114px;
        z-index: 101;
        background-color: chartreuse;
        opacity: .9;
    }

    .header-content {
        padding-top: 40px;
        display: flex;
        justify-content: space-between;
        flex-direction: row;
    }

    .box {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        flex-wrap: nowrap;
        padding-left: 20px;
    }

    .header-image {
        width: 50px;
        height: 50px;
    }

    .scan, .ring {
        padding-right: 20px;
    }

</style>