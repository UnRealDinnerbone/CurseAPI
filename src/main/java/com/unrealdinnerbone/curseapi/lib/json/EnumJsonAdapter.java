package com.unrealdinnerbone.curseapi.lib.json;

import com.squareup.moshi.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public final class EnumJsonAdapter<T extends Enum<T> & IID> extends JsonAdapter<T> {
    final T[] constants;

    public static <T extends Enum<T> & IID> EnumJsonAdapter<T> create(Class<T> enumType) {
        return new EnumJsonAdapter<>(enumType);
    }

    EnumJsonAdapter(Class<T> enumType) {
        constants = enumType.getEnumConstants();
    }

    @Override
    @FromJson
    public @NotNull T fromJson(JsonReader reader) throws IOException {
        int id = reader.nextInt();
        for (T constant : constants) {
            if(id == constant.getId()) {
                return constant;
            }
        }
        throw new IOException("Invalid number for enum");
    }

    @Override
    @ToJson
    public void toJson(JsonWriter writer, T value) throws IOException {
        writer.value(value.getId());
    }

}