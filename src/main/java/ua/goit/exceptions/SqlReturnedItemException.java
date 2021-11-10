/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.exceptions;

public class SqlReturnedItemException extends RuntimeException {
    public SqlReturnedItemException(String message) {
        super(message);
    }
}