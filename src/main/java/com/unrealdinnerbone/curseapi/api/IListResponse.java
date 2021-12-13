package com.unrealdinnerbone.curseapi.api;

import java.util.List;

public interface IListResponse<T> extends IResponse<List<T>> {
    List<T> data();
}
