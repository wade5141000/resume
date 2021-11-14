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
                    請勾選 <strong>8</strong> 項，欲顯示在履歷表中的項目
                  </h3>
                  您目前已勾選 4 項，若有不足，將以空白呈顯。
                </v-alert>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <v-checkbox
                      class="white--text"
                      label="學校名稱"
                      color="white"
                      value="學校名稱"
                    ></v-checkbox>
                  </v-card-title>
                  <v-row class="mx-auto ml-10 pa-0">
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="學歷"
                        color="red darken-3"
                        value="學歷"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="科系名稱"
                        color="red darken-3"
                        value="科系名稱"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="就學狀態"
                        color="red darken-3"
                        value="就學狀態"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="學校地區"
                        color="red darken-3"
                        value="學校地區"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="開始日"
                        color="red darken-3"
                        value="開始日"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="結束日"
                        color="red darken-3"
                        value="結束日"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="在校成績"
                        color="red darken-3"
                        value="在校成績"
                      ></v-checkbox>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <v-checkbox
                      class="white--text"
                      label="學校名稱"
                      color="white"
                      value="學校名稱"
                    ></v-checkbox>
                  </v-card-title>
                  <v-row class="mx-auto ml-10 pa-0">
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="學歷"
                        color="red darken-3"
                        value="學歷"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="科系名稱"
                        color="red darken-3"
                        value="科系名稱"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="就學狀態"
                        color="red darken-3"
                        value="就學狀態"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="學校地區"
                        color="red darken-3"
                        value="學校地區"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="開始日"
                        color="red darken-3"
                        value="開始日"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="結束日"
                        color="red darken-3"
                        value="結束日"
                      ></v-checkbox>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <v-checkbox
                        label="在校成績"
                        color="red darken-3"
                        value="在校成績"
                      ></v-checkbox>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>
            </v-row>

            <v-row justify="center" class="mb-2">
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" to="/apply-info"
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
    theDialog,
  },
  watch: {},
  created: function () {},
  data: () => ({
    panel: [0],
  }),
  methods: {},
  render(h, { children }) {
    return h(
      "v-sheet",
      {
        staticClass: "mt-auto align-center justify-center d-flex px-2",
        props: {
          color: "rgba(0, 0, 0, .36)",
          dark: true,
          height: 50,
        },
      },
      children
    );
  },
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
