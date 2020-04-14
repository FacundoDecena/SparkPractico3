package util;

import lombok.Getter;


public class Path {

    public static class Web {
        @Getter public static final String API = "/api/";
        @Getter public static final String API_MOVIE_DIRECTOR = "/api/md";
        @Getter public static final String API_MOVIE_ACTOR = "/api/ma";
        @Getter public static final String LOGIN = "/login";
        @Getter public static final String HOME = "/home";
        @Getter public static final String ADD = "/add";
    }
    
    public static class Template {
        public final static String LAYOUT = "templates/layout.vtl";
        public final static String LOGIN = "templates/login.vtl";
        public final static String HOME = "templates/home.vtl";
    }

}
