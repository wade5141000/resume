<template>
  <div class="about">
    <h1>This is an about page</h1>
    <v-btn @click="getUser">取得user</v-btn>
    <v-btn @click="login">登入</v-btn>
    <v-btn @click="logout">登出</v-btn>
    <v-btn @click="print">print state</v-btn>
    <v-btn @click="getImage">取得圖片</v-btn>
    <img :src="src" width="150" height="150" alt="test" />
    <v-container>
      <v-row>
        <v-col cols="12" md="2">
          <v-text-field
            v-model="username"
            :counter="10"
            label="First name"
          ></v-text-field>
        </v-col>
        <v-col cols="12" md="2">
          <v-text-field
            :type="'password'"
            v-model="password"
            :counter="10"
            label="Last name"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import http from "../utils/http";
import axios from "axios";

export default {
  data: () => ({
    username: "",
    password: "",
    src: ""
  }),
  methods: {
    getUser() {
      http.get("/user").then(response => {
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
    },
    getImage() {
      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/test/image", {
          responseType: "arraybuffer"
        })
        .then(response => {
          // console.log(response);
          this.src =
            "data:image/jpeg;base64," +
            btoa(
              new Uint8Array(response.data).reduce(
                (data, byte) => data + String.fromCharCode(byte),
                ""
              )
            );
        });
    }
  }
};
</script>
