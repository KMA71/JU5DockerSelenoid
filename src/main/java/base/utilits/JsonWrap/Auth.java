package base.utilits.JsonWrap;

public class Auth {
    private Result result;
    private String[] messages;

    public Result getResult() {
        return result;
    }

    public void setResult(String token, int exp, String refreshToken) {

        this.result = new Result(token, exp, refreshToken);
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    class Result {
        private String token;
        private int exp;
        private String refreshToken;

        public Result(String token, int exp, String refreshToken) {
            this.token = token;
            this.exp = exp;
            this.refreshToken = refreshToken;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
}
