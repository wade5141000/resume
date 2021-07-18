<template>
  <v-row justify="center">
    <v-col cols="12">
      <h1>首頁</h1>
      <!--            <v-btn @click="getUser">取得user</v-btn>-->
      <!--            <v-btn @click="print">print state</v-btn>-->
      <!--    <v-btn @click="getImage">取得圖片</v-btn>-->
      <!--    <img :src="src" width="150" height="150" alt="test" />-->
    </v-col>
  </v-row>
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
      http.get("/user/all").then(response => {
        console.log(response);
      });
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
