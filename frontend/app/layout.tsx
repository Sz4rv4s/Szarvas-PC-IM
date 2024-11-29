import type { Metadata } from "next";
import localFont from "next/font/local";
import "./globals.css";
import React from "react";

const openSans = localFont({
  src: "./fonts/OpenSans-Regular.ttf",
  variable: "--font-OpenSans",
  weight: "100 900",
});

export const metadata: Metadata = {
  title: "Szarvas PC IM",
  description: "Szarvas PC Inventory Manager",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={`${openSans.variable} antialiased`}
      >
        {children}
      </body>
    </html>
  );
}
