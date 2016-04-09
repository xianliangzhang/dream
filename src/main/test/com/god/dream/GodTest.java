package com.god.dream;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Willer on 16/4/4.
 */
public class GodTest {
    public interface Destination {
        public String readLabel();
    }

    public Destination destination() {
        class MyDestination implements Destination {
            public String readLabel() {
                return "God Is Dead";
            }
        }
        return new MyDestination();
    }

    public Destination destination2() {
        return new Destination() {
            @Override
            public String readLabel() {
                return "God Is Dead";
            }
        };
    }
    public static void main(String[] args) {
        System.out.println("God Is Dead!");
    }
}
