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
                      label="天主教輔仁大學"
                      color="red"
                      value="天主教輔仁大學"
                    ></v-checkbox>
                  </v-card-title>
                  <v-row class="mx-auto mt-5 ml-10 pa-0">
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>大學</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>軟體工程與數位創意學位學程</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>畢業</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>台灣</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>就學日期：2009/09/01</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>畢業日期：2022/06/22</p>
                    </v-col>
                    <v-col cols="12" md="6" lg="6" class="pa-0 mt-0">
                      <p>在校成績：87</p>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>

              <v-col cols="10" md="10" lg="10" class="pa-0 mb-2">
                <v-card elevation="1" class="mx-auto pa-0">
                  <v-card-title class="blue lighten-4 mt-8 mb-3 pa-1 pl-4">
                    <v-checkbox
                      class="white--text"
                      label="天主教輔仁大學"
                      color="red"
                      value="天主教輔仁大學"
                    ></v-checkbox>
                  </v-card-title>
                  <v-row class="mx-auto mt-5 ml-10 pa-0">
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>大學</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>軟體工程與數位創意學位學程</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>畢業</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>台灣</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>就學日期：2009/09/01</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>畢業日期：2022/06/22</p>
                    </v-col>
                    <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                      <p>在校成績：87</p>
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
    theDialog
  },
  watch: {},
  created: function() {},
  data: () => ({
    panel: [0]
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
          height: 50
        }
      },
      children
    );
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
