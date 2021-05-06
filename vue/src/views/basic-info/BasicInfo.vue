<template>
  <div class="mx-auto mt-6" style="max-width: 35%">
    <!-- TODO max width 要刪除 -->
    <v-expansion-panels v-model="panel" multiple>
      <v-expansion-panel disabled>
        <v-expansion-panel-header color="blue">
          <span style="color: white">基本資料</span>
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <v-row class="mt-6" no-gutters>
            <v-col cols="12">
              <span class="ml-14">姓名</span>
              <div class="mx-auto mt-2" style="max-width: 80%">
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <span class="ml-14">生日</span>
              <div class="mx-auto mt-2" style="max-width: 80%">
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
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <span class="ml-14">聯絡電話</span>
              <div class="mx-auto mt-2" style="max-width: 80%">
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <span class="ml-14">駕駛執照</span>
              <div class="mx-auto mt-2" style="max-width: 80%">
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <span class="ml-14">特殊身份</span>
              <div class="mx-auto mt-2" style="max-width: 80%">
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <span class="ml-14">自我簡介</span
              ><span style="float: right" class="mr-14"
                ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
              >
              <div class="mx-auto mt-2" style="max-width: 80%">
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </div>
            </v-col>
          </v-row>
          <v-btn @click="test">test</v-btn>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
  </div>
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
    user: {
      militaryService: 0
    }
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
    }
  }
};
</script>

<style scoped>
span {
  color: dodgerblue;
}
</style>
