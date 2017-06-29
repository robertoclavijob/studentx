package com.clavisoft.studentx.constant;

/**
 * Possible CLI parameters
 */
public enum CLIParameter {
    NAME {
        public String toString() {
            return "name";
        }
    },
    TYPE {
        public String toString() {
            return "type";
        }
    },
    GENDER {
        public String toString() {
            return "gender";
        }
    };

    /**
     * Get the parameter that corresponds to a given text
     *
     * @param text
     * @return
     */
    public static CLIParameter fromString(String text) {
        for (CLIParameter cliParameter : CLIParameter.values()) {
            if (cliParameter.toString().equalsIgnoreCase(text)) {
                return cliParameter;
            }
        }
        return null;
    }
}
