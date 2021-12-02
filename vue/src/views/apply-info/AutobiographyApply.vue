<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="5"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">套用自傳</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row no-gutters class="mt-6" justify="center">
              <!--              <v-col cols="10" md="10" lg="10">-->
              <!--                <v-alert outlined type="error" prominent border="left">-->
              <!--                  <h3 justify="center" class="my-green">-->
              <!--                    請勾選 <strong>8</strong> 項，欲顯示在履歷表中的項目-->
              <!--                  </h3>-->
              <!--                  您目前已勾選 4 項，若有不足，將以空白呈顯。-->
              <!--                </v-alert>-->
              <!--              </v-col>-->
              <v-col cols="10" md="10" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  label="自傳(中文)"
                  color="red darken-3"
                  :value="true"
                  v-model="bioCh"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  label="自傳(英文)"
                  color="red darken-3"
                  :value="true"
                  v-model="bioEn"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row justify="center" class="mb-2">
              <v-col cols="6" md="5" lg="4">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  :to="'/skillinfo-apply?resumeId=' + this.resume.id"
                  >回上一頁</v-btn
                >
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
                  >儲存</v-btn
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
import theStepper from "../../components/theStepperApply";
import theDialog from "../../components/theDialog";
import http from "../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  watch: {},
  created: function() {
    http.get("/resume/" + this.$route.query.resumeId).then(response => {
      this.resume = response.data;
      this.bioCh = this.resume.bioCh;
      this.bioEn = this.resume.bioEn;
    });
  },
  data: () => ({
    panel: [0],
    bioCh: false,
    bioEn: false,
    resume: {}
  }),
  methods: {
    nextStep() {
      // console.log(this.bioCh);
      // console.log(this.bioEn);
      http
        .put("/resume/" + this.resume.id + "/bio", {
          bioCh: this.bioCh,
          bioEn: this.bioEn
        })
        .then(response => {
          if (response.data == true) {
            alert("成功");
          } else {
            alert("操作失敗");
          }
        });
    }
  }
};
</script>
