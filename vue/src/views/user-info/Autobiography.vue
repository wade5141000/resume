<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="5"></theStepper>
      <v-expansion-panels
        v-model="panel"
        multiple
        class="mt-4"
        v-if="confirm && !pickInfo"
      >
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">自傳</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
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
                  label="自傳(中文)"
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="2000"
                  counter="2000"
                  v-model="autobiography.chinese"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row class="mt-6" no-gutters justify="center">
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
                  label="自傳(英文)"
                  outlined
                  rows="6"
                  auto-grow
                  no-resize
                  maxLength="4000"
                  counter="4000"
                  v-model="autobiography.english"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
              <v-col cols="3" md="3" lg="3">
                <v-btn depressed large block color="primary" to="/skill"
                  >上一步</v-btn
                >
              </v-col>
              <v-col cols="3" md="3" lg="3">
                <v-btn depressed large block color="primary" @click="save"
                  >儲存</v-btn
                >
              </v-col>
              <v-col cols="3" md="3" lg="3">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  @click="pickInfo = true"
                  >挑選履歷版型</v-btn
                >
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
      <!-- 填寫自傳注意事項 -->
      <v-card class="mx-auto my-5 pa-0" v-if="!confirm">
        <v-row class="ma-0 py-5" justify="center">
          <v-col cols="9" md="4" lg="4" class="px-5 pt-5">
            <div justify="end">
              <v-responsive>
                <v-img src="../../assets/aboutme.svg" max-height="350" contain>
                </v-img>
              </v-responsive>
            </div>
          </v-col>
          <v-col cols="9" md="5" lg="5" class="px-5 pt-0">
            <div justify="start" class="my-4">
              <h3 justify="center">自傳（Autobiography）</h3>
              <p class="subtitle-2 my-2">
                主要目的在於說服人資主管為什麼該選擇你進入面試階段，和另外一項求職文件『求職信』有異曲同工之妙。
              </p>
              <p class="subtitle-2 my-2">
                建議求職者於撰寫自傳時，可以多展現自己適合該職缺/公司的個人特質及工作價值觀，同時利用自己的個人興趣及背景經歷做背書；此外，可以附上自己的職涯規劃。
              </p>
            </div>
            <v-row justify="start" class="mb-2">
              <v-col cols="10" md="5" lg="5">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  @click="confirm = true"
                  >我瞭解了，開始填寫自傳！</v-btn
                >
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-card>

      <!-- 開始套用履歷 -->
      <v-card class="mx-auto my-5 pa-0" v-if="pickInfo">
        <v-row class="ma-0 py-5" justify="center">
          <v-col cols="9" md="9" lg="9" class="px-5 pt-5">
            <div justify="center">
              <v-responsive>
                <v-img
                  src="../../assets/certification.svg"
                  max-height="300"
                  contain
                >
                </v-img>
              </v-responsive>
            </div>
          </v-col>
          <v-col cols="9" md="9" lg="9" class="px-5 pt-0">
            <div justify="center" class="my-4">
              <p class="subtitle-2 my-2 text-center">
                已經完成了履歷撰寫，現在讓我們來挑選要套用的版型吧！
              </p>
            </div>
            <v-row justify="center" class="mb-2">
              <v-col cols="10" md="5" lg="5">
                <v-btn depressed large block color="primary" to="/resume"
                  >立即挑選履歷版型！</v-btn
                >
              </v-col>
            </v-row>
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
    theDialog
  },
  created() {
    http.get("/user").then(response => {
      this.autobiography.chinese = response.data.bioChn;
      this.autobiography.english = response.data.bioEng;
    });
  },
  data: () => ({
    panel: [0],
    autobiography: {
      chinese: "",
      english: ""
    },
    confirm: false,
    pickInfo: false
  }),
  methods: {
    save() {
      console.log(this.autobiography);
      http.put("/user/autobiography", this.autobiography).then(response => {
        console.log(response);
        if (response.data === true) {
          alert("更新成功");
        } else {
          alert("更新失敗");
        }
      });
    }
  }
};
</script>

<style scoped></style>
