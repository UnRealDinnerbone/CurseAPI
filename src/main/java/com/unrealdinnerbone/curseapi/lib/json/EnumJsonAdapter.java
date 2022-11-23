package com.unrealdinnerbone.curseapi.lib.json;

import com.squareup.moshi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;


public class EnumJsonAdapter<T extends Enum<T> & IID> extends JsonAdapter<T> {
    private final T[] constants;
    private final T defaultValue;

    public static <T extends Enum<T> & IID> EnumJsonAdapter<T> create(Class<T> enumType, T defaultValue) {

        return new EnumJsonAdapter<>(enumType, defaultValue);
    }

    public EnumJsonAdapter(Class<T> enumType, T defaultValue) {
        constants = enumType.getEnumConstants();
        this.defaultValue = defaultValue;
    }

    @Override
    @FromJson
    @Nullable
    public T fromJson(JsonReader reader) {
        try {
            int id = reader.nextInt();
            for (T constant : constants) {
                if(id == constant.getId()) {
                    return constant;
                }
            }
        }catch(JsonDataException | IOException e) {
            return defaultValue;
        }
        return defaultValue;
    }

    @Override
    @ToJson
    public void toJson(JsonWriter writer, T value) throws IOException {
        writer.value(value.getId());
    }

}