<template>
  <v-row justify="center">
      <v-col cols="10" md="10" lg="10">
      <v-card>
        <v-tabs color="primary" left class="pa-5">
          <v-tab><h3>履歷表模版</h3></v-tab>
          <v-tab><h3>作品集模版</h3></v-tab>

          <v-tab-item v-for="n in 2" :key="n">
            <v-row dense fluid>
              <v-col
                class="mt-5"
                v-for="item in 10"
                :key="item.title"
                cols="3"
                md="3"
                lg="3"
              >
                <v-card class="ma-1" v-viewer>
                  <v-img
                    :src="`https://picsum.photos/500/300?image=${item * 5 + 10}`"
                    :lazy-:src="`https://picsum.photos/500/300?image=${item * 5 + 10}`"
                    class="white--text align-end"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                    height="350px"
                    aspect-ratio="1"
                  >
                    <v-card-title v-text="`履歷模版${item}`"></v-card-title>
                  </v-img>

                  <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn icon>
                      <v-icon title="預覽履歷" alt="預覽履歷">mdi-eye-outline</v-icon>
                    </v-btn>

                    <v-btn icon>
                      <v-icon title="刪除履歷" alt="刪除履歷">mdi-trash-can-outline</v-icon>
                    </v-btn>

                    <v-btn icon>
                      <v-icon title="套用履歷" alt="套用履歷">mdi-bookmark-box-multiple-outline</v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
            <!-- </v-container> -->
          </v-tab-item>
        </v-tabs>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
 
</script>
