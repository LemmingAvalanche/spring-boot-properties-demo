package com.norse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Map;

@Component
public class Print {

    private final StandardEnvironment stdEnv;

    @Autowired
    public Print(StandardEnvironment stdEnv) {
        this.stdEnv = stdEnv;
    }

    @PostConstruct
    public void logProperties() {
        // Source: https://stackoverflow.com/a/66665784/1725151
        final Map<String, Object> collect = stdEnv.getPropertySources()
                .stream()
                .filter(EnumerablePropertySource.class::isInstance)
                .map(EnumerablePropertySource.class::cast)
                .map(EnumerablePropertySource::getPropertyNames)
                .flatMap(Arrays::stream)
                // .filter(s -> whiteListedProps.contains(s))
                .collect(java.util.HashMap::new, (a, e) -> a.put(e, stdEnv.getRequiredProperty(e)), Map::putAll);
        System.out.println("Subset of active properties (based on whitelist): " + collect);
        System.out.println("(end of properties print)");
    }
}
