<template>
    <slider class="slider" interval="3000" auto-play="true" @click="jumpToDetail">
        <div class="frame" v-for="img in banners">
            <image class="image" resize="cover" :src="img.src"></image>
        </div>
        <indicator class="indicator"></indicator>
    </slider>
</template>

<script>
    export default {
        name: "banner",
        props: ['banners'],
        data() {
            return {}
        },
        methods: {
            jumpToDetail(event) {

            }
        }
    }
</script>

<style scoped>
    .image {
        width: 750px;
        height: 350px;
    }

    .slider {
        margin-top: 5px;
        width: 750px;
        height: 350px;
    }

    .frame {
        width: 750px;
        height: 350px;
        position: relative;
    }

    .indicator {
        width: 750px;
        height: 650px;
        item-color: white;
        item-selected-color: red;
        item-size: 16px;
        position: absolute;
    }
</style>