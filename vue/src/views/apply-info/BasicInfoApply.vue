<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="1"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">基本資料</span>
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
              <v-col cols="8" md="10" lg="5">
                <v-checkbox
                  label="姓名"
                  color="red darken-3"
                  value="姓名"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="生日"
                  color="red darken-3"
                  value="生日"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="性別"
                  color="red darken-3"
                  value="性別"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="兵役狀況"
                  color="red darken-3"
                  value="兵役狀況"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  label="地址"
                  color="red darken-3"
                  value="地址"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="聯絡電話"
                  color="red darken-3"
                  value="聯絡電話"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="email"
                  color="red darken-3"
                  value="email"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="駕駛執照"
                  color="red darken-3"
                  value="駕駛執照"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="5">
                <v-checkbox
                  label="特殊身份"
                  color="red darken-3"
                  value="特殊身份"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  label="自我簡介"
                  color="red darken-3"
                  value="自我簡介"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  label="個人特色"
                  color="red darken-3"
                  value="個人特色"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-checkbox
                  label="個人連結"
                  color="red darken-3"
                  value="個人連結"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary"
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
import theStepper from "../../components/theStepper";
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
