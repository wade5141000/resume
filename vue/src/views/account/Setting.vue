<template>
  <v-row justify="center" class="mt-4">
    <v-col cols="10" md="3" lg="3" sm="12" class="pa-0">
      <v-card class="mx-auto my-0 pa-0 blue">
        <v-img height="100%">
          <v-row align="center" class="fill-height pa-0 ma-0">
            <v-col
              align-self="center"
              align="center"
              class="ma-0 pa-0"
              cols="12"
            >
              <v-avatar class="profile my-5" color="grey" size="225" circle>
                <v-img src="../../assets/avatar_default.jpg"> </v-img>
              </v-avatar>
            </v-col>
            <v-col class="pa-0 ma-0">
              <v-list-item color="rgba(0, 0, 0, .4)" dark>
                <v-list-item-content>
                  <v-list-item-title class="text-h6 text-center">
                    <h4>王大明</h4>
                  </v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-col>
            <v-col cols="12" md="12" lg="12" sm="12" class="white pa-5 ma-0">
              <v-btn
                label="File input"
                x-large
                block
                outlined
                :loading="loading3"
                :disabled="loading3"
                color="blue"
                class="ma-2 pa-2 white--text"
                @click="loader = 'loading3'"
              >
                上傳頭像
                <v-icon right light> mdi-image-area </v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-img>
      </v-card>
    </v-col>
    <v-col cols="10" md="7" sm="7" class="pa-0 mx-5">
      <v-card class="mx-auto my-0 pa-5">
        <h2 justify="left">帳號設定</h2>
        <v-divider class="my-5"></v-divider>
        <v-row class="mt-5">
          <v-col cols="12" md="5" lg="5">
            <v-text-field
              label="聯絡電話"
              outlined
              dense
              v-model="user.phone"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="7" lg="7">
            <v-text-field
              label="聯絡email"
              outlined
              dense
              v-model="user.email"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="3" lg="3">
            <v-btn
              label="變更密碼"
              x-large
              color="blue"
              class="ma-2 pa-5 white--text"
              href="resetpw"
            >
              變更密碼
              <v-icon right light> mdi-lock-outline </v-icon>
            </v-btn>
          </v-col>
          <v-col cols="12" md="3" lg="4">
            <v-btn
              label="修改履歷資料"
              x-large
              color="blue"
              class="ma-2 pa-5 white--text"
              href="user-info"
            >
              修改履歷資料
              <v-icon right light> mdi-pencil-outline </v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-card>
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
