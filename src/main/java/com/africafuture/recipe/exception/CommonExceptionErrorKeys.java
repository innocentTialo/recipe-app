package com.africafuture.recipe.exception;

public final class CommonExceptionErrorKeys {

	public static final String ERR_CONCURRENCY_FAILURE = "error.exception.concurrencyFailure";
	public static final String ERR_VALIDATION = "error.exception.validation";
	public static final String CONSTRAINT_VIOLATION = "error.exception.constraint-violation";//
	public static final String PARAMETERIZED = "parameterized";//
	public static final String ENTITY_WITH_ID_NOT_FOUND = "error.exception.entity-with-id-not-found";//
	public static final String ENTITY_NOT_FOUND = "error.exception.entity-not-found";//
	public static final String INVALID_PASSWORD = "error.exception.invalid-password";//
	public static final String EMAIL_NOT_FOUND = "error.exception.email-not-found";//
	public static final String EMAIL_EXISTS = "error.exception.emailexists";//
	public static final String ALREADY_EXISTS = "error.exception.already-exists";//
	public static final String INVALID_TWOFACTORCODE_CONFIRMATION = "error.exception.invalid-twofactorcode-confirmation";//
	public static final String INVALID_TWOFACTOR_CODE = "error.exception.invalid-twofactor-code";//
	public static final String ENTITY_STILLREFERENCED = "error.exception.entity-stillreferenced";//
	public static final String ENTITY_DUPLICATE = "error.exception.duplicate-entity";//
	public static final String TOO_MANY_REQUESTS = "error.exception.too-many-request";//
	public static final String EXCEL_IMPORT_EXPORT = "error.exception.excel-import-export";//
	public static final String NOT_AUTHORIZED = "error.exception.not-authorized";//
	public static final String USER_NOT_AUTHENTICATED = "error.exception.user-not-authenticated";
	public static final String INVALID_REGISTRATIONCODE = "error.exception.invalid-registrationcode";
	public static final String INVALID_ACTIVATIONCODE = "error.exception.invalid-activationcode";

	public static final String CANNOT_CREATE_MORE_THAN_ONE_ORGANISATION = "error.exception.cannot-create-more-than-one-organisation";
	public static final String NOT_NULL_AUTH_TOKEN = "error.exception.auth-token-is-null";
	public static final String STORE_NAME_ALREADY_USED ="error.exception.store-name-already-used";
	public static final String MOBILE_NUMBER_NOT_FOUND ="error.exception.mobile-number-not-found";
	public static final String USERNAME_NOT_FOUND ="error.exception.username-not-found";
	public static final String ILLEGAL_STATE ="error.exception.illegal-state";

	public static final String ERROR_VALIDATION = "error.exception.error-validation";
	public static final String ERROR_CONCURRENCY_FAILURE = "error.exception.error-concurrencyFailure";
	public static final String ERROR_DUPLICATE = "error.exception.duplicate";


	public static final String ERROR_EMAIL_NOT_FOUND = "error.exception.email.not-found";
	public static final String ERROR_EMAIL_DUPLICATE = "error.exception.email.duplicate";
	public static final String ERROR_EMAIL_REQUIRED = "error.exception.email.required";
	public static final String ERROR_EMPLOYEE_CANNOT_ACTIVATED = "error.exception.employee.cannot-activate";
	public static final String ERROR_EMPLOYEE_CANNOT_DEACTIVATED = "error.exception.employee.cannot-deactivate";
	public static final String ERROR_EMPLOYEE_DUPLICATE = "error.exception.employee.duplicate";
	public static final String ERROR_EMPLOYEE_NOT_EDITABLE = "error.exception.employee.not-editable";
	public static final String ERROR_ENTITY_DUPLICATE = "error.exception.entity.duplicate";
	public static final String ERROR_ENTITY_STILL_REFERENCED = "error.exception.entity.still-referenced";
	public static final String ERROR_INTERNAL_SERVER_ERROR = "error.exception.internal-server-error";

	public static final String ERROR_ORGANISATION_ID_NOT_FOUND = "error.exception.organisation-id-not-found";
	public static final String ERROR_USER_ID_NOT_FOUND = "error.exception.user-id-not-found";
	public static final String ERROR_USER_NOT_FOUND = "error.exception.user-not-found";
	public static final String ERROR_ID_NOT_FOUND = "error.exception.id-not-found";
	public static final String NOT_REGISTERED_LOGIN = "error.exception.not-registered-login";
	public static final String USER_ALREADY_EXISTS = "error.exception.user-already-exists";
	public static final String ID_ALREADY_EXISTS = "error.exception.id-already-exists";
	public static final String ID_IS_NULL = "error.exception.id-is-null";
	public static final String NOT_REGISTERED_MOBILENUMBER = "error.exception.not-registered-mobilenumber";
	public static final String INVALID_PHONE_NUMBER = "error.exception.invalid-phone-number";
    public static final String ASSET_NOT_FOUND = "error.exception.asset-not-found";
	public static final String USER_ROLE_NOT_FOUND = "error.exception.user_role_not_found";
	public static final String ROLE_TYPE_NOT_FOUND = "error.exception.role_type_not_found";
	public static final String USER_WITH_KEY_NOT_FOUND = "error.exception.user_with_key_not_found";
    public static final String OWNERSHIP_VIOLATION = "error.exception.ownership_violation";
    public static final String CUSTOMER_ACCOUNT_NOT_FOUND = "error.exception.customer_account_not_found";

	private CommonExceptionErrorKeys() {
	}
}
