<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="10" class="mt-6">
      <theStepper step="1"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">基本資料</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <!--                <span>姓名</span>-->
                <v-text-field
                  label="姓名"
                  outlined
                  dense
                  v-model="user.name"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>生日</span>
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
                      v-model="user.birthday"
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
                    v-model="user.birthday"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickBirthDay"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>性別</span>
                <v-radio-group v-model="user.sex" row class="mt-0">
                  <v-radio label="男" value="0"></v-radio>
                  <v-radio label="女" value="1"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="5" md="4" lg="3">
                <span>兵役狀況</span>
                <v-select
                  :items="militaryItems"
                  outlined
                  dense
                  v-model="user.militaryService"
                ></v-select>
              </v-col>
              <v-col cols="7" md="6" lg="5">
                <span class="ml-6">役畢日期</span>
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
                      v-model="user.militaryServiceDate"
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
                    v-model="user.militaryServiceDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickMilitaryServiceDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>通訊地址</span>
                <v-text-field
                  outlined
                  dense
                  v-model="user.address"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>email</span>
                <v-text-field
                  outlined
                  dense
                  v-model="user.email"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>聯絡電話</span>
                <v-text-field
                  outlined
                  dense
                  v-model="user.phone"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>駕駛執照</span>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="3" md="3" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="輕型機車50CC"
                  value="a"
                ></v-checkbox>
              </v-col>
              <v-col cols="3" md="3" lg="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="重型機車50~250CC"
                  value="b"
                ></v-checkbox>
              </v-col>
              <v-col cols="3" md="3" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="汽車駕駛執照"
                  value="c"
                ></v-checkbox>
              </v-col>
              <v-col cols="3" md="1" lg="1">
                <v-checkbox
                  v-model="driverLicense"
                  label="無"
                  value="d"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>特殊身份</span>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="3" md="3" lg="2">
                <v-checkbox
                  v-model="specialIdentity"
                  label="外籍人士"
                  value="a"
                ></v-checkbox>
              </v-col>
              <v-col cols="3" md="3" lg="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="原住民"
                  value="b"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="4" lg="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="身心障礙"
                  value="d"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>自我簡介</span>
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
                  placeholder="簡單描述特長、成就，讓企業快速瞭解你"
                  v-model="user.introduction"
                  rows="3"
                  auto-grow
                  no-resize
                  maxLength="200"
                  counter="200"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>個人特色</span>
                <v-text-field
                  outlined
                  dense
                  v-model="feature"
                  v-on:keyup.enter="onFeatureEnter()"
                  maxLength="20"
                  counter="20"
                  placeholder="輸入完畢按下【Enter】鍵完成新增"
                ></v-text-field>
                <v-chip
                  v-for="(item, index) in features"
                  v-bind:key="index"
                  close
                  color="blue"
                  text-color="white"
                  class="mr-2 mb-2"
                  @click:close="close(item)"
                >
                  {{ item }}
                </v-chip>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>個人連結</span>
                <v-text-field outlined dense></v-text-field>
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
    militaryItems: [
      { text: "已服役", value: 1 },
      { text: "未服役", value: 0 }
    ],
    driverLicense: [],
    specialIdentity: [],
    user: {
      militaryService: 0
    },
    feature: "",
    features: []
  }),
  methods: {
    pickBirthDay(date) {
      this.$refs.menu.save(date);
    },
    pickMilitaryServiceDate(date) {
      this.$refs.menu2.save(date);
    },
    nextStep() {
      console.log(this.user);
      console.log(this.driverLicense);
      console.log(this.features);
      this.$router.push("/education");
    },
    onFeatureEnter() {
      if (this.feature.length > 0) {
        this.features.push(this.feature);
        this.feature = "";
      }
    },
    close(str) {
      this.features = this.features.filter(item => item !== str);
    }
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
