<template>
  <v-app>
    <v-app-bar app color="blue" flat>
<<<<<<< HEAD
      <v-container class="px-0 py-0 fill-height">
        <Navigator />
=======
      <v-container class="py-0 fill-height">
        <theNavigator />
>>>>>>> d3d5560ce207b48a44884005b07db1006630af8a
      </v-container>
    </v-app-bar>
    <v-main class="grey lighten-3">
      <v-container class="fill-height justify-center container--fluid">
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// @ is an alias to /src
import theNavigator from "@/components/theNavigator.vue";
export default {
  components: {
    theNavigator
  }
};
</script>
