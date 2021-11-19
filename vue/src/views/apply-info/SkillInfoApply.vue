<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="4"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">專業技能</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-alert outlined type="error" prominent border="left">
                  <h3 justify="center" class="my-green">
                    請勾選 <strong>8</strong> 項，欲顯示在履歷表中的項目
                  </h3>
                  您目前已勾選 4 項，若有不足，將以空白呈顯。
                </v-alert>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <p
                      class="v-input--selection-controls v-input--checkbox v-input__control"
                      style="font-size:16px; line-height:20px;"
                    >
                      專業技能
                    </p>
                  </v-card-title>
                  <v-row class="mx-auto mt-2 px-10 pa-0">
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="專長1名稱 &amp; 專長1描述"
                        color="red darken-3"
                        value="專長1名稱 &amp; 專長1描述"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="專長2名稱 &amp; 專長2描述"
                        color="red darken-3"
                        value="專長2名稱 &amp; 專長2描述"
                      ></v-checkbox>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <p
                      class="v-input--selection-controls v-input--checkbox v-input__control"
                      style="font-size:16px; line-height:20px;"
                    >
                      語言能力
                    </p>
                  </v-card-title>
                  <v-row class="mx-auto mt-2 px-10 pa-0">
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="語言類型1名稱 &amp; 語言類型1聽說讀寫"
                        color="red darken-3"
                        value="語言類型1名稱 &amp; 語言類型1聽說讀寫"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="語言類型2名稱 &amp; 語言類型2聽說讀寫"
                        color="red darken-3"
                        value="語言類型2名稱 &amp; 語言類型2聽說讀寫"
                      ></v-checkbox>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <p
                      class="v-input--selection-controls v-input--checkbox v-input__control"
                      style="font-size:16px; line-height:20px;"
                    >
                      證照
                    </p>
                  </v-card-title>
                  <v-row class="mx-auto mt-2 px-10 pa-0">
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="證照名稱1"
                        color="red darken-3"
                        value="證照名稱1"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="證照名稱2"
                        color="red darken-3"
                        value="證照名稱2"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="證照名稱3"
                        color="red darken-3"
                        value="證照名稱3"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="12" lg="12" class="pa-0 mt-0">
                      <v-checkbox
                        label="證照名稱4"
                        color="red darken-3"
                        value="證照名稱4"
                      ></v-checkbox>
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
                  to="/experienceinfo-apply"
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
export default {
  components: {
    theStepper,
    theDialog
  },
  watch: {},
  created: function() {},
  data: () => ({
    panel: [0]
  }),
  methods: {}
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
