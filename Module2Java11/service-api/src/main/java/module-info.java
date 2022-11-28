module service.api {
    requires dto;
    exports com.jxlea.service to
            cloud.service.impl;
}