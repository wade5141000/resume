<template>
  <v-row justify="center">
    <v-col cols="10" md="10" lg="10">
      <v-card>
        <v-tabs color="primary" left class="pa-5">
          <v-tab><h3>我的履歷</h3></v-tab>

          <v-tab-item v-for="n in 1" :key="n">
            <v-row dense fluid>
              <v-col
                class="mt-5"
                v-for="(item, index) in resumeList"
                :key="index"
                cols="3"
                md="3"
                lg="3"
              >
                <v-card class="ma-1">
                  <v-img
                    :src="
                      `https://picsum.photos/500/300?image=${(index + 1) * 5 +
                        10}`
                    "
                    :lazy-:src="
                      `https://picsum.photos/500/300?image=${(index + 1) * 5 +
                        10}`
                    "
                    class="white--text align-end"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                    height="350px"
                    aspect-ratio="1"
                  >
                    <v-card-title v-text="item.resumeName"></v-card-title>
                  </v-img>

                  <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn icon>
                      <v-icon title="預覽履歷" alt="預覽履歷"
                        >mdi-eye-outline</v-icon
                      >
                    </v-btn>

                    <v-btn icon @click="remove(item.id)">
                      <v-icon title="刪除履歷" alt="刪除履歷"
                        >mdi-trash-can-outline</v-icon
                      >
                    </v-btn>

                    <v-btn icon @click="apply(item.id)">
                      <v-icon title="套用履歷" alt="套用履歷"
                        >mdi-bookmark-box-multiple-outline</v-icon
                      >
                    </v-btn>
                    <v-btn icon @click="download">
                      <v-icon title="下載履歷" alt="下載履歷"
                        >mdi-file-download-outline</v-icon
                      >
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-tab-item>
        </v-tabs>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import http from "../../utils/http";
export default {
  watch: {},
  created: function() {
    this.templateId = this.$route.query.templateId;
    this.getResume();
  },
  data: () => ({
    resumeList: [],
    templateId: 0
  }),
  methods: {
    getResume() {
      http.get("/resume").then(response => {
        this.resumeList = response.data;
      });
    },
    remove(resumeId) {
      http.delete("/resume/" + resumeId).then(response => {
        if (response.data == true) {
          alert("刪除成功");
          this.getResume();
        } else {
          alert("刪除失敗");
        }
      });
    },
    apply(resumeId) {
      if (this.templateId > 0) {
        http
          .put("/resume/".concat(resumeId, "/template/", this.templateId))
          .then(response => {
            if (response.data == true) {
              this.$router.push({ path: "/apply-info", query: { resumeId } });
            } else {
              alert("操作失敗");
            }
          });
      } else {
        this.$router.push({ path: "/template-list", query: { resumeId } });
      }
    },
    download() {}
  }
};
</script>
