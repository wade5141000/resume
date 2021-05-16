<template>
  <v-row justify="center">
    <v-col cols="12" md="8" lg="6" class="mt-6">
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
                <v-text-field outlined dense v-model="user.name"></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>職務名稱</span>
                <v-text-field outlined dense v-model="user.name"></v-text-field>
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
                    ref="menu1"
                    v-model="menu1"
                    :close-on-content-click="false"
                    transition="scale-transition"
                    offset-y
                    min-width="auto"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="user.birthday1"
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
                      type="month"
                      v-model="user.birthday1"
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
                        v-model="user.birthday2"
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
                      type="month"
                      v-model="user.birthday2"
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
                  v-model="user.introduction"
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
                  v-model="feature"
                  v-on:keyup.enter="onFeatureEnter()"
                  maxLength="20"
                  counter="20"
                ></v-text-field>
                <v-chip
                  v-for="(item, index) in features"
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
    menu1: false,
    menu2: false,
    user: {
      militaryService: 0
    },
    feature: "",
    features: []
  }),

  methods: {
    pickStartDate(date) {
      this.$refs.menu1.save(date);
    },
    pickEndDate(date) {
      this.$refs.menu2.save(date);
    },
    test() {
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
