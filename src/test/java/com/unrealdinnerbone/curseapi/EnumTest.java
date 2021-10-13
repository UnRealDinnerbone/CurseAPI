package com.unrealdinnerbone.curseapi;

import com.squareup.moshi.Moshi;
import com.unrealdinnerbone.curseapi.lib.json.EnumJsonAdapter;
import com.unrealdinnerbone.curseapi.lib.json.IID;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class EnumTest
{
    public static final Moshi MOSHI = new Moshi.Builder()
            .add(Tnum.class, EnumJsonAdapter.create(Tnum.class))
            .build();

    public static enum Tnum implements IID {
        ONE(1),
        TWO(2);

        private final int anInt;

        Tnum(int i) {
            this.anInt = i;
        }

        @Override
        public int getId() {
            return anInt;
        }
    }

    @Test
    public void test() throws IOException {
        TestClass testClass = MOSHI.adapter(TestClass.class).fromJson("{\"tnum\": 1,\"two\": 2}");
        Assert.assertEquals(Tnum.ONE, testClass.tnum);
        Assert.assertEquals(Tnum.TWO, testClass.two);
    }

    public static class TestClass {
        private Tnum tnum;
        private Tnum two;
    }
}
