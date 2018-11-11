package in.co.myrupee.model;

public class TokenInfo {

    private String token;
    private long createdTime;

    public TokenInfo(String token, long createdTime) {
        this.token = token;
        this.createdTime = createdTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
