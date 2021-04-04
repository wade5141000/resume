<template>
  <div>
    <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>
    <v-btn
      v-for="(item, index) in links"
      :key="index"
      text
      :to="item.link"
      color="white"
    >
      {{ item.text }}
    </v-btn>
  </div>
</template>

<script>
export default {
  data: () => ({
    links: [
      { text: "Home", link: "/" },
      { text: "Login", link: "/login" },
      { text: "About", link: "/about" }
    ]
  })
};
</script>
