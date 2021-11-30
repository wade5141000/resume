<template>
  <v-row justify="center" class="white">
    <v-col cols="12" class="pa-0">
      <v-carousel
        cycle
        hide-delimiter-background
        :show-arrows="false"
        :height="400"
      >
        <v-carousel-item
          v-for="(item, i) in items"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
        ></v-carousel-item>
      </v-carousel>
    </v-col>
    <v-col col="9" lg="3" sm="3" class="my-5">
      <v-card class="mx-auto justify-center" max-width="250" :elevation="0">
        <v-img src="../assets/icon01.svg" height="290"></v-img>
        <v-card-title class="d-flex justify-center text-center my-2"
          ><h3>多種模版<br />隨時想換就換</h3>
        </v-card-title>
        <v-card-subtitle class="d-flex justify-center text-center pa-0 my-2">
           多種樣式模版，不同職務搭配不同模版<br />只要一鍵，即可快速更換
        </v-card-subtitle>
      </v-card>
    </v-col>
    <v-col col="9" lg="3" sm="3" class="my-5">
      <v-card class="mx-auto" max-width="250" :elevation="0">
        <v-img src="../assets/icon02.svg" height="290"></v-img>
        <v-card-title class="d-flex justify-center text-center my-2"
          ><h3>是履歷表<br />也是個人網站</h3>
        </v-card-title>
        <v-card-subtitle class="d-flex justify-center text-center pa-0 my-2">
          除了是履歷表，也是作品集網站<br />讓你的作品一目瞭然精彩呈現
        </v-card-subtitle>
      </v-card>
    </v-col>
    <v-col col="9" lg="3" sm="3" class="my-5">
      <v-card class="mx-auto justify-center" max-width="250" :elevation="0">
        <v-img src="../assets/icon01.svg" height="290"></v-img>
        <v-card-title class="d-flex justify-center text-center my-2"
          ><h3>客製化模版<br />隨我設計</h3>
        </v-card-title>
        <v-card-subtitle class="d-flex justify-center text-center pa-0 my-2">
          一鍵更換履歷模版
        </v-card-subtitle>
      </v-card>
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
    src: "",
    show: false,
    items: [
      {
        src: require("../assets/slider01.jpg")
      },
      {
        src: require("../assets/slider01.jpg")
      },
      {
        src: require("../assets/slider01.jpg")
      },
      {
        src: require("../assets/slider01.jpg")
      }
    ]
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
