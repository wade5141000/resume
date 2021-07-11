<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="8" class="mt-6">
      <theStepper step="1"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">基本資料</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" justify="center">
              <v-col cols="6" md="3" lg="3">
                <v-text-field
                  label="姓名"
                  outlined
                  dense
                  v-model="user.name"
                ></v-text-field>
              </v-col>
              <v-col cols="6" md="3" lg="3">
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
                      label="生日"
                      v-model="user.birthday"
                      outlined
                      dense
                      prepend-inner-icon="mdi-calendar"
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
              <v-col cols="12" md="4" lg="2">
                <v-radio-group label="性別" v-model="user.sex" row class="mt-0">
                  <v-radio label="男" value="0"></v-radio>
                  <v-radio label="女" value="1"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="5" md="3" lg="3">
                <v-select
                  label="兵役狀況"
                  :items="militaryItems"
                  outlined
                  dense
                  v-model="user.militaryService"
                ></v-select>
              </v-col>
              <v-col cols="7" md="7" lg="5">
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
                      label="役畢日期"
                      v-model="user.militaryServiceDate"
                      outlined
                      dense
                      prepend-inner-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                      placeholder="請選擇日期"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker2"
                    type="month"
                    v-model="user.militaryServiceDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickMilitaryServiceDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="縣市"
                  :items="cities"
                  outlined
                  dense
                ></v-select>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="鄉鎮市區"
                  :items="towns"
                  outlined
                  dense
                ></v-select>
              </v-col>
              <v-col cols="12" md="6" lg="4">
                <v-text-field
                  label="地址"
                  outlined
                  dense
                  v-model="user.address"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="12" md="4" lg="3">
                <v-text-field
                  label="聯絡電話"
                  outlined
                  dense
                  v-model="user.phone"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6" lg="5">
                <v-text-field
                  label="email"
                  outlined
                  dense
                  v-model="user.email"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                駕駛執照
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="輕型機車50CC"
                  value="輕型機車50CC"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="重型機車50~250CC"
                  value="重型機車50~250CC"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="汽車駕駛執照"
                  value="汽車駕駛執照"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="1" lg="2">
                <v-checkbox
                  v-model="driverLicense"
                  label="無"
                  value="無"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                特殊身份
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="specialIdentity"
                  label="外籍人士"
                  value="外籍人士"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="specialIdentity"
                  label="原住民"
                  value="原住民"
                ></v-checkbox>
              </v-col>
              <v-col cols="12" md="4" lg="4">
                <v-checkbox
                  v-model="specialIdentity"
                  label="身心障礙"
                  value="身心障礙"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
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
                  label="自我簡介"
                  hint="簡單描述特長、成就，讓企業快速瞭解你"
                  outlined
                  v-model="user.introduction"
                  rows="3"
                  auto-grow
                  no-resize
                  maxLength="200"
                  counter="200"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field
                  label="個人特色"
                  outlined
                  dense
                  v-model="feature"
                  v-on:keyup.enter="onFeatureEnter()"
                  maxLength="20"
                  counter="20"
                  hint="輸入完畢按下【Enter】鍵完成新增"
                  persistent-hint
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
            <v-row justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field label="個人連結" outlined dense></v-text-field>
              </v-col>
            </v-row>
            <v-row justify="center" class="my-4">
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
import theDialog from "../../components/theDialog";
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
  data: () => ({
    panel: [0],
    menu: false,
    menu2: false,
    militaryItems: [
      { text: "已服役", value: "已服役" },
      { text: "未服役", value: "未服役" },
      { text: "免役", value: "免役" }
    ],
    cities: [
      { text: "台北市", value: "台北市" },
      { text: "新北市", value: "新北市" },
      { text: "高雄市", value: "高雄市" }
    ],
    towns: [
      { text: "中正區", value: "中正區" },
      { text: "信義區", value: "信義區" },
      { text: "松山區", value: "松山區" }
    ],
    driverLicense: [],
    specialIdentity: [],
    user: {},
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
