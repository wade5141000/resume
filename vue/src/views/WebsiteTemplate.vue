<template>
  <v-row justify="center" class="white">
    <v-col justify="center" cols="12" class="pa-0 justify-center text-center">
      <v-carousel
        hide-delimiter-background
        hide-delimiters
        :show-arrows="false"
        :height="500"
      >
        <v-carousel-item
          v-for="(item, i) in items"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
        ></v-carousel-item>
      </v-carousel>

      <!-- 基本資料 -->
      <v-col
        justify="center"
        cols="12"
        class="ma-0 py-5 justify-center text-center grey lighten-4"
      >
        <v-col col="12" lg="12" sm="12" class="my-1 d-flex justify-center text-center">
          <h2 class="d-flex justify-center text-center my-2">
            基本資料
          </h2>
        </v-col>
        <v-col cols="10" justify="center" class="ma-0 d-flex flex-wrap mx-auto justify-center text-center">
          <v-col col="12" lg="4" sm="4" class="my-1">
            <v-icon class="mr-1">mdi-account</v-icon>姓名：王志偉
          </v-col>
          <v-col col="12" lg="4" sm="4" class="my-1"> 
            <v-icon class="mr-1">mdi-calendar-month</v-icon>生日：5月5日 </v-col>
          <v-col col="12" lg="4" sm="4" class="my-1"> 性別：男 </v-col>
          <v-col col="12" lg="4" sm="4" class="my-1"> 
            <v-icon class="mr-1">mdi-phone</v-icon>電話：0912-345-678 </v-col>
          <v-col col="12" lg="4" sm="4" class="my-1">
            <v-icon class="mr-1">mdi-email</v-icon>E-mail：chiwei0505@gmail.com
          </v-col>
          <v-col col="12" lg="4" sm="4" class="my-1">
            <v-icon class="mr-1">mdi-home-city</v-icon>聯絡地址：台北市中正區博愛路100號
          </v-col>
        </v-col>
      </v-col>

      <!-- 自我簡介 & 個人連結 -->
      <v-col
        justify="center"
        cols="12"
        class="ma-0 py-5 justify-center text-center white"
      >
        <v-col col="12" lg="12" sm="12" class="my-1 d-flex justify-center text-center">
          <h2 class="d-flex justify-center text-center my-2">
            自我簡介
          </h2>
        </v-col>
        <v-col cols="8" justify="center" class="ma-0 d-flex justify-center mx-auto text-center">
          <h4>現職是一位UI設計師，從事設計工作約十年經驗。包含平面、多媒體、網頁、簡報、UI及APP設計等等，UI設計方面參與了許多 kiosk互動UI、sass後台、專案網站及app的項目設計。</h4>
        </v-col>
        <v-col cols="10" class="ma-0 d-flex justify-center mx-auto text-center"><v-divider inset></v-divider></v-col>
        <v-col cols="10" justify="center" class="ma-0 d-flex flex-wrap mx-auto justify-center text-center">
          <v-col col="12" lg="3" sm="3" class="my-1 text--blue">
            <v-icon color="blue" class="mr-1">mdi-facebook</v-icon>
            <a href="#" class="text-decoration-none">garywang.0505</a>
          </v-col>
          <v-col col="12" lg="3" sm="3" class="my-1 text--blue">
            <v-icon color="blue" class="mr-1">mdi-linkedin</v-icon>
            <a href="#" class="text-decoration-none">garywang.0505</a></v-col>
          <v-col col="12" lg="3" sm="3" class="my-1 text--blue">
            <v-icon color="blue" class="mr-1">mdi-instagram</v-icon>
            <a href="#" class="text-decoration-none">garywang.0505</a></v-col>
          <v-col col="12" lg="3" sm="3" class="my-1 text--blue">
            <v-icon  color="blue" class="mr-1">mdi-web</v-icon>
            <a href="#" class="text-decoration-none">garywang.0505</a>
          </v-col>
        </v-col>
        
      </v-col>

      <!-- 教育 -->
      <v-col
        justify="center"
        cols="12"
        class="ma-0 py-5 justify-center text-center grey lighten-4"
      >
        <v-col col="12" lg="12" sm="12" class="my-1 d-flex justify-center text-center">
          <h2 class="d-flex justify-center text-center my-2">
            教育經歷
          </h2>
        </v-col>
        <v-col cols="10" justify="center" class="ma-0 d-flex flex-wrap mx-auto justify-center text-center">
          <v-timeline
    align-top
    :dense="$vuetify.breakpoint.smAndDown"
  >
    <v-timeline-item
      v-for="(edu, i) in edus"
      :key="i"
      :color="edu.color"
      :icon="edu.icon"
      fill-dot
      small
    >
 
      <v-card
        :color="edu.color"
        dark
        width="800"
      >

        <v-card-title class="pa-5 pt-3 pl-5"
        v-text="edu.school"
        >
        </v-card-title>
        <v-card-subtitle class="primary--text white pa-1 pt-2 pl-3 text-left"
        v-text="edu.major"
        ></v-card-subtitle>
        <v-card-text class="white grey--text pa-1 pt-2 pl-3 text-left"
        v-text="edu.year"
        >
        
        </v-card-text>
      </v-card>
    </v-timeline-item>
  </v-timeline>
        </v-col>
      </v-col>

      <!-- 工作經歷 -->
      <v-col
        justify="center"
        cols="12"
        class="ma-0 py-5 justify-center text-center white lighten-4"
      >
        <v-col col="12" lg="12" sm="12" class="my-1 d-flex justify-center text-center">
          <h2 class="d-flex justify-center text-center my-2">
            工作經歷
          </h2>
        </v-col>
        <v-col cols="10" justify="center" class="ma-0 d-flex flex-wrap mx-auto justify-center text-center">
          <v-timeline
    align-top
    :dense="$vuetify.breakpoint.smAndDown"
  >
    <v-timeline-item
      v-for="(job, i) in jobs"
      :key="i"
      :color="job.color"
      :icon="job.icon"
      fill-dot
      small
    >
 
      <v-card
        :color="job.color"
        dark
        width="1000"
      >

        <v-card-title class="pa-5 pt-3 pl-5"
        v-text="job.jobtitle"
        >
        </v-card-title>
        <v-card-subtitle class="blue-grey--text white pa-1 pt-2 pl-3 text-left"
        v-text="job.company"
        ></v-card-subtitle>
        <v-card-text class="white black--text pa-1 pt-2 pl-3 text-left"
        v-text="job.work"
        >
        
        </v-card-text>
      </v-card>
    </v-timeline-item>
  </v-timeline>
        </v-col>
      </v-col>
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
        src: require("../assets/webistebanner.png"),
      },
    ],
    edus: [
        {
          color: 'blue darken-2',
          icon: 'mdi-star',
          school: 'XX大學',
          major:'軟體工程與數位創意學位學程',
          year:'2000/9-2020/12',
        },
        {
          color: 'blue darken-2',
          icon: 'mdi-book-variant',
          school: 'xx高中',
          major:'資處科',
          year:'2000/9-2020/12',
        },
      ],
      jobs: [
        {
          color: 'blue-grey',
          icon: 'mdi-star',
          company: '好厲害科技股份有限公司',
          jobtitle:'UI設計師',
          work:'VI/Media Kit/平面/海報/型錄/DM/EDM/banner 網站維護/專案網站建置/APP/UI設計 設計製作平面、海報、型錄、DM及EDM…等各種輸出設計 banner、電子報、EDM、電子賀卡、活動專案網頁、UI…等設計',
        },
        {
          color: 'blue-grey',
          icon: 'mdi-book-variant',
          company: '好棒棒科技股份有限公司',
          jobtitle:'網頁前端工程師',
          work:'VI/Media Kit/平面/海報/型錄/DM/EDM/banner 網站維護/專案網站建置/APP/UI設計 設計製作平面、海報、型錄、DM及EDM…等各種輸出設計 banner、電子報、EDM、電子賀卡、活動專案網頁、UI…等設計',
        },
      ],
  }),
  methods: {
    getUser() {
      http.get("/user/all").then((response) => {
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
          responseType: "arraybuffer",
        })
        .then((response) => {
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
    },
  },
};
</script>
