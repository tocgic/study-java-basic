package com.tocgic.exam.study_java_basic.week11;

import javax.annotation.Nonnegative;
import java.util.EnumSet;

public class EnumTest {
    interface IRGBColor {
        String getName();
        int getRed();
        int getGreen();
        int getBlue();
    }
    protected enum Color implements IRGBColor {
        @Nonnegative LEMON("레몬", 0xfefb00) {
            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public int getRed() {
                return super.getRed();
            }

            @Override
            public int getGreen() {
                return super.getGreen();
            }

            @Override
            public int getBlue() {
                return super.getBlue();
            }
        }, LIME("라임", 0x8df900), STRAWBERRY("딸기", 0xff2f92);

        private final int rgb;
        private final String name;
        Color(String name, int rgb) {
            this.name = name;
            this.rgb = rgb;
        }


        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getRed() {
            return (rgb & 0x00FF0000) >> 16;
        }

        @Override
        public int getGreen() {
            return (rgb & 0x0000FF00) >> 8;
        }

        @Override
        public int getBlue() {
            return rgb & 0x000000FF;
        }

    }

//    enum CustomColor extends Color {
//
//    }

    public static void main(String[] args) {
        for (IRGBColor color : Color.values()) {
            System.out.printf("%s, Red:%02X, Green:%02X, Blue:%02X%n", color.getName(), color.getRed(), color.getGreen(), color.getBlue());
        }
        for (Color color : Color.values()) {
            try {
                System.out.println(color.ordinal() + ", " + color.name() + ", " + Color.valueOf(color.name()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println(color.ordinal() + ", " + color.name() + ", " + Color.valueOf(Color.class, color.name()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        EnumSet<Color> colors = EnumSet.allOf(Color.class);
        System.out.println(colors); // [LEMON, LIME, STRAWBERRY]

        EnumSet<Color> emptySets = EnumSet.noneOf(Color.class);
        System.out.println("emptySets.size : " + emptySets.size());
    }
}
