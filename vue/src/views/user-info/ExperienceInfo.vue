<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="10" class="mt-6">
      <theStepper step="3"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">工作經歷</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>公司名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="experience.companyName"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>職務名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="experience.position"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>任職期間</span>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
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
                      v-model="experience.startDate"
                      outlined
                      dense
                      prepend-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                      placeholder="請選擇日期"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker"
                    v-model="experience.startDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickStartDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-menu
                  ref="menu2"
                  v-model="menu2"
                  :close-on-content-click="false"
                  transition="scale-transition"
                  offset-y
                  min-width="auto"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                      v-model="experience.endDate"
                      outlined
                      dense
                      prepend-icon="mdi-calendar"
                      readonly
                      v-bind="attrs"
                      v-on="on"
                      placeholder="請選擇日期"
                      class="ml-6"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    ref="picker2"
                    v-model="experience.endDate"
                    :max="new Date().toISOString().substr(0, 10)"
                    min="1950-01-01"
                    @change="pickEndDate"
                  ></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>工作描述</span>
              </v-col>
              <v-col cols="6" md="5" lg="4" class="d-flex justify-end">
                <span
                  ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
                ></v-col
              >
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  outlined
                  placeholder="假如你應徵的職位很看重某項工作技能，而你在某間公司得到的經驗，剛好可以佐證你具有相關能力，足以應付未來的挑戰。這時你必須把它放進工作經歷內並詳細描述說明。"
                  v-model="experience.experienceDesc"
                  rows="5"
                  auto-grow
                  no-resize
                  maxLength="500"
                  counter="500"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>工作技能</span>
                <v-text-field
                  outlined
                  dense
                  v-model="ability"
                  v-on:keyup.enter="onAbilityEnter()"
                  maxLength="20"
                  counter="20"
                  placeholder="輸入完畢按下【Enter】鍵完成新增"
                ></v-text-field>
                <v-chip
                  v-for="(item, index) in abilities"
                  v-bind:key="index"
                  close
                  color="blue"
                  text-color="white"
                  class="mr-2 mb-2"
                  @click:close="close(item)"
                >
                  {{ item }}
                </v-chip>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center" class="my-6">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
                  >下一步</v-btn
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
export default {
  components: {
    theStepper
  },
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    }
  },
  data: () => ({
    panel: [0],
    menu: false,
    menu2: false,
    experience: {},
    ability: "",
    abilities: []
  }),
  methods: {
    pickStartDate(date) {
      this.$refs.menu.save(date);
    },
    pickEndDate(date) {
      this.$refs.menu2.save(date);
    },
    nextStep() {
      this.experience.ability = this.abilities.join(",");
      console.log(this.experience);
      this.$router.push("/skill");
    },
    onAbilityEnter() {
      if (this.ability.length > 0) {
        this.abilities.push(this.ability);
        this.ability = "";
      }
    },
    close(str) {
      this.abilities = this.abilities.filter(item => item !== str);
    }
  }
};
</script>

<style scoped>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
