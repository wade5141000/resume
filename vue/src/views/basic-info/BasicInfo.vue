<template>
  <div class="mx-auto mt-6" style="max-width: 35%">
    <v-expansion-panels v-model="panel" multiple>
      <v-expansion-panel disabled>
        <v-expansion-panel-header color="blue">
          <span style="color: white">基本資料</span>
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <v-row class="mt-6 ml-4"
            ><span style="color: dodgerblue">姓名</span></v-row
          >
          <v-row class="mt-4 ml-2">
            <v-text-field outlined dense v-model="user.name"></v-text-field>
          </v-row>
          <v-row class="ml-4"
            ><span style="color: dodgerblue">生日</span></v-row
          >
          <v-row class="mt-4 ml-2">
            <v-text-field outlined dense v-model="user.name"></v-text-field>
          </v-row>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
  </div>
</template>

<script>
import theStepper from "../../components/theStepper";
export default {
  components: {
    theStepper
  },
  data: () => ({
    panel: [0],
    user: {}
  }),
  methods: {}
};
</script>
