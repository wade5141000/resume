<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="5"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">自傳</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8" class="d-flex justify-end">
                <theDialog>
                  <template v-slot:btn>
                    <v-icon color="blue">mdi-chat-question</v-icon>看看範例
                  </template>
                </theDialog>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  label="自傳(中文)"
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="2000"
                  counter="2000"
                  v-model="autobiography.chinese"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8" class="d-flex justify-end">
                <theDialog>
                  <template v-slot:btn>
                    <v-icon color="blue">mdi-chat-question</v-icon>看看範例
                  </template>
                </theDialog>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  label="自傳(英文)"
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="4000"
                  counter="4000"
                  v-model="autobiography.english"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" to="/skill"
                  >上一步</v-btn
                >
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" @click="save"
                  >儲存</v-btn
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
import theDialog from "../../components/theDialog";
import http from "../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  created() {
    http.get("/user").then(response => {
      this.autobiography.chinese = response.data.bioChn;
      this.autobiography.english = response.data.bioEng;
    });
  },
  data: () => ({
    panel: [0],
    autobiography: {
      chinese: "",
      english: ""
    }
  }),
  methods: {
    save() {
      console.log(this.autobiography);
      http.put("/user/autobiography", this.autobiography).then(response => {
        console.log(response);
        if (response.data === true) {
          alert("更新成功");
        } else {
          alert("更新失敗");
        }
      });
    }
  }
};
</script>

<style scoped></style>
