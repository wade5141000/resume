<template>
  <v-app>
    <v-app-bar app color="white" flat>
      <v-container class="px-0 py-0 fill-height">
        <theNavigator />
      </v-container>
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
  }
};
</script>
