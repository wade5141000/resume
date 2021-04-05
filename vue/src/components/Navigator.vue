<template>
  <div class="d-inline-flex mx-5">
    <!-- <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar> -->
    <div class="mr-10 ml-0">
      <v-img
        src="../assets/logo_white.svg"
        height="40"
        max-width="100"
        color="white"
        contain
        content-class
      ></v-img>
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
  </div>
</template>

<script>
export default {
  data: () => ({
    links: [
      { text: "帳號登入", link: "/" },
      { text: "帳號註冊", link: "/signup" },
      { text: "使用條款", link: "/privacy" },
      { text: "About", link: "/about" }
    ]
  })
};
</script>
