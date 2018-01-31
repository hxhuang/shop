<template>
    <div class="app">
        <result></result>
    </div>
</template>
<script>

    import Result from '../components/result.vue'

    const modal = weex.requireModule('modal');

    export default {
        data() {
            return {
                msg: 'Cart'
            }
        },
        components: {Result},
        created() {

        },
        methods: {
            onTabTo(_result) {

            }
        }
    }
</script>
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
