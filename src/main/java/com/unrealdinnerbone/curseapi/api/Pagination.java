package com.unrealdinnerbone.curseapi.api;

import java.util.Optional;

public record Pagination(int index, int pageSize, int resultCount, Integer totalCount) {}
