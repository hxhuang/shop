<template>
  <div class="app-wrapper">
    <text>{{msg}}</text>
  </div>
</template>
<script>
  let modal = weex.requireModule('modal');
  export default {
    data () {
        return {
            msg: 'Classify'
        }
    },
    components: {
  
    },
    created () {
        
    },
    methods: {
        onTabTo(_result){
            
        }
    }
}
</script>
<style scoped>
  body{
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
    color:#333;
  }
</style>
