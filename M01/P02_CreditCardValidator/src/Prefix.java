public enum Prefix {
    VISA(4),
    MASTER(5),
    AMEX(37),
    DISCOVER(6);

    private final int prefix;
    Prefix(int pre) {
        this.prefix = pre;
    }
    public int getPrefix() {
        return prefix;
    }
}
