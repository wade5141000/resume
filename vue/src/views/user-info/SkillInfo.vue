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
            <v-row class="mt-6" justify="center">
              <v-col cols="12" md="10" lg="8">
                <span></span>
                <v-text-field label="專長名稱" outlined dense></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8" class="d-flex justify-end">
                <theDialog>
                  <template v-slot:btn>
                    <v-icon color="blue">mdi-chat-question</v-icon>看看範例
                  </template>
                </theDialog>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  label="專長描述"
                  outlined
                  rows="3"
                  auto-grow
                  no-resize
                  maxLength="100"
                  counter="100"
                ></v-textarea>
              </v-col>
            </v-row>
            <v-row justify="center" class="mb-2">
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
import theDialog from "../../components/theDialog";
export default {
  components: {
    theStepper,
    theDialog
  },
  data: () => ({
    panel: [0],
    skill: {}
  }),
  methods: {
    nextStep() {
      this.$router.push("/language-license");
    }
  }
};
</script>

<style>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
