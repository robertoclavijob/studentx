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
    }
}
