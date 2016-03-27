/**
 * 
 */
package com.dexter.labs.app.direct.common.types;

/**
 * Types of App Direct API error codes. Ideally this should be in the XSD and
 * subsequently be in the jaxb generated objects.
 * 
 * @author Babar Jehangir Khan
 *
 */
public enum EErrorCodes {

	USER_ALREADY_EXISTS, USER_NOT_FOUND, ACCOUNT_NOT_FOUND, MAX_USERS_REACHED, UNAUTHORIZED, OPERATION_CANCELLED, CONFIGURATION_ERROR, INVALID_RESPONSE, PENDING, FORBIDDEN, BINDING_NOT_FOUND, TRANSPORT_ERROR, UNKNOWN_ERROR;

}
