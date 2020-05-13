package jp.quick.vthp.iniparser;

public class FixtureFactory {

    private FixtureFactory() {}

    public static String fixtureTypical() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("[DATABASE]\n");
        sb.append("SERVER_NAME=(localdb)\\v11.0\n");
        sb.append("DATABASE_NAME=hogehoge\n");
        sb.append("LOGIN_ID=myname\n");
        sb.append("LOGIN_PWD=mypwd\n");
        sb.append("CONNECT_TIMEOUT=30");
        return sb.toString();
    }


    public static String fixtureNoSection() {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER_NAME=(localdb)\\v11.0\n");
        return sb.toString();
    }

    public static String fixtureComment() {
        StringBuilder sb = new StringBuilder();
        sb.append("; this is a comment");
        return sb.toString();
    }

    public static String fixtureSectionNamedQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("[?]");
        sb.append("SERVER_NAME=(localdb)\\v11.0\n");
        return sb.toString();
    }

    public static String fixtureI18nValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("[DATABASE]\n");
        sb.append("SERVER_NAME=サーバー");
        return sb.toString();
    }

    public static String fixtureCommentI18n() {
        StringBuilder sb = new StringBuilder();
        sb.append("; これはコメントです");
        return sb.toString();
    }

}
