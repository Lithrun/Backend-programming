package nl.hu.bep.spammer.helper;

public final class Configuration {

    private Configuration() {}
    public static final String DBUSER = "Admin";
    public static final String DBPASSWORD = "testtest";
    public static final String DBNAME = "friendspammer";
    public static final String DBURL = "mongodb+srv://"+ DBUSER + ":" + DBPASSWORD + "@ncluster-6ewif.mongodb.net/test?retryWrites=true";

    public static final String SMTPUSER = "6990ab5eee7d3d";
    public static final String SMTPPASSWORD = "02f590ea4a7571";
}
