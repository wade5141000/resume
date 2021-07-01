<template>
  <v-row justify="center">
    <v-col cols="12" md="8" lg="6" class="mt-6">
      <theStepper step="2"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">學歷</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>學校名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="edu.schoolName"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>學歷</span>
                <v-select
                  :items="educationLevels"
                  outlined
                  dense
                  v-model="edu.level"
                ></v-select>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>科系名稱</span>
                <v-text-field outlined dense v-model="edu.major"></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center" v-if="secondMajor">
              <v-col cols="12" md="10" lg="8">
                <span>科系2 名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="edu.secondMajor"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center" v-else>
              <v-col cols="12" md="10" lg="8" class="d-flex justify-end">
                <v-btn text color="primary" @click="addSecondMajor">
                  <v-icon color="blue">mdi-plus</v-icon>新增科系
                </v-btn>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>就學狀態</span>
                <v-radio-group v-model="edu.status" row class="mt-0">
                  <v-radio label="畢業" value="畢業"></v-radio>
                  <v-radio label="肄業" value="肄業"></v-radio>
                  <v-radio label="就學中" value="就學中"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>就學期間</span>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <v-menu
                  ref="menu"
                  v-model="menu"
                  :close-on-content-click="false"
                  transition="scale-transition"
                  offset-y
                  min-width="auto"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                      v-model="edu.startDate"
                      outlined
                      dense
                      prepend-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                      placeholder="請選擇日期"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker"
                    v-model="edu.startDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickStartDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-menu
                  ref="menu2"
                  v-model="menu2"
                  :close-on-content-click="false"
                  transition="scale-transition"
                  offset-y
                  min-width="auto"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                      v-model="edu.endDate"
                      outlined
                      dense
                      prepend-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                      class="ml-6"
                      placeholder="請選擇日期"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker2"
                    v-model="edu.endDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickEndDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>學校地區</span>
                <v-radio-group v-model="edu.country" row class="mt-0">
                  <v-radio label="台灣" value="台灣"></v-radio>
                  <v-radio label="國外" value="國外"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>在校成績</span>
              </v-col>
              <v-col cols="6" md="5" lg="4" class="d-flex justify-end">
                <span
                  ><v-icon color="blue">mdi-chat-question</v-icon
                  >如何換算GPA</span
                ></v-col
              >
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field outlined dense v-model="edu.GPA"></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center" class="my-6">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
                  >下一步</v-btn
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
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    }
  },
  data: () => ({
    panel: [0],
    menu: false,
    menu2: false,
    educationLevels: [
      { text: "國小", value: "國小" },
      { text: "國中", value: "國中" },
      { text: "高中", value: "高中" },
      { text: "學士", value: "學士" },
      { text: "碩士", value: "碩士" },
      { text: "博士", value: "博士" }
    ],
    edu: {},
    secondMajor: false
  }),
  methods: {
    pickStartDate(date) {
      this.$refs.menu.save(date);
    },
    pickEndDate(date) {
      this.$refs.menu2.save(date);
    },
    addSecondMajor() {
      this.secondMajor = true;
    },
    nextStep() {
      console.log(this.edu);
      this.$router.push("/experience");
    }
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
