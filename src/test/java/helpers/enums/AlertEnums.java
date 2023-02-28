package helpers.enums;

public class AlertEnums {

    public enum AlertMessages {
        AUTHENTICATION_FIELD("Authentication failed."),
        RESET_YOUR_PASSWORD("If this email address has been registered in our shop, you will receive a link to reset your password at"),
        INVALID_FORMAT("Invalid format."),
        FIRST_NAME_TOO_LONG("The first name field is too long (255 chars max)."),
        INVALID_DATE_FORMAT ("Format should be 05/31/1970.");


        private final String alertMessage;

        AlertMessages(String alertMessage) {
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage() {
            return this.alertMessage;
        }
    }
}
