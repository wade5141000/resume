<template>
  <v-row justify="center">
    <v-col cols="12" sm="12" md="8" lg="6" class="px-12">
      <v-expansion-panels v-model="panel" multiple>
        <v-expansion-panel disabled>
          <v-expansion-panel-header color="blue">
            <span class="white--text">基本資料</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters>
              <v-spacer />
              <v-col cols="12" md="10" lg="8">
                <span>姓名</span>
                <div class="mx-auto mt-2">
                  <v-text-field
                    outlined
                    dense
                    v-model="user.name"
                  ></v-text-field>
                </div>
              </v-col>
              <v-spacer />
            </v-row>
            <v-row no-gutters>
              <v-spacer />
              <v-col cols="12" sm="12" md="8" lg="8">
                <span>生日</span>
                <div class="mx-auto mt-2">
                  <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    transition="scale-transition"
                    offset-y
                    min-width="auto"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        v-model="user.birthday"
                        outlined
                        dense
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      ref="picker"
                      v-model="user.birthday"
                      :max="new Date().toISOString().substr(0, 10)"
                      min="1950-01-01"
                      @change="pickDate"
                    ></v-date-picker>
                  </v-menu>
                </div>
              </v-col>
              <v-spacer />
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">性別</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-radio-group v-model="user.sex" row>
                    <v-radio label="男" value="0"></v-radio>
                    <v-radio label="女" value="1"></v-radio>
                  </v-radio-group>
                </div>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">兵役狀況</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-select
                    :items="militaryItems"
                    outlined
                    v-model="user.militaryService"
                  ></v-select>
                </div>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">通訊地址</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-text-field
                    outlined
                    dense
                    v-model="user.address"
                  ></v-text-field>
                </div>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">email</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-text-field
                    outlined
                    dense
                    v-model="user.email"
                  ></v-text-field>
                </div>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">聯絡電話</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-text-field
                    outlined
                    dense
                    v-model="user.phone"
                  ></v-text-field>
                </div>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">駕駛執照</span>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="輕型機車50CC"
                  value="a"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="重型機車50~250CC"
                  value="b"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="汽車駕駛執照"
                  value="c"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="driverLicense"
                  label="無"
                  value="d"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">特殊身份</span>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="外籍人士"
                  value="a"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="原住民"
                  value="b"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="二度就業"
                  value="c"
                ></v-checkbox>
              </v-col>
              <v-col cols="3">
                <v-checkbox
                  v-model="specialIdentity"
                  label="身心障礙"
                  value="d"
                ></v-checkbox>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">自我簡介</span
                ><span style="float: right" class="mr-14"
                  ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
                >
                <v-textarea
                  outlined
                  label="簡單描述特長、成就，讓企業快速瞭解你"
                  v-model="user.introduction"
                  rows="3"
                  no-resize
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">個人特色</span>
                <div class="mx-auto mt-2" style="max-width: 80%">
                  <v-text-field
                    outlined
                    dense
                    v-model="feature"
                    v-on:keyup.enter="onFeatureEnter()"
                    maxLength="10"
                    counter="10"
                  ></v-text-field>
                </div>
                <v-chip
                  v-for="(item, index) in features"
                  v-bind:key="index"
                  close
                  color="blue"
                  text-color="white"
                  @click:close="close(item)"
                >
                  {{ item }}
                </v-chip>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col cols="12">
                <span class="ml-14">個人連結</span>
                <v-text-field outlined dense></v-text-field>
              </v-col>
            </v-row>
            <v-btn @click="test">test</v-btn>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-col>
  </v-row>
</template>

<script>
import theStepper from "../../components/theStepper";

export default {
  components: {
    theStepper
  },
  data: () => ({
    panel: [0],
    menu: false,
    militaryItems: [
      { text: "已服役", value: 1 },
      { text: "未服役", value: 0 }
    ],
    driverLicense: [],
    specialIdentity: [],
    user: {
      militaryService: 0
    },
    feature: "",
    features: []
  }),
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    }
  },
  methods: {
    pickDate(date) {
      this.$refs.menu.save(date);
    },
    test() {
      console.log(this.user);
      console.log(this.driverLicense);
      console.log(this.features);
    },
    onFeatureEnter() {
      if (this.feature.length > 0) {
        this.features.push(this.feature);
        this.feature = "";
      }
    },
    close(str) {
      this.features = this.features.filter(item => item !== str);
    }
  }
};
</script>

<style scoped>
span {
  color: dodgerblue;
}
</style>
