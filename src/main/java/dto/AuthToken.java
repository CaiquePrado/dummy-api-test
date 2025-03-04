package dto;

public record AuthToken(String token) {
    private static AuthToken instance;

    public static void setToken(String newToken) {
        instance = new AuthToken(newToken);
    }

    public static String getToken() {
        return instance != null ? instance.token() : null;
    }
}
