<template>
  <v-card>
    <v-tabs color="primary" left>
      <v-tab>履歷表</v-tab>
      <v-tab>作品集</v-tab>

      <v-tab-item v-for="n in 2" :key="n">
        <!-- <v-container fluid>
          <v-row>
            <v-col v-for="i in 12" :key="i" cols="12" md="2">
              <v-img
                :src="`https://picsum.photos/500/300?image=${i * n * 5 + 10}`"
                :lazy-src="`https://picsum.photos/10/6?image=${i * n * 5 + 10}`"
                aspect-ratio="1"
              ></v-img>
            </v-col>
          </v-row>
        </v-container> -->
        <!-- <v-container fluid> -->
        <v-row dense fluid>
          <v-col v-for="card in 12" :key="card.title" :cols="12" md="2">
            <v-card class="ma-1">
              <v-img
                :src="
                  `https://picsum.photos/500/300?image=${card * n * 6 + 12}`
                "
                :lazy-src="
                  `https://picsum.photos/10/6?image=${card * n * 6 + 12}`
                "
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                height="350px"
                aspect-ratio="1"
              >
                <v-card-title v-text="`Resume${card}`"></v-card-title>
              </v-img>

              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn icon>
                  <v-icon title="預覽履歷">mdi-eye</v-icon>
                </v-btn>

                <v-btn icon>
                  <v-icon title="收藏履歷">mdi-heart</v-icon>
                </v-btn>

                <v-btn icon>
                  <v-icon title="套用履歷">mdi-folder-download</v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
        <!-- </v-container> -->
      </v-tab-item>
    </v-tabs>
  </v-card>
</template>

//
<script>
// export default {
//   data: () => ({
//     cards: [
//       {
//         title: "Pre-fab homes"
//       },
//       {
//         title: "Favorite road trips"
//       },
//       {
//         title: "Best airlines"
//       }
//     ]
//   })
// };
//
</script>
