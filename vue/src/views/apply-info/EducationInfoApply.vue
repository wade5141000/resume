<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="2"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">學歷</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-alert outlined type="error" prominent border="left">
                  <h3 justify="center" class="my-green">
                    請勾選
                    <strong>{{ template.education }}</strong>
                    項，欲顯示在履歷表中的項目
                  </h3>
                  您目前已勾選 {{ selectedCount }} 項，若有不足，將以空白呈顯。
                </v-alert>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card
                  elevation="1"
                  class="mx-auto pa-0"
                  v-for="(education, index) in educations"
                  :key="index"
                >
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <v-checkbox
                      class="white--text"
                      :label="education.schoolName"
                      color="red"
                      :value="education.id"
                      v-model="selected"
                      @change="count"
                    ></v-checkbox>
                  </v-card-title>
                  <v-row class="mx-auto mt-5 ml-10 pa-0">
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>{{ education.schoolName }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>{{ education.major }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>{{ education.status }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>{{ education.country }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>就學日期：{{ education.startDate }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>畢業日期：{{ education.endDate }}</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>在校成績：{{ education.gpa }}</p>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>
            </v-row>

            <v-row justify="center" class="mb-2">
              <v-col cols="6" md="5" lg="4">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  :to="'/apply-info?templateId=' + this.$route.query.templateId"
                  >回上一頁</v-btn
                >
              </v-col>
              <v-col cols="6" md="5" lg="4">
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
    http.get("/education").then(response => {
      this.educations = response.data;
    });

    http.get("/template/" + this.$route.query.templateId).then(response => {
      this.template = response.data;
      console.log(response.data);
    });
  },
  data: () => ({
    panel: [0],
    educations: [],
    selected: [],
    selectedCount: 0,
    template: {}
  }),
  methods: {
    nextStep() {
      console.log(this.selected);
      if (this.selected.length > this.template.education) {
        alert("數量超出限制");
      } else {
        http
          .put("/resume/" + this.template.id + "/education", this.selected)
          .then(response => {
            if (response.data == true) {
              alert("成功");
              this.$router.push(
                "/experienceinfo-apply?templateId=" +
                  this.$route.query.templateId
              );
            } else {
              alert("操作失敗");
            }
          });
      }
    },
    count() {
      this.selectedCount = this.selected.length;
    }
  }
};
</script>
