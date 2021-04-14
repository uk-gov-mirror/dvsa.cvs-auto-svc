package vott;

import java.util.HashMap;
import java.util.Map;

public enum GrantType {
    IMPLICIT {
        @Override
        public Map<String, Object> formParams() {
            Map<String, Object> formParams = new HashMap<>();

            return formParams;
        }
    },
    CLIENT_CREDENTIALS {
        @Override
        public Map<String, Object> formParams() {
            Map<String, Object> formParams = new HashMap<>();

            return formParams;
        }
    };
    public abstract Map<String, Object> formParams();
}
