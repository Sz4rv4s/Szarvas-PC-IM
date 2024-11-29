import type { Config } from "tailwindcss";

export default {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "#003366",
        foreground: "var(--foreground)",
      },
      fontFamily: {
        OpenSans: ["var(--font-open-sans)", "sans-serif"],
      }
    },
  },
  plugins: [],
} satisfies Config;
