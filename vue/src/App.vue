<template>
  <v-app>
    <v-app-bar app color="blue" flat>
      <v-container class="py-0 fill-height">
        <Navigator />
      </v-container>
    </v-app-bar>
    <v-main class="grey lighten-3">
      <v-container>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// @ is an alias to /src
import Navigator from "@/components/Navigator.vue";
export default {
  components: {
    Navigator
  }
};
</script>
