<template>
  <v-container id="login" fluid tag="section">
    <v-row justify="center">
      <v-col cols="12" md="7" sm="8">
        <v-card :loading="loading" class="mx-auto my-0 pa-0" max-width="800">
          <v-row class="ma-0">
            <v-col cols="12" md="6" class="px-5">
              <v-row justify="center" class="fill-height ma-0 align-center">
                <v-responsive>
                  <v-img src="../assets/secure_login.svg"> </v-img>
                </v-responsive>
              </v-row>
            </v-col>

            <v-col cols="12" md="6" class="px-5">
              <div class="my-8 align-center text-center">
                <h2 justify="center">登入帳號</h2>
                <div class="subtitle-2 mt-2">請輸入您的帳號/密碼</div>
              </div>
              <v-sheet max-width="500">
                <form>
                  <v-text-field
                    v-model="username"
                    :counter="10"
                    label="帳號"
                    hide-details="auto"
                    placeholder="請輸入帳號"
                    outlined
                    required
                  ></v-text-field>
                  <v-text-field
                    v-model="password"
                    :type="'password'"
                    :counter="10"
                    label="密碼"
                    hide-details="auto"
                    placeholder="請輸入密碼"
                    outlined
                    required
                  ></v-text-field>
                  <div class="d-flex justify-space-between">
                  <v-checkbox
                    v-model="checkbox"
                    :error-messages="checkboxErrors"
                    label="記住我的帳號密碼"
                    class="mt-0"
                    required
                    outlined
                    @change="$v.checkbox.$touch()"
                    @blur="$v.checkbox.$touch()"
                  ></v-checkbox>
                  <a href="/resetpw" class="py-1 text-decoration-none">忘記密碼？</a>
                  </div>

                  <v-btn
                    depressed
                    block
                    large
                    class="mr-4"
                    color="primary"
                    @click="submit"
                  >
                    立即登入
                  </v-btn>
                  <div class="text-center my-5"> 
                    <a href="/signup" class="py-1 text-decoration-none">立即註冊！</a>
                    </div>
                  
                </form>
              </v-sheet>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../utils/http";
import axios from "axios";
export default {
  data() {
    return {
      username: "",
      password: ""
    };
  },
  computed: {},
  methods: {
    getUser() {
      http.get("/user").then(function(response) {
        console.log(response);
      });
    },
    login() {
      const data = {
        username: this.username,
        password: this.password
      };
      const formData = new FormData();
      Object.keys(data).forEach(key => {
        formData.append(key, data[key]);
      });
      const config = {
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        }
      };
      axios
        .post(process.env.VUE_APP_BACKEND_URL + "/login", formData, config)
        .then(response => {
          console.log("登入成功");
          console.log(response.data);
          this.$store.commit("login", response.data);
        })
        .catch(() => {
          console.log("登入失敗");
        });
    },
    logout() {
      this.$store.commit("logout");
    },
    print() {
      console.log("state: ");
      console.log(this.$store.state);
      console.log("local storage");
      const userData = JSON.parse(localStorage.getItem("user"));
      console.log(userData);
    }
  }
};
</script>
