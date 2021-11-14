<template>
  <v-stepper alt-labels v-model="step">
    <v-stepper-header>
      <v-stepper-step step="1" editable @click="routerTo('/apply-info')">
        基本資料
      </v-stepper-step>

      <v-divider />
      <v-stepper-step
        step="2"
        editable
        @click="routerTo('/educationinfo-apply')"
      >
        學歷
      </v-stepper-step>

      <v-divider />
      <v-stepper-step
        step="3"
        editable
        @click="routerTo('/experienceinfo-apply')"
      >
        工作經歷
      </v-stepper-step>

      <v-divider />
      <v-stepper-step step="4" editable @click="routerTo('/skillinfo-apply')">
        專業技能
      </v-stepper-step>

      <v-divider />
      <v-stepper-step
        step="5"
        editable
        @click="routerTo('/autobiography-apply')"
      >
        自傳
      </v-stepper-step>
    </v-stepper-header>
  </v-stepper>
</template>

<script>
export default {
  props: ["step"],
  data: () => ({}),
  methods: {
    routerTo(path) {
      if (this.$router.currentRoute.path !== path) {
        this.$router.push({ path });
      }
    }
  }
};
</script>
