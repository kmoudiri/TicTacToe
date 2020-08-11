public enum Flag {
    X,
    O;

    public Flag getNextTurn() {
        if (this == X)
            return O;
        return X;
    }
}
