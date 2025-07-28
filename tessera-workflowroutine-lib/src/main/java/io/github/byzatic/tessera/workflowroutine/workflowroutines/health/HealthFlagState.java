package io.github.byzatic.tessera.workflowroutine.workflowroutines.health;

public enum HealthFlagState {
    FATAL(-1),
    RUNNING(0),
    COMPLETE(1);

    private final int code;

    HealthFlagState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /**
     * Метод, чтобы получить enum по числу
     * @param code
     * @return
     */
    public static HealthFlagState fromCode(int code) {
        for (HealthFlagState state : values()) {
            if (state.code == code) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

    @Override
    public String toString() {
        return "HealthFlagState{" +
                "code=" + code +
                '}';
    }
}
