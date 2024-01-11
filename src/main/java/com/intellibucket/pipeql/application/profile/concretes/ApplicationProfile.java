package com.intellibucket.pipeql.application.profile.concretes;

public enum ApplicationProfile {
    DEVELOPMENT{
        @Override
        public String resourcePath() {
            return "src/main/resources/";
        }
    },
    PRODUCTION{
        @Override
        public String resourcePath() {
            return "resources/";
        }
    };

    public static ApplicationProfile getProfile(String profile) {
        try {
            return ApplicationProfile.valueOf(profile.toUpperCase());
        }catch (Exception e) {
            return ApplicationProfile.DEVELOPMENT;
        }
    }

    public abstract String resourcePath();
}
