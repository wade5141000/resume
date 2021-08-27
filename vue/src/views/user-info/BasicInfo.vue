<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="1"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
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
              <v-col cols="12" md="4" lg="3">
                <v-radio-group label="性別" v-model="user.sex" row class="mt-0">
                  <v-radio label="男" value="男"></v-radio>
                  <v-radio label="女" value="女"></v-radio>
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
              <v-col cols="7" md="7" lg="6">
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
                      v-model="user.militaryDate"
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
                    v-model="user.militaryDate"
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
                  v-model="city"
                ></v-select>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="鄉鎮市區"
                  :items="towns"
                  outlined
                  dense
                  v-model="town"
                ></v-select>
              </v-col>
              <v-col cols="12" md="6" lg="5">
                <v-text-field
                  label="地址"
                  outlined
                  dense
                  v-model="address"
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
              <v-col cols="12" md="6" lg="6">
                <v-text-field
                  label="email"
                  outlined
                  dense
                  v-model="user.email"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="9">
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
              <v-col cols="6" md="1" lg="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="無"
                  value="無"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="9">
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
              <v-col cols="6" md="3" lg="2">
                <v-checkbox
                  v-model="specialIdentity"
                  label="身心障礙"
                  value="身心障礙"
                ></v-checkbox>
              </v-col>
              <v-col cols="6" md="1" lg="3"> </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="9" class="d-flex justify-end">
                <theDialog>
                  <template v-slot:btn>
                    <v-icon color="blue">mdi-chat-question</v-icon>看看範例
                  </template>
                </theDialog>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="9">
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
              <v-col cols="12" md="10" lg="9">
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
            <v-row no-gutters justify="center" align="center" class="pt-4 mb-2">
              <v-col cols="6" md="5" lg="4">
                個人連結
              </v-col>
              <v-col cols="6" md="5" lg="5" class="d-flex justify-end">
                <v-btn
                  v-if="links.length < 5"
                  text
                  color="primary"
                  @click="addWebsite"
                >
                  <v-icon left>
                    mdi-plus-circle
                  </v-icon>
                  新增個人連結
                </v-btn>
              </v-col>
            </v-row>
            <v-row
              justify="center"
              class="my-0 py-0"
              v-for="(link, index) in links"
              :key="index"
            >
              <v-col cols="6" md="3" lg="3" class="my-0 py-0">
                <v-select
                  label="網站"
                  :items="websites"
                  outlined
                  dense
                  v-model="link.platform"
                ></v-select>
              </v-col>
              <v-col cols="6" md="7" lg="6" :key="index" class="my-0 py-0">
                <v-text-field label="URL" outlined dense v-model="link.url">
                  <template v-slot:append-outer>
                    <v-icon @click="removeWebsite(index)" color="red">
                      mdi-close
                    </v-icon>
                  </template>
                </v-text-field>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
                  >儲存，下一步</v-btn
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
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    },
    city(newValue, oldValue) {
      http.get("/address/towns/" + newValue).then(response => {
        this.towns = response.data;
      });
    }
  },
  created: function() {
    http.get("/user").then(response => {
      console.log(response.data);
      let user = response.data;

      if (user.address) {
        this.city = user.address.substring(0, 3);
        user.address = user.address.substring(3);

        http.get("/address/towns/" + this.city).then(response => {
          this.towns = response.data;
          this.towns.forEach(town => {
            if (user.address.startsWith(town)) {
              this.town = user.address.substring(0, town.length);
              this.address = user.address.substring(town.length);
              return false;
            }
          });
        });
      }
      if (user.driverLicense) {
        this.driverLicense = [].concat(user.driverLicense.split(","));
      }
      if (user.specialIdentity) {
        this.specialIdentity = [].concat(user.specialIdentity.split(","));
      }
      if (user.feature) {
        this.features = []
          .concat(user.feature.split(","))
          .filter(s => s.length > 0);
      }

      if (user.links.length === 0) {
        this.links.push({ id: null, platform: "", url: "" });
      } else {
        this.links = response.data.links;
      }

      this.user = user;

      http.get("/address/cities").then(response => {
        this.cities = response.data;
      });
    });
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
    cities: [],
    towns: [],
    city: "",
    town: "",
    address: "",
    driverLicense: [],
    specialIdentity: [],
    user: {},
    feature: "",
    features: [],
    websites: [
      { text: "個人網站", value: "個人網站" },
      { text: "Facebook", value: "Facebook" },
      { text: "Instagram", value: "Instagram" },
      { text: "Linkedin", value: "Linkedin" },
      { text: "Github", value: "Github" }
    ],
    links: []
  }),
  methods: {
    pickBirthDay(date) {
      this.$refs.menu.save(date);
    },
    pickMilitaryServiceDate(date) {
      this.$refs.menu2.save(date);
    },
    nextStep() {
      this.user.address = this.city + this.town + this.address;
      this.user.driverLicense = this.driverLicense.join(",");
      this.user.specialIdentity = this.specialIdentity.join(",");
      this.user.feature = this.features.join(",");
      this.user.links = this.links;

      console.log(this.user);

      http.put("/user/basic-info", this.user).then(response => {
        console.log(response);
        if (response.data === true) {
          this.$router.push("/education-list");
        } else {
          alert("發生錯誤");
        }
      });
    },
    onFeatureEnter() {
      if (this.feature.length > 0) {
        this.features.push(this.feature);
        this.feature = "";
      }
    },
    close(str) {
      this.features = this.features.filter(item => item !== str);
    },
    addWebsite() {
      this.links.push({ id: null, platform: "", url: "" });
    },
    removeWebsite(index) {
      this.links.splice(index, 1);
    }
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
