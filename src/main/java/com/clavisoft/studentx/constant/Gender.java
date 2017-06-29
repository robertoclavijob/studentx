package com.clavisoft.studentx.constant;

/**
 * Possible genders
 */
public enum Gender {
    MALE {
        public String toString() {
            return "M";
        }
    },
    FEMALE {
        public String toString() {
            return "F";
        }
    };

    /**
     * Get the gender that corresponds to a given text
     * @param text
     * @return
     */
    public static Gender fromString(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.toString().equalsIgnoreCase(text)) {
                return gender;
            }
        }
        return null;
    }
}
