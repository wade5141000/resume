<template>
  <div class="about">
    <h1>This is an about page</h1>
    <v-btn @click="getUser">取得user</v-btn>
    <v-btn @click="login">登入</v-btn>
  </div>
</template>

<script>
export default {
  methods: {
    getUser() {
      console.log(process.env.VUE_APP_BACKEND_URL)
      this.$http.get(process.env.VUE_APP_BACKEND_URL+'/user')
      .then(function(response){
        console.log(response);
      })
    },
    login() {
      console.log('bbb');
    },
  },
};
</script>
