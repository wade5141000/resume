<template>
  <v-app>
    <v-app-bar app elevate-on-scroll color="white" flat>
      <v-container class="px-0 py-0 fill-height justify-start ml-10">
        <theNavigator />
      </v-container>
      <v-spacer></v-spacer>
      <v-btn class="mr-2 justify-end" text x-large color="blue" @click="logout"> 登出 </v-btn>
    </v-app-bar>
    <v-main class="grey lighten-3">
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
    <!--    <v-footer app color="blue">-->
    <!--      <v-container class="px-0 py-0 fill-height">-->
    <!--        <theNavigator />-->
    <!--      </v-container>-->
    <!--    </v-footer>-->
  </v-app>
</template>

<script>
// @ is an alias to /src
import theNavigator from "@/components/theNavigator.vue";
export default {
  components: {
    theNavigator
  },
  methods: {
    logout() {
      this.$store.commit("logout");
      alert("登出成功");
      this.$router.push("/");
    }
  }
};

</script>
