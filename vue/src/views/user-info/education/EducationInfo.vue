<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="2"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">學歷</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" justify="center">
              <v-col cols="12" md="7" lg="6">
                <span></span>
                <v-text-field
                  label="學校名稱"
                  outlined
                  dense
                  v-model="edu.schoolName"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="3" lg="2">
                <v-select
                  label="學歷"
                  :items="educationLevels"
                  outlined
                  dense
                  v-model="edu.level"
                ></v-select>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field
                  label="科系名稱"
                  outlined
                  dense
                  v-model="edu.major"
                >
                </v-text-field>
              </v-col>
            </v-row>
            <v-row justify="center" v-if="edu.secondMajor || secondMajor">
              <v-col cols="12" md="10" lg="8">
                <v-text-field
                  label="科系2 名稱"
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
            <v-row justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-radio-group
                  label="就學狀態"
                  v-model="edu.status"
                  row
                  class="mt-0"
                >
                  <v-radio label="畢業" value="畢業"></v-radio>
                  <v-radio label="肄業" value="肄業"></v-radio>
                  <v-radio label="就學中" value="就學中"></v-radio>
                </v-radio-group>
              </v-col>
              <v-col cols="12" md="10" lg="8">
                <v-radio-group
                  label="學校地區"
                  v-model="edu.country"
                  row
                  class="mt-0"
                >
                  <v-radio label="台灣" value="台灣"></v-radio>
                  <v-radio label="國外" value="國外"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
            <v-row justify="center">
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
                      label="開始日"
                      v-model="edu.startDate"
                      outlined
                      dense
                      prepend-inner-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker"
                    type="month"
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
                      label="結束日"
                      v-model="edu.endDate"
                      outlined
                      dense
                      prepend-inner-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker2"
                    type="month"
                    v-model="edu.endDate"
                    min="1950-01-01"
                    @change="pickEndDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8" class="d-flex justify-end">
                <theDialog>
                  <template v-slot:btn>
                    <v-icon color="blue">mdi-chat-question</v-icon>如何換算GPA
                  </template>
                </theDialog>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field
                  label="在校成績"
                  outlined
                  dense
                  v-model="edu.gpa"
                  type="number"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
              <v-col cols="6" md="5" lg="4">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  to="/education-list"
                  >回上一頁</v-btn
                >
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
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
import theStepper from "../../../components/theStepper";
import theDialog from "../../../components/theDialog";
import http from "../../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    }
  },
  created: function() {
    let id = this.$route.query.id;
    if (id) {
      http.get("/education/" + id).then(response => {
        //console.log(response.data)
        this.edu = response.data;
      });
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
      if (this.edu.id) {
        http.put("/education", this.edu).then(response => {
          //console.log(response.data)
          if (response.data === true) {
            // TODO 成功談窗
            this.$router.push("/education-list");
            // alert("更新成功");
          } else {
            alert("更新失敗");
          }
        });
      } else {
        http.post("/education", this.edu).then(response => {
          console.log(response);
          if (response.data === true) {
            this.edu = {};
            this.$router.push("/education-list");
            // alert("新增成功");
          } else {
            alert("新增失敗");
          }
        });
      }
    }
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
