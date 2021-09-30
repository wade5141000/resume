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
            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-alert
                outlined
                type="error"
                prominent
                border="left"
                >
                 <h3 justify="center" class="my-green">請勾選 <strong>8</strong> 項，欲顯示在履歷表中的項目</h3>
                 您目前已勾選 4 項，若有不足，將以空白呈顯。
                </v-alert>
              </v-col>
              <v-col cols="8" md="10" lg="5">
                <v-checkbox
                  v-model="user.name"
                  label="姓名"
                  color="red darken-3"
                  value="姓名"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="user.birthday"
                  label="生日"
                  color="red darken-3"
                  value="生日"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="user.sex"
                  label="性別"
                  color="red darken-3"
                  value="性別"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="user.militaryService"
                  label="兵役狀況"
                  color="red darken-3"
                  value="兵役狀況"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  v-model="address"
                  label="地址"
                  color="red darken-3"
                  value="地址"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="user.phone"
                  label="聯絡電話"
                  color="red darken-3"
                  value="聯絡電話"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="user.email"
                  label="email"
                  color="red darken-3"
                  value="email"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="driverLicense"
                  label="駕駛執照"
                  color="red darken-3"
                  value="駕駛執照"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  v-model="specialIdentity"
                  label="特殊身份"
                  color="red darken-3"
                  value="特殊身份"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  v-model="user.introduction"
                  label="自我簡介"
                  color="red darken-3"
                  value="自我簡介"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  v-model="feature"
                  label="個人特色"
                  color="red darken-3"
                  value="個人特色"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  v-model="link.platform"
                  label="個人連結"
                  color="red darken-3"
                  value="個人連結"
                ></v-checkbox>
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
    theDialog,
  },
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    },
    city(newValue, oldValue) {
      http.get("/address/towns/" + newValue).then((response) => {
        this.towns = response.data;
      });
    },
  },
  created: function () {
    http.get("/user").then((response) => {
      console.log(response.data);
      let user = response.data;

      if (user.address) {
        this.city = user.address.substring(0, 3);
        user.address = user.address.substring(3);

        http.get("/address/towns/" + this.city).then((response) => {
          this.towns = response.data;
          this.towns.forEach((town) => {
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
          .filter((s) => s.length > 0);
      }

      if (user.links.length === 0) {
        this.links.push({ id: null, platform: "", url: "" });
      } else {
        this.links = response.data.links;
      }

      this.user = user;

      http.get("/address/cities").then((response) => {
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
      { text: "免役", value: "免役" },
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
      { text: "Github", value: "Github" },
    ],
    links: [],
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

      http.put("/user/basic-info", this.user).then((response) => {
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
      this.features = this.features.filter((item) => item !== str);
    },
    addWebsite() {
      this.links.push({ id: null, platform: "", url: "" });
    },
    removeWebsite(index) {
      this.links.splice(index, 1);
    },
  },
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
