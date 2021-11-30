<template>
  <v-app>
    <v-app-bar app elevate-on-scroll color="white" flat>
      <v-container class="px-0 py-0 fill-height justify-start ml-10">
        <theNavigator />
      </v-container>
      <v-spacer></v-spacer>

      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on"> 選單 </v-btn>
        </template>
        <v-list>
          <v-list-item v-for="(item, index) in items" :key="index" link>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <v-btn class="mr-2 justify-end" text x-large color="blue" @click="logout">
        登出
      </v-btn>
    </v-app-bar>
    <v-main class="grey lighten-3">
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
    <v-footer color="primary" padless>
      <v-row justify="center" no-gutters>
        <v-col class="grey darken-4 py-1 text-center white--text" cols="12">
          <a href="privacy" class="white--text" style="text-decoration: none;">隱私權政策</a>｜
          <a href="terms" class="white--text" style="text-decoration: none;">使用條款</a>
        </v-col>
        <v-col class="grey darken-4 py-1 text-center white--text" cols="12">
          Copyright ©{{ new Date().getFullYear() }} — ACE RESUME 履歷存摺. All rights reserved.
        </v-col>
      </v-row>
    </v-footer>
  </v-app>
</template>

<script>
// @ is an alias to /src
import theNavigator from "@/components/theNavigator.vue";
export default {
  created: function () {
    console.log("aaaaa");
  },
  components: {
    theNavigator,
  },
  data: () => ({
    isLogin: false,
    items: [
      { title: "個人資料", link: "/login" },
      { title: "我的履歷表", link: "" },
      { title: "登出", link: "" },
    ],
  }),
  methods: {
    logout() {
      this.$store.commit("logout");
      alert("登出成功");
      this.isLogin = false;
      this.$router.push("/");
    },
    login() {
      this.isLogin = true;
    },
  },
};
</script>
