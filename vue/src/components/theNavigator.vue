<template>
  <div class="d-inline-flex mx-5">
    <!-- <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar> -->
    <div class="mr-10 ml-0">
      <router-link to="/">
        <v-img
          src="../assets/logo_white.svg"
          height="40"
          max-width="100"
          color="white"
          contain
          content-class
        ></v-img>
      </router-link>
    </div>
    <v-btn
      class="mr-2"
      v-for="(item, index) in links"
      :key="index"
      text
      :to="item.link"
      color="white"
    >
      {{ item.text }}
    </v-btn>
    <v-btn class="mr-2" text color="white" @click="logout"> 登出 </v-btn>
  </div>
</template>

<script>
export default {
  data: () => ({
    links: [
      { text: "帳號登入", link: "/login" },
      { text: "帳號註冊", link: "/signup" },
      { text: "重設密碼", link: "/resetpw" },
      { text: "基本資料", link: "/user-info" },
      { text: "套用資料", link: "/apply-info" },
      { text: "我的履歷", link: "/resume" }
    ]
  }),
  methods: {
    logout() {
      this.$store.commit("logout");
      alert("登出成功");
      this.$router.push("/");
    }
  }
};
</script>
