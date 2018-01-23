<!-- 专区推荐 -->
<template>
    <div class="wrapper">
        <div class="special-area" v-for="special in specials" @click="jumpToDetail(special.id,special.type)">
            <image :src="special.img" style="width: 750px;height:250px " resize="cover"></image>
        </div>
    </div>
</template>

<script>
    export default {
        name: "special-area",
        props: ['specials'],
        data() {
            return {}
        },
        methods: {
            jumpToDetail(id, type) {
                this.$router.push('/specialDetail')
            }
        }
    }
</script>

<style scoped>

    .wrapper {
        background-color: #fff;
        padding-bottom: 10px;
    }

    .special-area {
        margin-bottom: 10px;
    }
</style>