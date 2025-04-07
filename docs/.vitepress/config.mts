import {defineConfig} from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Discord InteraKTions",
  description: "A VitePress Site",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Docs', link: '/docs' }
    ],

    sidebar: [
      {
        text: 'Installation',
        items: [
          { text: "About", link: "/about/about" },
          { text: "Installation", link: "/about/gradle" },
          { text: "Tips", link: "/about/tips" }
        ]
      },

      {
        text: 'Kord',
        items: [
          { text: "Gateway", link: "/kord/bot-gateway" },
          { text: "Webserver", link: "/kord/bot-webserver"}
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/catgirlclient/DiscordInteraKTions' }
    ]
  }
})
