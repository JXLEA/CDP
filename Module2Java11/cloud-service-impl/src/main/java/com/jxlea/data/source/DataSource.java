package com.jxlea.data.source;

import java.util.Objects;

public interface DataSource {

    void init();

    Object connect();
}
