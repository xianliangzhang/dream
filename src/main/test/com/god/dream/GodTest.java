package com.god.dream;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Willer on 16/4/4.
 */
public class GodTest {
    enum Color {
        RED("红色", 1), GREEN("绿色", 2);

        private String color;
        private int index;

        Color(String tag, int index) {
            this.color = tag;
            this.index = index;
        }

        public String toString() {
            return this.color;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.RED + ", " + Color.RED.ordinal() + Color.RED.index);
    }
}
