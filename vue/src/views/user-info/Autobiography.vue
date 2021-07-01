<template>
  <v-row justify="center">
    <v-col cols="12" md="8" lg="6" class="mt-6">
      <theStepper step="5"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">自傳</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>自傳(中文)</span>
              </v-col>
              <v-col cols="6" md="5" lg="4" class="d-flex justify-end">
                <span
                  ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
                ></v-col
              >
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="2000"
                  counter="2000"
                  v-model="chinese"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>自傳(英文)</span>
              </v-col>
              <v-col cols="6" md="5" lg="4" class="d-flex justify-end">
                <span
                  ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
                ></v-col
              >
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="4000"
                  counter="4000"
                  v-model="english"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center" class="my-6">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary" @click="save"
                  >完成</v-btn
                >
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-col>
  </v-row>
</template>

<script>
import theStepper from "../../components/theStepper";
export default {
  components: {
    theStepper
  },
  data: () => ({
    panel: [0],
    chinese: "",
    english: ""
  }),
  methods: {
    save() {
      console.log(this.chinese);
      console.log(this.english);
    }
  }
};
</script>

<style scoped></style>
